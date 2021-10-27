package nongenericvet;

public class BirdVet extends AbstractVet {
    public BirdVet(String firstName, String lastName) {
        super(firstName, lastName, Specialty.BIRD);
    }

    @Override
    public String toString() {
        return "BirdVet{" +
                "patients=" + patients +
                ", specialty=" + specialty +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
