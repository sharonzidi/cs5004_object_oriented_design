package recursiveSet;

import simpleRecursiveList.Cons;

import java.security.PublicKey;
import java.util.Objects;

public class ConsSet implements ISet {
    private Integer first;
    private ISet rest;

    public ConsSet(Integer first, ISet rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public Boolean isEmpty() {
        return false;
    }

    @Override
    public ISet add(Integer n) {
        if (this.contains(n)) return this;
        return new ConsSet(n, this);
    }

    @Override
    public Boolean contains(Integer n) {
        if (this.first.equals(n)) return true;
        return this.rest.contains(n);
    }

    @Override
    public ISet remove(Integer n) {
        if (!this.contains(n)) return this;

        // the head is the one to remove
        if (this.first.equals(n)) {
            return this.rest;
        } else {
            return new ConsSet(this.first, this.rest.remove(n));
        }
    }


    //1->2->3->empty
    //remove 2
    //1->

    @Override
    public Integer size() {
        return 1 + this.rest.size();
    }

    @Override
    public int hashCode() {
        int result = 31 * this.size();
        result += Objects.hashCode(this.first);
        return result + this.rest.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConsSet consSet = (ConsSet) obj;

        if (!this.size().equals(consSet.size())) return false;
        if (!consSet.contains(this.first)) return false;

        return this.rest.equals(consSet.remove(this.first));
    }
    // 1->

    @Override
    public String toString() {
        return "ConsSet{" +
                "first=" + first +
                ", rest=" + rest +
                "}";
    }
}
