package password;

import java.util.Scanner;
import java.io.IOException;

public class Password {
  static String errString = new String("No console");

  public static void main (String args[]) throws IOException {

    Scanner console = new Scanner(System.in);
    if (console == null) {
      System.err.println(errString);
      System.exit(1);
    }

    System.out.println("Enter your username:");
    String username = console.nextLine();

    System.out.println("Enter your old password");
    String oldPassword = console.nextLine();

    if (verify(username, oldPassword)) {
      boolean noMatch;
      do {
        System.out.println("Enter your new password: ");
        String newPassword1 = console.nextLine();
        System.out.println("Enter your new password again: ");
        String newPassword2 = console.nextLine();
        noMatch = ! newPassword1.equals(newPassword2);
        if (noMatch) {
          System.out.println("Passwords don't match. Try again.");
        } else {
          change(username, newPassword1);
          System.out.println("Password has been successfully changed!");
        }
      } while (noMatch);
    }
  }

  // Dummy change method.
  private static boolean verify(String login, String password) {
    // This method always returns
    // true in this example.
    // Modify this method to verify
    // password according to your rules.
    return true;
  }

  // Dummy change method.
  private static void change(String login, String password) {
    // Modify this method to change
    // password according to your rules.
  }
}