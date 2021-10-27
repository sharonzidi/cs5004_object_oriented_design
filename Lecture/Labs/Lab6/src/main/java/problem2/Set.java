package problem2;

public interface Set {

  Set emptySet();

  Boolean isEmpty();

  Set add(Integer number);

  Boolean contains(Integer number);

  Set remove(Integer element);

  Integer size();



}
