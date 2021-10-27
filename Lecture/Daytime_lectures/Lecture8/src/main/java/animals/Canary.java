package animals;

import java.util.Objects;

public class Canary extends AbstractBird {

    public Canary(String firstName, Person owner) {
        super(firstName, owner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canary that = (Canary) o;
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
        return "Canary {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", owner='" + owner.toString() + '\'' +
                '}';
    }
}
