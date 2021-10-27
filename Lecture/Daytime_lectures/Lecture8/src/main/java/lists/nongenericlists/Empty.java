package lists.nongenericlists;

public class Empty extends AStringList {
  @Override
  public Integer size() {
    return 0;
  }


  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public String elementAt(Integer index) throws GenericListException {
    throw new GenericListException("Called elementAt on empty");
  }
}
