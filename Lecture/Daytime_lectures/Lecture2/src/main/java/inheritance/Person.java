package inheritance;

public class Person {
  protected String firstName;
  protected String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void printToConsole(){
    System.out.println(this.firstName + this.lastName);
  }
}
