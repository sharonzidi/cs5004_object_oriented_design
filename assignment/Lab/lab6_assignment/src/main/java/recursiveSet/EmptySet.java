package recursiveSet;

public class EmptySet implements ISet {

    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public ISet add(Integer n) {
        return new ConsSet(n, this);
    }

    @Override
    public Boolean contains(Integer n) {
        return false;
    }

    @Override
    public ISet remove(Integer n) {
        return this;
    }

    @Override
    public Integer size() {
        return 0;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "EmptySet{}";
    }
}
