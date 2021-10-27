package lambdas;


/**
 * Created by therapon on 6/21/16.
 */
public abstract class AList<X> implements List<X> {

    @Override
    public List<X> add(X element) {
        return new Cons<X>(element, this);
    }

    abstract X getFirst();

    abstract AList<X> getRest();

    abstract AList<X> remove();

    @Override
    public abstract <Y> AList<Y> applyToEach(Function<X, Y> f);
}
