package tech.ides.cli;

import org.apache.commons.cli.*;
import tech.ides.exception.IdesException;
import java.util.*;
import java.util.Properties;

/**
 * cli 参数处理处理类(参考hive cli)
// * @see org.apache.hadoop.hive.cli.OptionsProcessor
 * Created by songgr on 2021/03/16.
 */
public class OptionsProcessor {

    private final Options options = new Options();
    private final String cmdLineSyntax = "DataLinked";
    private CommandLine commandLine;

    @SuppressWarnings("static-access")
    public OptionsProcessor() {

        // Substitution option -d, --define
        options.addOption(OptionBuilder
                .withValueSeparator()
                .hasArgs(2)
                .withArgName("key=value")
                .withLongOpt("define")
                .withDescription("Environment variable substitution to apply to datalinked commands. e.g. -d A=B or --define A=B")
                .create('d'));

        // [-v|--verbose]
        options.addOption(new Option("v", "verbose", false, "Verbose mode (echo executed SQL to the console)"));

        // [-h|--help]
        options.addOption(new Option("h", "help", false, "Print help information"));

        // -e 'quoted-query-string'
        options.addOption(OptionBuilder
                .hasArg()
                .withArgName("quoted-query-string")
                .withDescription("SQL from command line")
                .create('e'));

        // -f <query-file>
        options.addOption(OptionBuilder
                .hasArg()
                .withValueSeparator(',')
                .withArgName("filename")
                .withDescription("SQL from files")
                .create('f'));
    }

    public String getValue(char opt) {
        return commandLine.getOptionValue(opt);
    }

    public boolean hasOption(char opt) {
        return commandLine.hasOption(opt);
    }

    public Map<String, String> getOptionProperties(String opt) {
        Properties properties = commandLine.getOptionProperties(opt);
        return new HashMap<String, String>((Map) properties);
    }

    public boolean isOption(String opt) {
        return options.hasOption(opt);
    }

    public boolean hasArg(String opt) {
        if ( !isOption(opt) ) return false;
        return options.getOption(opt).hasArg();
    }

    public Option getOption(String opt) {
        return options.getOption(opt);
    }

    public void process(String[] args) throws Exception {
        BasicParser parser = new BasicParser();
        commandLine = parser.parse(options, args);

        if (commandLine.hasOption('h')) {
            HelpFormatter hf = new HelpFormatter();
            hf.printHelp(cmdLineSyntax, "", options, "");
            System.exit(0);
        }

        if (commandLine.hasOption('f') && commandLine.hasOption('e')) {
            throw new IdesException("option -e|-f only one can used");
        }
    }
}
