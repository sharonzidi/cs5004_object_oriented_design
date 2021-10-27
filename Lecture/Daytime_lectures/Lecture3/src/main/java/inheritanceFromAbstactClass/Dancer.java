package inheritanceFromAbstactClass;

public class Dancer extends Person {

  public Dancer(String firstName, String lastName) {

    super(firstName, lastName);
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
