package lists.genericinterface;

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
}
