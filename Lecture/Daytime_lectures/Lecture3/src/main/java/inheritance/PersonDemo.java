package inheritance;

public class PersonDemo {
    public static void main(String [] args) {
      Person myPerson = new Person("John", "Doe");
      Student myStudent = new Student("Jane", "Doe", "1234");

      System.out.println("Printing the getter");
      System.out.println(myPerson.getFirstName());

      System.out.println("Print to console - person");
      myPerson.printToConsole();

      System.out.println("Print stuff");
      myStudent.printStuff();

      System.out.println("Print to console - student");
      myStudent.printToConsole();

      Student myStudent2 = new Student("Jane", "Doe",  "Hannah", "1234");
      System.out.println("Print to console - student");
      myStudent2.printToConsole();
    }
}
