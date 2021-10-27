package problem2;

import java.util.Objects;

public class StringList implements IList{
  private Node headerNode;

  public StringList(Node headerNode) {
    this.headerNode = headerNode;
  }

  public Node getHeaderNode() {
    return headerNode;
  }

  @Override
  public Boolean isEmpty() {
    return (headerNode == null);
  }

  @Override
  public Integer size() {
    if(isEmpty())
      return 0;
    else {
      Integer size = 1;
      Node tempNode = this.headerNode;

      while (tempNode.getPointerToNext() != null) {
        size++;
        tempNode = tempNode.getPointerToNext();
      }
      return size;
    }
  }

  @Override
  public Boolean contains(String element) {
    if(isEmpty())
      return false;
    else{
      Node tempNode = this.headerNode;
      while (tempNode.getPointerToNext() != null) {
        if(tempNode.getValue().equals(element))
          return true;
        tempNode = tempNode.getPointerToNext();
      }
    }
    return false;
  }

  @Override
  public Boolean containsAll(StringList list) {
    if(this.isEmpty() || list.isEmpty())
      return false;
    else {
      Node tempNode = this.headerNode;
      while (tempNode.getPointerToNext() != null) {
        if (!list.contains(tempNode.getValue()))
          return false;
        tempNode = tempNode.getPointerToNext();
      }
    }
    return true;
  }

  @Override
  public StringList filterLargerThan(Integer maxStringLength) {
    if(this.isEmpty())
      return this;
    else{
      Node tempNode = this.headerNode;
      StringList resultingList;
      while(tempNode.getPointerToNext() != null)
    }
    return null;
  }

  @Override
  public Boolean hasDuplicates() {
    return null;
  }

  @Override
  public StringList removeDuplicates() {
    return null;
  }

  private StringList addElement(String element){
    Node tempNode = new Node(element, null);

    if(isEmpty()) {
      headerNode = tempNode;
      return this;
    }
    else{
      Node currentNode = headerNode;
      while(currentNode.getPointerToNext() != null){
        currentNode = currentNode.getPointerToNext();
      }
      currentNode.setPointerToNext(tempNode);
    }
      return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof StringList)) return false;
    StringList that = (StringList) o;
    return Objects.equals(getHeaderNode(), that.getHeaderNode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getHeaderNode());
  }

  @Override
  public String toString() {
    return "StringList{" +
        "headerNode=" + headerNode +
        '}';
  }
}
