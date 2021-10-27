package inheritanceWithPrivateFields;

public class ClientDemo {
    public static void main(String [] args) {
      Person myPerson = new Person("John", "Doe");
      Client myClient = new Client("Jane", "Doe", "1234");

      System.out.println("Printing the getter");
      System.out.println(myPerson.getFirstName());

      System.out.println("Print to console - person");
      myPerson.printToConsole();

      System.out.println("Print stuff");
      myClient.printStuff();

      System.out.println("Print to console - client");
      myClient.printToConsole();
    }
}
