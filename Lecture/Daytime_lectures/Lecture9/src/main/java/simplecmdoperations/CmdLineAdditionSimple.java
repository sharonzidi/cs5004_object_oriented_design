package simplecmdoperations;

public class CmdLineAdditionSimple {

    public static void main(String[] args) {
        int sum = 0;
        if (args.length < 2)
            System.out.println("Please provide two integers to sum up!");
        else {
            sum = sum + Integer.parseInt(args[0]) + Integer.parseInt((args[1]));
            System.out.println("The sum of the arguments passed is " + sum);
        }
    }
}
