package docsandvets;

import animals.AbstractAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientList<T extends AbstractAnimal> {
    private int maxPatients;
    private List<T> currentPatients;

    public PatientList(int maxPatients) {
        this.maxPatients = maxPatients;
        this.currentPatients = new ArrayList<>();
    }

    public PatientList(int maxPatients, List<T> currentPatients) {
        this.maxPatients = maxPatients;
        this.currentPatients = currentPatients;
    }

    public int getMaxPatients() {
        return this.maxPatients;
    }

    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }

    public List<T> getCurrentPatients() {
        return this.currentPatients;
    }

    public void setCurrentPatients(List<T> currentPatients) {
        this.currentPatients = currentPatients;
    }

    public void addPatient(T patient) {
        this.currentPatients.add(patient);
    }

    public T getPatient(int index) {
        return this.currentPatients.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientList<?> that = (PatientList<?>) o;
        return maxPatients == that.maxPatients &&
                currentPatients.equals(that.currentPatients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxPatients, currentPatients);
    }


}
