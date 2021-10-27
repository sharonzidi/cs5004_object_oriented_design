package animals;

import java.util.Objects;

public class Horse extends AbstractFarm {

    public Horse(String firstName, Person owner) {
        super(firstName, owner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse that = (Horse) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                owner.equals(this.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, owner);
    }

    @Override
    public String toString() {
        return "Horse {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", owner='" + owner.toString() + '\'' +
                '}';
    }
}
