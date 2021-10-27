package nongenericvet;

public class FarmVet extends AbstractVet {
    public FarmVet(String firstName, String lastName) {
        super(firstName, lastName, Specialty.FARM);
    }

    @Override
    public String toString() {
        return "FarmVet{" +
                "patients=" + patients +
                ", specialty=" + specialty +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
