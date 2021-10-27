package simpleInheritance;

public class Actor extends Artist {

  public Actor(Name personsName, String address, String emailAddress, String[] artCollection) {
    super(personsName, address, emailAddress, artCollection);
    super.equals(null);
    this.equals(null);
  }

}
