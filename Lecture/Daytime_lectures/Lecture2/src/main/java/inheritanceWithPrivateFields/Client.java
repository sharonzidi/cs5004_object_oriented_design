package inheritanceWithPrivateFields;

public class Client extends Person {
  private String clientID;

  public Client(String firstName, String lastName, String studentID) {
    super(firstName, lastName);
    this.clientID = studentID;
  }

  public String getClientID() {
    return clientID;
  }

  public void printStuff(){
    System.out.println(this.getFirstName());
    System.out.println(super.getLastName());
  }

  @Override
  public void printToConsole(){
    System.out.println(this.getFirstName() + super.getFirstName() + this.getLastName());
  }
}
