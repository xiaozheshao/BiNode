package batfish.main;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Settings {

   private static final String ARG_CB_AHOST = "ahost";
   private static final String ARG_CB_APORT = "aport";
   private static final String ARG_CB_RHOST = "rhost";
   private static final String ARG_CB_RPORT = "rport";
   private static final String ARG_COMPILE = "compile";
   private static final String ARG_COUNT = "count";
   private static final String ARG_DIFF = "diff";
   private static final String ARG_DUMP_CONTROL_PLANE_FACTS = "dumpcp";
   private static final String ARG_ANONYMIZE = "anonymize";

   private static final String ARG_DUMP_FACTS_DIR = "dumpdir";
   private static final String ARG_DUMP_IF = "dumpif";
   private static final String ARG_DUMP_IF_DIR = "dumpifdir";
   private static final String ARG_DUMP_TRAFFIC_FACTS = "dumptraffic";
   private static final String ARG_EXIT_ON_PARSE_ERROR = "ee";
   private static final String ARG_FACTS = "facts";
   private static final String ARG_FLOW_PATH = "flowpath";
   private static final String ARG_FLOW_SINK_PATH = "flowsink";
   private static final String ARG_FLOWS = "flow";
   private static final String ARG_GUESS = "guess";
   private static final String ARG_GUI = "gui";
   private static final String ARG_HELP = "help";
   private static final String ARG_LOG_LEVEL = "log";
   private static final String ARG_NO_TRAFFIC = "notraffic";
   private static final String ARG_PREDHELP = "predhelp";
   private static final String ARG_PREDICATES = "predicates";
   private static final String ARG_QUERY = "query";
   private static final String ARG_QUERY_ALL = "all";
   private static final String ARG_REDIRECT_STDERR = "redirect";
   private static final String ARG_REMOVE_FACTS = "remove";
   private static final String ARG_REVERT = "revert";
   private static final String ARG_TEST_RIG_NAME = "testrigname";
   private static final String ARG_TEST_RIG_PATH = "testrig";
   private static final String ARG_UPDATE = "update";
   private static final String ARG_WORKSPACE = "workspace";
   private static final String ARG_Z3 = "z3";
   private static final String ARG_Z3_CONCRETIZE = "conc";
   private static final String ARG_Z3_CONCRETIZER_INPUT_FILE = "concin";
   private static final String ARG_Z3_CONCRETIZER_OUTPUT_FILE = "concout";
   private static final String ARG_Z3_OUTPUT = "z3out";
   private static final String ARGNAME_DUMP_FACTS_DIR = "path";
   private static final String ARGNAME_DUMP_IF_DIR = "path";
   private static final String ARGNAME_FLOW_PATH = "path";
   private static final String ARGNAME_FLOW_SINK_PATH = "path";
   private static final String ARGNAME_REVERT = "branch-name";
   private static final String ARGNAME_Z3_CONCRETIZER_INPUT_FILE = "path";
   private static final String ARGNAME_Z3_CONCRETIZER_OUTPUT_FILE = "path";
   private static final String ARGNAME_Z3_OUTPUT = "path";
   private static final String DEFAULT_CONNECTBLOX_ADMIN_PORT = "55181";
   private static final String DEFAULT_CONNECTBLOX_HOST = "localhost";
   private static final String DEFAULT_CONNECTBLOX_REGULAR_PORT = "55179";
   private static final String DEFAULT_DUMP_FACTS_DIR = "facts";
   private static final String DEFAULT_DUMP_IF_DIR = "if";
   private static final String DEFAULT_FLOW_PATH = "flows";
   private static final String DEFAULT_FLOW_SINK_PATH = "flow_sinks";
   private static final String DEFAULT_LOG_LEVEL = "2";
   private static final List<String> DEFAULT_PREDICATES = Collections
         .singletonList("InstalledRoute");
   private static final String DEFAULT_TEST_RIG_PATH = "default_test_rig";
   private static final String DEFAULT_WORKSPACE_NAME = "Batfish-"
         + System.getProperty("user.name");
   private static final String DEFAULT_Z3_CONCRETIZER_INPUT_FILE = "z3-concretizer-input.smt2";
   private static final String DEFAULT_Z3_CONCRETIZER_OUTPUT_FILE = "z3-concretizer-output.smt2";
   private static final String DEFAULT_Z3_OUTPUT = "z3-dataplane-output.smt2";
   private static final String EXECUTABLE_NAME = "batfish";
   private static final String ARGNAME_ANONYMIZE = "path";
   
   
   private boolean _canExecute;
   private String _cbAHost;
   private int _cbAPort;
   private String _cbRHost;
   private int _cbRPort;
   private boolean _compile;
   private boolean _concretize;
   private String _concretizerInputFilePath;
   private String _concretizerOutputFilePath;
   private boolean _counts;
   private boolean _diff;
   private boolean _dumpControlPlaneFacts;
   private String _dumpFactsDir;
   private boolean _dumpIF;
   private String _dumpIFDir;
   private boolean _dumpTrafficFacts;
   private boolean _exitOnParseError;
   private boolean _facts;
   private String _flowPath;
   private boolean _flows;
   private String _flowSinkPath;
   private boolean _guessTopology;
   private List<String> _helpPredicates;
   private String _hsaInputDir;
   private String _hsaOutputDir;
   private int _logLevel;
   private boolean _noTraffic;
   private Options _options;
   private List<String> _predicates;
   private boolean _printSemantics;
   private boolean _query;
   private boolean _queryAll;
   private boolean _redirectStdErr;
   private boolean _removeFacts;
   private boolean _revert;
   private String _revertBranchName;
   private String _secondTestRigPath;
   private String _testRigPath;
   private boolean _update;
   private String _workspaceName;
   private boolean _z3;
   private String _z3File;
   private boolean _anonymize;
   private String _anonymizeDir;
   
   public Settings() {
      initOptions();
      parseCommandLine(new String[] {});
   }
   
   public Settings(String[] args) {
      initOptions();
      parseCommandLine(args);
   }

   public boolean canExecute() {
      return _canExecute;
   }

   public boolean createWorkspace() {
      return _compile;
   }

   public boolean exitOnParseError() {
      return _exitOnParseError;
   }

   public String getBranchName() {
      return _revertBranchName;
   }

   public boolean getConcretize() {
      return _concretize;
   }

   public String getConcretizerInputFilePath() {
      return _concretizerInputFilePath;
   }

   public String getConcretizerOutputFilePath() {
      return _concretizerOutputFilePath;
   }

   public String getConnectBloxAdminHost() {
      return _cbAHost;
   }

   public int getConnectBloxAdminPort() {
      return _cbAPort;
   }

   public String getConnectBloxRegularHost() {
      return _cbRHost;
   }

   public int getConnectBloxRegularPort() {
      return _cbRPort;
   }

   public boolean getCountsOnly() {
      return _counts;
   }

   public boolean getDiff() {
      return _diff;
   }

   public boolean getDumpControlPlaneFacts() {
      return _dumpControlPlaneFacts;
   }

   public String getDumpFactsDir() {
      return _dumpFactsDir;
   }

   public boolean getDumpIF() {
      return _dumpIF;
   }

   public String getDumpIFDir() {
      return _dumpIFDir;
   }

   public boolean getDumpTrafficFacts() {
      return _dumpTrafficFacts;
   }

   public boolean getFacts() {
      return _facts;
   }

   public String getFlowPath() {
      return _flowPath;
   }

   public boolean getFlows() {
      return _flows;
   }

   public String getFlowSinkPath() {
      return _flowSinkPath;
   }

   public boolean getGuessTopology() {
      return _guessTopology;
   }

   public List<String> getHelpPredicates() {
      return _helpPredicates;
   }

   public String getHSAInputPath() {
      return _hsaInputDir;
   }

   public String getHSAOutputPath() {
      return _hsaOutputDir;
   }

   public int getLogLevel() {
      return _logLevel;
   }

   public boolean getNoTraffic() {
      return _noTraffic;
   }

   public List<String> getPredicates() {
      return _predicates;
   }

   public boolean getPrintSemantics() {
      return _printSemantics;
   }

   public boolean getQuery() {
      return _query;
   }

   public boolean getQueryAll() {
      return _queryAll;
   }

   public boolean getRemoveFacts() {
      return _removeFacts;
   }

   public String getSecondTestRigPath() {
      return _secondTestRigPath;
   }

   public String getTestRigPath() {
      return _testRigPath;
   }

   public boolean getUpdate() {
      return _update;
   }

   public String getWorkspaceName() {
      return _workspaceName;
   }

   public String getWorkspacePrefix() {
      return DEFAULT_WORKSPACE_NAME + "-testrig-";
   }

   public boolean getZ3() {
      return _z3;
   }

   public String getZ3File() {
      return _z3File;
   }

   @SuppressWarnings("static-access")
   private void initOptions() {
      _options = new Options();
      _options.addOption(OptionBuilder
            .withArgName("predicates")
            .hasArgs()
            .withDescription(
                  "list of LogicBlox predicates to query (defaults to '"
                        + DEFAULT_PREDICATES.get(0) + "')")
            .create(ARG_PREDICATES));
      _options.addOption(OptionBuilder
            .withArgName("path")
            .hasArg()
            .withDescription(
                  "path to test rig directory (defaults to \""
                        + DEFAULT_TEST_RIG_PATH + "\")")
            .create(ARG_TEST_RIG_PATH));
      _options.addOption(OptionBuilder.withArgName("name").hasArg()
            .withDescription("**DEPRECATED** name of LogicBlox workspace")
            .create(ARG_WORKSPACE));
      _options.addOption(OptionBuilder
            .withArgName("hostname")
            .hasArg()
            .withDescription(
                  "hostname of ConnectBlox server for regular session")
            .create(ARG_CB_RHOST));
      _options.addOption(OptionBuilder.withArgName("port_number").hasArg()
            .withDescription("port of ConnectBlox server for regular session")
            .create(ARG_CB_RPORT));
      _options
            .addOption(OptionBuilder
                  .withArgName("hostname")
                  .hasArg()
                  .withDescription(
                        "hostname of ConnectBlox server for admin session")
                  .create(ARG_CB_AHOST));
      _options.addOption(OptionBuilder.withArgName("port_number").hasArg()
            .withDescription("port of ConnectBlox server for admin session")
            .create(ARG_CB_APORT));
      _options
            .addOption(OptionBuilder
                  .withArgName("number")
                  .hasArg()
                  .withDescription(
                        "log level, either 0 (concise), 1 (verbose, default), or 2 (very verbose)")
                  .create(ARG_LOG_LEVEL));
      _options
            .addOption(OptionBuilder
                  .withArgName("predicates")
                  .hasOptionalArgs()
                  .withDescription(
                        "print semantics for all predicates, or for predicates supplied as optional arguments")
                  .create(ARG_PREDHELP));
      _options.addOption(OptionBuilder.withDescription("print this message")
            .create(ARG_HELP));
      _options.addOption(OptionBuilder.withDescription("query workspace")
            .create(ARG_QUERY));
      _options.addOption(OptionBuilder.withDescription(
            "return predicate cardinalities instead of contents").create(
            ARG_COUNT));
      _options.addOption(OptionBuilder.withDescription("query ALL predicates")
            .create(ARG_QUERY_ALL));
      _options.addOption(OptionBuilder.withDescription(
            "create workspace and add project logic").create(ARG_COMPILE));
      _options.addOption(OptionBuilder
            .withDescription("add facts to workspace").create(ARG_FACTS));
      _options.addOption(OptionBuilder.withDescription(
            "remove facts instead of adding them").create(ARG_REMOVE_FACTS));
      _options.addOption(OptionBuilder
            .withDescription("display results in GUI").create(ARG_GUI));
      _options.addOption(OptionBuilder.withDescription(
            "differentially update test rig workspace").create(ARG_UPDATE));
      _options.addOption(OptionBuilder.withDescription(
            "do not add injected traffic facts").create(ARG_NO_TRAFFIC));
      _options
            .addOption(OptionBuilder
                  .withDescription(
                        "guess that all interface ips in same subnet are physically adjacent")
                  .create(ARG_GUESS));
      _options
            .addOption(OptionBuilder
                  .withDescription(
                        "exit on first parse error (otherwise will exit on last parse error)")
                  .create(ARG_EXIT_ON_PARSE_ERROR));
      _options
            .addOption(OptionBuilder
                  .withArgName("name")
                  .hasArg()
                  .withDescription(
                        "use specified test rig name (otherwise use tail of testrig path)")
                  .create(ARG_TEST_RIG_NAME));
      _options.addOption(OptionBuilder.withDescription(
            "generate z3 data plane logic").create(ARG_Z3));
      _options.addOption(OptionBuilder.withArgName(ARGNAME_Z3_OUTPUT).hasArg()
            .withDescription("set z3 data plane logic output file")
            .create(ARG_Z3_OUTPUT));
      _options.addOption(OptionBuilder
            .withArgName(ARGNAME_Z3_CONCRETIZER_INPUT_FILE).hasArg()
            .withDescription("set z3 concretizer input file")
            .create(ARG_Z3_CONCRETIZER_INPUT_FILE));
      _options.addOption(OptionBuilder
            .withArgName(ARGNAME_Z3_CONCRETIZER_OUTPUT_FILE).hasArg()
            .withDescription("set z3 concretizer output file")
            .create(ARG_Z3_CONCRETIZER_OUTPUT_FILE));
      _options.addOption(OptionBuilder.withDescription(
            "create z3 logic to concretize data plane constraints").create(
            ARG_Z3_CONCRETIZE));
      _options.addOption(OptionBuilder.withDescription(
            "push concrete flows into logicblox databse").create(ARG_FLOWS));
      _options.addOption(OptionBuilder.withArgName(ARGNAME_FLOW_PATH).hasArg()
            .withDescription("path to concrete flows").create(ARG_FLOW_PATH));
      _options.addOption(OptionBuilder.withArgName(ARGNAME_FLOW_SINK_PATH)
            .hasArg().withDescription("path to flow sinks")
            .create(ARG_FLOW_SINK_PATH));
      _options.addOption(OptionBuilder.withArgName("secondPath").hasArg()
            .withDescription("path to test rig directory to diff with")
            .create(ARG_DIFF));
      _options.addOption(OptionBuilder.withDescription(
            "dump intermediate format of configurations").create(ARG_DUMP_IF));
      _options.addOption(OptionBuilder.withArgName(ARGNAME_DUMP_IF_DIR)
            .hasArg()
            .withDescription("directory to dump intermediate format files")
            .create(ARG_DUMP_IF_DIR));
      _options.addOption(OptionBuilder.withDescription(
            "dump control plane facts").create(ARG_DUMP_CONTROL_PLANE_FACTS));
      _options.addOption(OptionBuilder.withDescription(
            "dump traffic facts").create(ARG_DUMP_TRAFFIC_FACTS));
      _options.addOption(OptionBuilder
            .hasArg()
            .withArgName(ARGNAME_DUMP_FACTS_DIR)
            .withDescription("directory to dump LogicBlox facts")
            .create(ARG_DUMP_FACTS_DIR));
      _options.addOption(OptionBuilder
            .hasArg()
            .withArgName(ARGNAME_REVERT)
            .withDescription("revert test rig workspace to specified branch")
            .create(ARG_REVERT));
      _options.addOption(OptionBuilder
            .withDescription("redirect stderr to stdout")
            .create(ARG_REDIRECT_STDERR));
      _options.addOption(OptionBuilder
            .hasArg()
            .withArgName(ARGNAME_ANONYMIZE)
            .withDescription("created anonymized versions of configs in test rig")
            .create(ARG_ANONYMIZE));
   }

   private void parseCommandLine(String[] args) {
      _workspaceName = DEFAULT_WORKSPACE_NAME;
      _canExecute = true;
      _printSemantics = false;
      CommandLine line = null;
      CommandLineParser parser = new GnuParser();
      try {
         // parse the command line arguments
         line = parser.parse(_options, args);
      }
      catch (ParseException exp) {
         // oops, something went wrong
         System.err.println("Parsing failed.  Reason: " + exp.getMessage());
         _canExecute = false;
         return;
      }
      if (line.hasOption(ARG_HELP)) {
         _canExecute = false;
         // automatically generate the help statement
         HelpFormatter formatter = new HelpFormatter();
         formatter.printHelp(EXECUTABLE_NAME, _options);
         return;
      }
      _counts = line.hasOption(ARG_COUNT);
      _queryAll = line.hasOption(ARG_QUERY_ALL);
      _query = line.hasOption(ARG_QUERY);
      _guessTopology = line.hasOption(ARG_GUESS);
      if (line.hasOption(ARG_PREDHELP)) {
         _printSemantics = true;
         String[] optionValues = line.getOptionValues(ARG_PREDHELP);
         if (optionValues != null) {
            _helpPredicates = Arrays.asList(optionValues);
         }
      }
      _cbRHost = line.getOptionValue(ARG_CB_RHOST, DEFAULT_CONNECTBLOX_HOST);
      _cbAHost = line.getOptionValue(ARG_CB_AHOST, DEFAULT_CONNECTBLOX_HOST);
      _cbRPort = Integer.parseInt(line.getOptionValue(ARG_CB_RPORT,
            DEFAULT_CONNECTBLOX_REGULAR_PORT));
      _cbAPort = Integer.parseInt(line.getOptionValue(ARG_CB_RPORT,
            DEFAULT_CONNECTBLOX_ADMIN_PORT));

      // set test rig AND corresponding workspace name
      _testRigPath = line.getOptionValue(ARG_TEST_RIG_PATH,
            DEFAULT_TEST_RIG_PATH);
      String testRigName = line.getOptionValue(ARG_TEST_RIG_NAME, new File(
            _testRigPath).getName());
      _workspaceName = getWorkspacePrefix() + testRigName;

      // **DEPRECATED** set workspace name explicitly if workspace argument
      // given
      if (line.hasOption(ARG_WORKSPACE)) {
         _workspaceName = line.getOptionValue(ARG_WORKSPACE);
      }
      _logLevel = Integer.parseInt(line.getOptionValue(ARG_LOG_LEVEL,
            DEFAULT_LOG_LEVEL));
      if (line.hasOption(ARG_PREDICATES)) {
         _predicates = Arrays.asList(line.getOptionValues(ARG_PREDICATES));
      }
      else {
         _predicates = DEFAULT_PREDICATES;
      }
      _removeFacts = line.hasOption(ARG_REMOVE_FACTS);
      _compile = line.hasOption(ARG_COMPILE);
      _facts = line.hasOption(ARG_FACTS);
      _update = line.hasOption(ARG_UPDATE);
      _noTraffic = line.hasOption(ARG_NO_TRAFFIC);
      _exitOnParseError = line.hasOption(ARG_EXIT_ON_PARSE_ERROR);
      _z3 = line.hasOption(ARG_Z3);
      if (_z3) {
         _z3File = line.getOptionValue(ARG_Z3_OUTPUT, DEFAULT_Z3_OUTPUT);
      }
      _concretize = line.hasOption(ARG_Z3_CONCRETIZE);
      if (_concretize) {
         _concretizerInputFilePath = line
               .getOptionValue(ARG_Z3_CONCRETIZER_INPUT_FILE,
                     DEFAULT_Z3_CONCRETIZER_INPUT_FILE);
         _concretizerOutputFilePath = line.getOptionValue(
               ARG_Z3_CONCRETIZER_OUTPUT_FILE,
               DEFAULT_Z3_CONCRETIZER_OUTPUT_FILE);
      }
      _flows = line.hasOption(ARG_FLOWS);
      if (_flows) {
         _flowPath = line.getOptionValue(ARG_FLOW_PATH, DEFAULT_FLOW_PATH);
         _flowSinkPath = line.getOptionValue(ARG_FLOW_SINK_PATH,
               DEFAULT_FLOW_SINK_PATH);
      }
      _secondTestRigPath = line.getOptionValue(ARG_DIFF);
      _diff = line.hasOption(ARG_DIFF);
      _dumpIF = line.hasOption(ARG_DUMP_IF);
      if (_dumpIF) {
         _dumpIFDir = line.getOptionValue(ARG_DUMP_IF_DIR, DEFAULT_DUMP_IF_DIR);
      }
      _dumpControlPlaneFacts = line.hasOption(ARG_DUMP_CONTROL_PLANE_FACTS);
      _dumpTrafficFacts = line.hasOption(ARG_DUMP_TRAFFIC_FACTS);
      _dumpFactsDir = line.getOptionValue(ARG_DUMP_FACTS_DIR, DEFAULT_DUMP_FACTS_DIR);
      
      _revertBranchName = line.getOptionValue(ARG_REVERT);
      _revert = (_revertBranchName != null);
      _redirectStdErr = line.hasOption(ARG_REDIRECT_STDERR);
      _anonymize = line.hasOption(ARG_ANONYMIZE);
      if (_anonymize) {
         _anonymizeDir = line.getOptionValue(ARG_ANONYMIZE);
      }
   }

   public boolean redirectStdErr() {
      return _redirectStdErr;
   }

   public boolean revert() {
      return _revert;
   }

   public boolean getAnonymize() {
      return _anonymize;
   }
   
   public String getAnonymizeDir() {
      return _anonymizeDir;
   }

}
