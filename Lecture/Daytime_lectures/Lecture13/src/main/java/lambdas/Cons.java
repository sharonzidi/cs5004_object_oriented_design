package lambdas;

import java.util.Iterator;

/**
 * Created by therapon on 6/20/16.
 */
public class Cons<X> extends AList<X> {

    private X first;
    private AList<X> rest;

    public Cons(X first, AList<X> rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public Integer size() {
        return 1 + getRest().size();
    }


    @Override
    public Boolean isEmpty() {
        return false;
    }

    @Override
    public X elementAt(Integer index) throws GenericListException {
        if (index < 0 || index > size() - 1) {
            throw new GenericListException("Index out of bounds");
        }

        if (index == 0) {
            return getFirst();
        } else {
            return getRest().elementAt(index - 1);
        }
    }

    @Override
    public String join(String separator) {
        return this.getFirst().toString() + separator + this.getRest().join(separator);
    }

    @Override
    public <Y> AList<Y> applyToEach(Function<X, Y> f) {
        return new Cons<Y>(f.apply(getFirst()), getRest().applyToEach(f));
    }

    @Override
    public <Y> Y foldOver(Combiner<X, Y> combiner, Y base) {
        return combiner.combine(getFirst(), getRest().foldOver(combiner, base));
    }


    public X getFirst() {
        return first;
    }

    public AList<X> getRest() {
        return rest;
    }

    @Override
    AList<X> remove() {
        return getRest();
    }

    @Override
    public Iterator<X> iterator() {
        return new GenericListIterator(this);
    }

    @Override
    public String toString() {
        return "(" + first + rest.toString() + ")";
    }
}
