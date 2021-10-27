package docsandvets;

import animals.AbstractNonHuman;

public class Vet<T extends AbstractNonHuman> extends AbstractProvider<T> {
    public Vet(String firstname, String lastname, int maxPatients) {
        super(firstname, lastname, maxPatients);
    }
}
