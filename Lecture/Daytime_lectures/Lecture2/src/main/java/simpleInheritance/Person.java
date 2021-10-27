package simpleInheritance;

import java.util.Objects;

/**
 * Simple class simpleInheritance.Person, that includes private instance variables firstName and lastName.
 * */
public class Person {

  private Name personsName;
  private String address;

  public Person(Name personsName, String address) {
    this.personsName = personsName;
    this.address = address;
  }

  public void setPersonsName(Name personsName) {
    this.personsName = personsName;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Name getPersonsName() {
    return personsName;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person person = (Person) o;
    return Objects.equals(getPersonsName(), person.getPersonsName()) &&
        Objects.equals(getAddress(), person.getAddress());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPersonsName(), getAddress());
  }
}

