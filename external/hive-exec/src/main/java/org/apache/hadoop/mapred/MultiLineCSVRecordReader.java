package org.apache.hadoop.mapred;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.custom.serde.OpenCSVSerde;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * 处理csv字段带有换行符的RecordReader
 *
 * Treats keys as offset in file and value as line.
 * Can correctly handle the value which contains one of CR, LF, or CRLF.
 *
 * @see org.apache.hadoop.mapred.LineRecordReader
 * Created by songgr on 2020/12/10.
 */
public class MultiLineCSVRecordReader implements RecordReader<LongWritable, Text>  {
    private static final Log LOG = LogFactory.getLog(MultiLineCSVRecordReader.class.getName());

    private CompressionCodecFactory compressionCodecs;
    private CompressionCodec codec;
    private long start;
    private long pos;
    private long end;
    private NewLineReader in;
    private FSDataInputStream fileIn;
    /**
     * 单行最大字节数
     * 默认为 Integer.MAX_VALUE
     */
    private int maxLineLength;

    private char separatorChar;
    private char quoteChar;
    private char escapeChar;
    /**
     * 默认行分割符为'\n'
     */
    private final char lineSep = '\n';
    private final int lineSepLen = 1;

    public MultiLineCSVRecordReader(Configuration job, FileSplit split,
                                    String separatorChar,
                                    String quoteChar,
                                    String escapeChar) throws IOException {

        this.separatorChar = separatorChar != null && separatorChar.length() >0 ?
                separatorChar.charAt(0) : OpenCSVSerde.DEFAULT_SEPARATOR;
        this.quoteChar = quoteChar != null && quoteChar.length() >0 ?
                quoteChar.charAt(0) : OpenCSVSerde.DEFAULT_QUOTE_CHARACTER;
        this.escapeChar = escapeChar != null && escapeChar.length() >0 ?
                escapeChar.charAt(0) : OpenCSVSerde.DEFAULT_ESCAPE_CHARACTER;

        this.maxLineLength = job.getInt("mapreduce.input.linerecordreader.line.maxlength",
                Integer.MAX_VALUE);
        start = split.getStart();
        end = start + split.getLength();
        final Path file = split.getPath();
        compressionCodecs = new CompressionCodecFactory(job);
        codec = compressionCodecs.getCodec(file);

        // open the file and seek to the start of the split
        final FileSystem fs = file.getFileSystem(job);
        fileIn = fs.open(file);

        boolean skipFirstLine = false;
        if ( isCompressedInput() ) {
            in = new NewLineReader(codec.createInputStream(fileIn), job);
            end = Long.MAX_VALUE;
        } else {
            if (start != 0) {
                skipFirstLine = true;
                // - lineSep
                this.start -= lineSepLen;
                fileIn.seek(start);
            }
            in = new NewLineReader(fileIn, job);
        }
        if (skipFirstLine) {
            // skip first line and re-establish "start".
            start += in.readLine(new Text(), 0,
                    (int) Math.min((long) Integer.MAX_VALUE, end - start));
        }
        this.pos = start;
    }

    @Override
    public boolean next(LongWritable key, Text value) throws IOException {
        key.set(pos);
        int newSize = 0;
        while (pos < end) {
            newSize = in.readLine(value, maxLineLength,
                    Math.max((int) Math.min(Integer.MAX_VALUE, end - pos),
                            maxLineLength));
            if (newSize == 0) {
                break;
            }
            pos += newSize;
            if (newSize < maxLineLength) {
                break;
            }
            LOG.info("Skipped line of size " + newSize + " at pos " + (pos - newSize));
        }
        if (newSize == 0) {
            key = null;
            value = null;
            return false;
        } else {
            return true;
        }
    }

    @Override
    public LongWritable createKey() {
        return new LongWritable();
    }

    @Override
    public Text createValue() {
        return new Text();
    }

    @Override
    public long getPos() throws IOException {
        return pos;
    }

    @Override
    public void close() throws IOException {
        if (in != null) {
            in.close();
            in = null;
        }
        if (fileIn != null) {
            fileIn.close();
            fileIn = null;
        }
        compressionCodecs = null;
        codec = null;
        LOG.info("MultiLineCSVRecordReader close all resources successfully.");
    }

    @Override
    public float getProgress() throws IOException {
        if (start == end) {
            return 0.0f;
        } else {
            return Math.min(1.0f, (pos - start) / (float) (end - start));
        }
    }

    private boolean isCompressedInput() {
        return (codec != null);
    }

    public class NewLineReader {
        // 默认buffer大小 64Kb
        private static final int DEFAULT_BUFFER_SIZE = 64 * 1024;
        private int bufferSize;
        private InputStream in;
        private byte[] buffer;
        // 当前buffer长度
        private int bufferLength = 0;
        // buffer 位置
        private int bufferPosn = 0;

        public NewLineReader(InputStream in) {
            this(in, DEFAULT_BUFFER_SIZE);
        }

        public NewLineReader(InputStream in, int bufferSize) {
            this.in = in;
            this.bufferSize = bufferSize;
            this.buffer = new byte[this.bufferSize];
        }

        public NewLineReader(InputStream in, Configuration conf)
                throws IOException {
            this(in, conf.getInt("io.file.buffer.size", DEFAULT_BUFFER_SIZE));
        }

        public void close() throws IOException {
            in.close();
        }

        public int readLine(Text str, int maxLineLength, int maxBytesToConsume)
                throws IOException {
            str.clear();
            Text record = new Text();
            int txtLength = 0;
            // 消耗的字节数
            long bytesConsumed = 0L;
            // 是否是新的一行
            boolean newline = false;
            // 行分割符 位置
            int sepPosn = 0;
            boolean wholeQuote = true; // 是否引用完整
            do {
                // 已经读到buffer的末尾了，读下一个buffer
                if (this.bufferPosn >= this.bufferLength) {
                    bufferPosn = 0;
                    bufferLength = in.read(buffer);
                    // 读到文件末尾了，则跳出，进行下一个文件的读取
                    if (bufferLength <= 0) {
                        break;
                    }
                }
                int startPosn = this.bufferPosn;
                boolean forceSplit = false;
                for (; bufferPosn < bufferLength && !forceSplit ; bufferPosn++) {
                    // 如果是字段分割符直接跳过
                    if (buffer[bufferPosn] == separatorChar) {
                        continue;
                    }
                    // 遇到引用符的第一个字符 或者 上一次引号由于buffer满了被切分了
                    if (buffer[bufferPosn] == quoteChar || !wholeQuote) {
                        wholeQuote = false;
                        // 判断接下来的字符是否也是引号中的字符
                        for (int i = 1; !wholeQuote; i++) {
                            // buffer满了，且引号符被不幸地切成了两半
                            if (bufferPosn + i >= bufferLength) {
                                bufferPosn += i - 1; // 回到上一步
                                break;
                            }
                            // 遇到转义字符 注意⚠️：需要先判断转义，不然如果转义和引号符相同的时候就会有问题！
                            if ( buffer[bufferPosn+i] == escapeChar) {
                                // 判断buffer是否满 注意这边直接放了两个字符
                                if ( bufferPosn + i + 1 >= bufferLength) {
                                    forceSplit = true;
                                    bufferPosn += i-1; // 回到上一步
                                }
                                i ++ ; // 指针需要往后移一位
                                continue; // 注意⚠️：️ 只要往后一步 continue 直接到了转义字符的下一位
                            }

                            // 遇上引号符 && 下一个字符是字段分割符 => 引号已经完整
                            if (buffer[bufferPosn+i] == quoteChar && buffer[bufferPosn+i+1] == separatorChar) {
                                wholeQuote = true;
                                // sepPosn重置 避免由于上次由于引号却分导致sepPosn不一致
                                sepPosn = 0;
                                bufferPosn = bufferPosn + i;
                                break;
                            }

                            // 遇上引号符 && 下一个字符是换行符 => 引号完整/直接是下一行
                            // 注意⚠️： 这里要多判断一位是不是引号符，不然字段里出现引号符加换行符就会有问题！
                            if (buffer[bufferPosn+i] == quoteChar && buffer[bufferPosn+i+1] == lineSep && buffer[bufferPosn+i+2] == quoteChar) {
                                wholeQuote = true;
                                newline = true;
                                // sepPosn重置 避免由于上次由于引号却分导致sepPosn不一致
                                sepPosn = 0;
                                bufferPosn = bufferPosn + i + 1; // 移到换行符上
                                break;
                            }

                            // 如果遇到最后一个换行符 直接结束，并且设置wholeQuote=true
                            if (buffer[bufferPosn+i] == lineSep && (bufferPosn+i == bufferLength-1)) {
                                wholeQuote = true;
                                sepPosn = 0;
                                bufferPosn = bufferPosn + i;
                                break;
                            }
                        }
                    }

                    // 遇到行分隔符的第一个字符
                    if (buffer[bufferPosn] == lineSep || newline ) {
                        bufferPosn++;
                        sepPosn++;
                        // 的确遇到了行分隔符 ??
                        if (sepPosn == lineSepLen && wholeQuote) {
                            newline = true;
                            sepPosn = 0;
                            break;
                        }
                    }
                }
                int readLength = this.bufferPosn - startPosn; // 总共读到的长度
                bytesConsumed += readLength; // 加上之前消耗的字节数
                // 控制 maxLineLength 范围
                if (readLength > maxLineLength - txtLength) {
                    readLength = maxLineLength - txtLength;
                }
                if (readLength > 0) {
                    // 从buffer的startPosn位置开始取出真实需要读取的长度 加入到record
                    record.append(this.buffer, startPosn, readLength);
                    txtLength += readLength;
                    // 去掉记录的分隔符
                    if (newline) {
                        // - lineSep
                        str.set(record.getBytes(), 0, record.getLength()
                                - lineSepLen);
                    }
                }
            } while (!newline && (bytesConsumed < maxBytesToConsume));
            if (bytesConsumed > (long) Integer.MAX_VALUE) {
                throw new IOException("Too many bytes before newline: "
                        + bytesConsumed);
            }

            return (int) bytesConsumed;
        }

        public int readLine(Text str, int maxLineLength) throws IOException {
            return readLine(str, maxLineLength, Integer.MAX_VALUE);
        }

        public int readLine(Text str) throws IOException {
            return readLine(str, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
    }
}
