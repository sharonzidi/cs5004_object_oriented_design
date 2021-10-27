package OOD_exercise_5_argProcessor;

public class CommandLineExceptions extends RuntimeException {
    private static String[] flags;
    private static String[][] explanations;
    private static String usageHelp;

    /**
     * This constructor prints the error message on command line and exits successfully.
     *
     * @param msg Error message
     */
    public CommandLineExceptions(String msg) {
        super(msg + "\n" + usageHelp);
    }

    /**
     * Class to handle errors related to missing command line arguments.
     */
    public static class MissingCommandException extends CommandLineExceptions {
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
    public static class ExtraArgumentException extends CommandLineExceptions {
        public ExtraArgumentException(String msg) {
            super(msg);
        }
    }

    /**
     * Class to handle errors related to illegal flags in command line arguments.
     */
    public static class IllegalFlagError extends CommandLineExceptions {
        public IllegalFlagError(String msg) {
            super(msg);
        }
    }

    /**
     * Class to handle errors related to illegal values to command line flags.
     */
    public static class IllegalValueException extends CommandLineExceptions {
        public IllegalValueException(String msg) {
            super(msg);
        }
    }

    //Used for USAGE help generation
    static {
        flags = new String[]{
            "port"
        };
        explanations = new String[][]{
                {"EXPLANATION"},
                {"Port number (number in the range 10000-65000"},
        };
    }

}

