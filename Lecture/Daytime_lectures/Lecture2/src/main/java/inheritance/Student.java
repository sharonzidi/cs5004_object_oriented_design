package inheritance;

public class Student extends Person {
  private String studentID;

  public Student(String firstName, String lastName, String studentID) {
    super(firstName, lastName);
    this.studentID = studentID;
  }


  public Student(String firstName, String lastName, String superFirstName, String studentID) {
    super(firstName, lastName);
    this.studentID = studentID;

    super.firstName = superFirstName;
  }

  public String getStudentID() {
    return studentID;
  }

  public void printStuff(){
    System.out.println(this.firstName);
    System.out.println(super.firstName);
  }

  @Override
  public void printToConsole(){
    System.out.println(this.firstName + super.firstName + this.lastName);
  }
}
