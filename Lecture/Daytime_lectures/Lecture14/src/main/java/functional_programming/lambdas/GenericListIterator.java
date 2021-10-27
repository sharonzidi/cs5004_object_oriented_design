package functional_programming.lambdas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by therapon on 7/6/16.
 */
public class GenericListIterator<X> implements Iterator<X> {

    private AList<X> list;

    public GenericListIterator(AList<X> xes) {
        this.list = xes;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public X next() {
        try {
            X element = list.getFirst();
            list = list.getRest();
            return element;
        } catch (GenericListException glex) {
            throw new NoSuchElementException(glex.getMessage());
        }

    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Don't even think about it!");
    }
}