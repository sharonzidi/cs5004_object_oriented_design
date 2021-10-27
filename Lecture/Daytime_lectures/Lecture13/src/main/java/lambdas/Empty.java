package lambdas;

import java.util.Iterator;


/**
 * Created by therapon on 6/20/16.
 */
public class Empty<X> extends AList<X> {
    @Override
    public Integer size() {
        return 0;
    }


    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public X elementAt(Integer index) throws GenericListException {
        throw new GenericListException("Called elementAt on empty");
    }

    @Override
    public String join(String separator) {
        return "";
    }

    @Override
    public <Y> AList<Y> applyToEach(Function<X, Y> f) {
        return new Empty<Y>();
    }

    @Override
    public <Y> Y foldOver(Combiner<X, Y> combiner, Y base) {
        return base;
    }


    @Override
    public Iterator<X> iterator() {
        return new GenericListIterator(this);
    }

    @Override
    X getFirst() {
        throw new GenericListException("Cannot get elements from an empty list");
    }

    @Override
    AList<X> getRest() {
        throw new GenericListException("Cannot get elements from an empty list");
    }

    @Override
    AList<X> remove() {
        return this;
    }



    @Override
    public String toString() {
        return "";
    }
}