package problem2;

import java.util.Objects;

public class Node {

  private String value;
  private Node pointerToNext;

  public Node(String value, Node pointerToNext) {
    this.value = value;
    this.pointerToNext = pointerToNext;
  }

  public String getValue() {
    return value;
  }

  public Node getPointerToNext() {
    return pointerToNext;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setPointerToNext(Node pointerToNext) {
    this.pointerToNext = pointerToNext;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node node = (Node) o;
    return Objects.equals(getValue(), node.getValue()) &&
        Objects.equals(getPointerToNext(), node.getPointerToNext());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue(), getPointerToNext());
  }

  @Override
  public String toString() {
    return "Node{" +
        "value='" + value + '\'' +
        ", pointerToNext=" + pointerToNext +
        '}';
  }
}
