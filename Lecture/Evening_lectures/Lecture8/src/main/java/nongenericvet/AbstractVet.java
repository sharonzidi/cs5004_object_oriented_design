package nongenericvet;

import animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractVet extends Person {
    protected List<AbstractNonHuman> patients;
    protected Specialty specialty;

    public AbstractVet(String firstName, String lastName, Specialty specialty) {
        super(firstName, lastName);
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    public Specialty getSpecialty() {
        return this.specialty;
    }

    public void addPatient(AbstractNonHuman animal) throws InvalidSpeciesException {
        if (!this.canAcceptPatient(animal))
            throw new InvalidSpeciesException();
        this.patients.add(animal);
    }

    public List<AbstractNonHuman> getPatients() {
        return this.patients;
    }

    public boolean canAcceptPatient(AbstractNonHuman animal) {
        // Not extensible! What if new species categories are added?
        if (this.specialty == Specialty.DOMESTIC)
            return (animal instanceof AbstractDomestic);
        else if (this.specialty == Specialty.FARM)
            return (animal instanceof AbstractFarm);
        else if (this.specialty == Specialty.BIRD)
            return (animal instanceof AbstractBird);
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractVet that = (AbstractVet) o;
        return Objects.equals(patients, that.patients) &&
                specialty == that.specialty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), patients, specialty);
    }

    @Override
    public String toString() {
        return "AbstractVet{" +
                "patients=" + patients +
                ", specialty=" + specialty +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
