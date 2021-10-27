package designofsystems.moremodularcookiecounter;

public class Main {
    public static void main(String[] args) {
        try {
            CommandLineParser parser = new CommandLineParser(args);
            System.out.println(ModularNutritionCalculator.getTotalMessage(parser.getItems()));
        } catch (InvalidArgumentsException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
