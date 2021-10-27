package simplecmdoperations;

public class CmdLineAdditionMore {

    public static void main(String[] args) {
        int sum = 0;
        if (args.length < 2)
            System.out.println("Please provide two or more integers to sum up!");
        else {
            for (String val:args)
                sum = sum + Integer.parseInt(val);
            System.out.println("The sum of the arguments passed is " + sum);
        }
    }
}
