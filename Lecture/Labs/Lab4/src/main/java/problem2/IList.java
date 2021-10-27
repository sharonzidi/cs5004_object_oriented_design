package problem2;

public interface IList {

  Boolean isEmpty();
  Integer size();
  Boolean contains(String element);
  Boolean containsAll (StringList list);
  StringList filterLargerThan(Integer maxStringLength);
  Boolean hasDuplicates();
  StringList removeDuplicates();
}
