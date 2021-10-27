package scanner;

import java.util.Scanner;

public class Interactive {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    System.out.println("Enter a number");
    int num = console.nextInt();

    System.out.println("Doubled: " + num * 2);
  }
}
