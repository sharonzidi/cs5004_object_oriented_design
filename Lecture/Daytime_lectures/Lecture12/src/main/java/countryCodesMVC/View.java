package countryCodesMVC;

import java.util.Scanner;

public class View {


  /**
   * Asks the user for input.
   * @param prompt A message to show to the user before getting their input.
   * @return The user's input
   */
  public static String getInput(String prompt) {
    Scanner scan = new Scanner(System.in);
    System.out.println(prompt);
    return scan.nextLine();
  }

  /**
   * Print a message to the command line.
   * @param feedback The message to print.
   */
  public static void giveFeedback(String feedback) {
    System.out.println(feedback);
  }
}
