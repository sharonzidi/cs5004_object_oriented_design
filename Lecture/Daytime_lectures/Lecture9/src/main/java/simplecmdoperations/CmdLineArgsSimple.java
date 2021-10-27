package simplecmdoperations;

public class CmdLineArgsSimple {

    // Simple program to check for command line arguments
    public static void main(String[] args)
    {
        // Check if any command line arguments are provided
        if (args.length > 0)
        {
            System.out.println("The command line arguments are:");

            // Iterate over command line args, and print them out
            for (String val:args)
                System.out.println(val);
        }
        else
            System.out.println("No command line arguments found.");
    }
}
