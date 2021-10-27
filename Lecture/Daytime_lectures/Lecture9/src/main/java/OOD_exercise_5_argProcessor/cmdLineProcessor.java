package OOD_exercise_5_argProcessor;

public class cmdLineProcessor {
    public CLData myCLData;
    private final String LOCALHOST = "localhost";
    private final String PLAIN = "plain";

    public cmdLineProcessor() {

        myCLData = new CLData();
    }

    public Boolean processArguments(String[] args) {
        if (args.length == 2) {
            try {
                if ((args[1].equals("--plain")) || (args[1].equals("--encrypt"))) {
                    myCLData.setEncrypted(args[1]);
                } else
                    myCLData.setHostname(args[1]); //fragile assumption that a user will always provide either a correct encryption flag or a correct hostname
            } catch (Exception e) {
                throw new CommandLineExceptions(("Incorrect hostname or encryption flag!"));
            }
        }

        if (args.length == 3) {
            try {
                if ((args[1].equals("--plain")) || (args[1].equals("--encrypt"))) {
                    myCLData.setEncrypted(args[1]);
                    myCLData.setHostname(args[2]);
                } else {
                    myCLData.setEncrypted(args[2]);
                    myCLData.setHostname(args[1]);
                }
            } catch (Exception e) {
                throw new CommandLineExceptions("Incorrect hostname or encryption format!");
            }
        }
        return Boolean.TRUE;
    }

    private Boolean validatePort(String portStr) {
        try {
            Integer port = Integer.valueOf(portStr);
            if (port < 1000 || port > 65000)
                throw new CommandLineExceptions("Incorrect port number!");
            myCLData.setPort(port);
        } catch (NumberFormatException e) {
            throw new CommandLineExceptions("Incorrect port format!");
        }
        return Boolean.TRUE;
    }
}

