package OOD_exercise_5_argProcessor;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 3)
            throw new CommandLineExceptions("Incorrect number of arguments!");

        cmdLineProcessor clProcessor = new cmdLineProcessor();
        clProcessor.processArguments(args);
    }
}
