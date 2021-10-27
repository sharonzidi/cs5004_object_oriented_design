package simplefileprocessor;

/**
 * Class to handle all Command Line Arguments related exceptions.
 */
public abstract class CmdLineExceptions extends RuntimeException {
    private static String[] flags;
    private static String[][] explanations;
    private static String usageHelp;

    /**
     * This constructor prints the error message on command line and exits successfully.
     *
     * @param msg Error message
     */
    public CmdLineExceptions(String msg) {
        super(msg + "\n" + usageHelp);
    }


    /**
     * Class to handle errors related to missing command line arguments.
     */
    public static class MissingCommandException extends CmdLineExceptions {
        /**
         * This constructor passes the error message to its super class.
         *
         * @param msg Error message
         */
        public MissingCommandException(String msg) {
            super(msg);
        }
    }

    /**
     * Class to handle errors related to unnecessary arguments passed in command line arguments.
     */
    public static class ExtraArgumentException extends CmdLineExceptions {
        public ExtraArgumentException(String msg) {
            super(msg);
        }
    }

    /**
     * Class to handle errors related to illegal flags in command line arguments.
     */
    public static class IllegalFlagError extends CmdLineExceptions {
        public IllegalFlagError(String msg) {
            super(msg);
        }
    }

    /**
     * Class to handle errors related to illegal values to command line flags.
     */
    public static class IllegalValueException extends CmdLineExceptions {
        public IllegalValueException(String msg) {
            super(msg);
        }
    }

    //Used for USAGE help generation
    static {
        flags = new String[]{
                "REQUIRED ARGUMENTS",
                "input file",
                "OPTIONAL ARGUMENTS",
                "processing flag",
                "output file"
        };
        explanations = new String[][]{
                {"EXPLANATION"},
                {"Provide the name of the input file."},
                {"EXPLANATION"},
                {"Provide a processing flag (-c or -f) to define the processing type."},
                {"Provide the output file if the input file should be copied into another file "},
        };
    }

    //Used to represent USAGE help report in tabular form
    static {
        usageHelp = "Usage:";
        usageHelp += DisplayHelper.createTable(
                new int[]{flags.length, explanations[0].length},
                flags,
                explanations);
    }
}
