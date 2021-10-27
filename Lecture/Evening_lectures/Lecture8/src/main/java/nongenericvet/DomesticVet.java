package nongenericvet;

public class DomesticVet extends AbstractVet {
    public DomesticVet(String firstName, String lastName) {
        super(firstName, lastName, Specialty.DOMESTIC);
    }

    @Override
    public String toString() {
        return "DomesticVet{" +
                "patients=" + patients +
                ", specialty=" + specialty +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
