package docsandvets;

import animals.Person;

public class Doctor extends AbstractProvider<Person> {
    public Doctor(String firstname, String lastname, int maxPatients) {
        super(firstname, lastname, maxPatients);
    }
}
