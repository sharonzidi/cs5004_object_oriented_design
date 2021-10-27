public class PhoneDictionary {

  private Person user;

  public PhoneDictionary(Person user) {
    this.user = user;
  }

  public PhoneDictionary(String firstName, String lastName, int yearOfBirth){

    this.user = new Person(firstName, lastName, yearOfBirth);
  }

  public Person getUser() {
    return user;
  }

  public void setUser(Person user) {
    this.user = user;
  }
}
