package scanner;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    Pattern re = Pattern.compile("(a|b)b*");

    System.out.println("Type something:");

    String input = "";// = console.nextLine();

    while(!input.equals("stop")) {
      System.out.println("Type something else");
      input = console.nextLine();

      System.out.println("Matches pattern? "
          + re.matcher(input).matches() + ", " + re.matcher(input).lookingAt() + ", " + re.matcher(input).find());
    }
  }
}
