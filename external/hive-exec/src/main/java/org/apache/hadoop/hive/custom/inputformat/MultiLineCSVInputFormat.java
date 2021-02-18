package org.apache.hadoop.hive.custom.inputformat;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.custom.serde.OpenCSVSerde;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.SplittableCompressionCodec;
import org.apache.hadoop.mapred.*;
import tech.sqlclub.common.utils.StringEscapeUtils;

import java.io.IOException;
import java.util.Locale;

/**
 * 处理csv字段带有换行符的InputFormat
 *
 * An {@link InputFormat} for plain text csv files.  Files are broken into lines.
 * Either linefeed or carriage-return are used to signal end of line.  Keys are
 * the position in the file, and values are the line of text..
 *
 * @see org.apache.hadoop.mapred.TextInputFormat
 * Created by songgr on 2020/12/01.
 */

@InterfaceAudience.Public
@InterfaceStability.Stable
public class MultiLineCSVInputFormat extends FileInputFormat<LongWritable, Text>
        implements JobConfigurable {

    private CompressionCodecFactory compressionCodecs = null;

    @Override
    public void configure(JobConf conf) {
        compressionCodecs = new CompressionCodecFactory(conf);
    }

    @Override
    protected boolean isSplitable(FileSystem fs, Path file) {
        final CompressionCodec codec = compressionCodecs.getCodec(file);
        if (null == codec) {
            return true;
        }
        return codec instanceof SplittableCompressionCodec;
    }

    @Override
    public RecordReader<LongWritable, Text> getRecordReader(InputSplit split, JobConf job, Reporter reporter) throws IOException {
        reporter.setStatus(split.toString());

        String separatorChar = StringEscapeUtils.unescapeJava(job.get(OpenCSVSerde.SEPARATORCHAR.toLowerCase(Locale.ROOT)));
        String quoteChar = StringEscapeUtils.unescapeJava(job.get(OpenCSVSerde.QUOTECHAR.toLowerCase(Locale.ROOT)));
        String escapeChar = StringEscapeUtils.unescapeJava(job.get(OpenCSVSerde.ESCAPECHAR.toLowerCase(Locale.ROOT)));

        // 核心是RecordReader 切分每一行
        return new MultiLineCSVRecordReader(job, (FileSplit) split, separatorChar, quoteChar, escapeChar);
    }
}
