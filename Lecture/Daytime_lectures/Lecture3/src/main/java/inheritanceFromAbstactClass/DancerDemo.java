package inheritanceFromAbstactClass;

public class DancerDemo {
    public static void main(String [] args) {
      Dancer myDancer = new Dancer("Fred", "Astair");

      System.out.println("Printing the getter");
      System.out.println(myDancer.getFirstName());

      System.out.println("Print to console - person");
      myDancer.printToConsole();

      System.out.println("Print stuff");
      myDancer.printStuff();

      System.out.println("Print to console - student");
      myDancer.printToConsole();
    }
}
