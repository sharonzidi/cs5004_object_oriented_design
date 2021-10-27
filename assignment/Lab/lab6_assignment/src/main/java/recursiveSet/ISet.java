package recursiveSet;

import simpleRecursiveList.Empty;

public interface ISet {
    static ISet emptySet() {
        return new EmptySet();
    }

    Boolean isEmpty();

    ISet add(Integer n);

    Boolean contains(Integer n);

    ISet remove(Integer n);

    Integer size();

}
