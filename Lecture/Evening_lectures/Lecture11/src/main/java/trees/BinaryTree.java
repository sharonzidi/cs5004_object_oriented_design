package trees;

import java.util.NoSuchElementException;
import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {
  private BinaryNode<T> root;

  public BinaryTree() {
    this.root = null;
  }

  private BinaryTree(BinaryNode<T> root) {
    this.root = root;
  }


  private boolean isEmpty() {
    return this.root == null;
  }

  @Override
  public boolean contains(T x) {
    return this.contains(this.root, x);
  }

  private boolean contains(BinaryNode<T> node, T x) {
    if (this.isEmptyNode(node)) {
      return false;
    }
    if (node.getData().equals(x)) {
      return true;
    }
    return this.contains(node.getLeftTree(), x) || this.contains(node.getRightTree(), x);
  }

  @Override
  public T findMin() {
    if (this.isEmpty()) {
      throw new NullPointerException();
    }
    return this.findMin(this.root);
  }

  private T findMin(BinaryNode<T> node) {
    if (this.isEmptyNode(node.getLeftTree())) {
      return node.getData();
    } else {
      return this.findMin(node.getLeftTree());
    }
  }

  @Override
  public T findMax() {
    if (this.isEmpty()) {
      throw new NullPointerException();
    }
    return this.findMax(this.root);
  }

  private T findMax(BinaryNode<T> node) {
    if (this.isEmptyNode(node.getRightTree())) {
      return node.getData();
    } else {
      return this.findMax(node.getRightTree());
    }
  }

  @Override
  public void insert(T x) {
    this.root = this.insert(this.root, x);
  }

  private BinaryNode<T> insert(BinaryNode<T> node, T x) {
    if (this.isEmptyNode(node)) {
      return new BinaryNode<>(x);
    }
    else {
      if (x.compareTo(node.getData()) < 0) {
        node.setLeftTree(this.insert(node.getLeftTree(), x));
      } else {
        node.setRightTree(this.insert(node.getRightTree(), x));
      }
      return node;
    }
  }

  @Override
  public void remove(T x) {
    this.root = this.remove(this.root, x);
  }

  private boolean isEmptyNode(BinaryNode<T> node) {
    return node == null;
  }

  private BinaryNode<T> remove(BinaryNode<T> node, T x) {
    if (this.isEmptyNode(node)) {
      throw new NoSuchElementException();
    }
    int cmp = x.compareTo(node.getData());
    if (cmp < 0) {
      node.setLeftTree(this.remove(node.getLeftTree(),  x));
    }
    else if (cmp > 0) {
      node.setRightTree(this.remove(node.getRightTree(),  x));
    }
    else {
      node = this.processRemove(node);
    }
    return node;
  }

  private BinaryNode<T> processRemove(BinaryNode<T> node) {
    if (this.isEmptyNode(node.getRightTree())) {
      return node.getLeftTree();
    }
    if (this.isEmptyNode(node.getLeftTree())) {
      return node.getRightTree();
    }

    return this.rotateNodes(node);

  }

  private BinaryNode<T> rotateNodes(BinaryNode<T> node) {
    BinaryTree<T> subTree = new BinaryTree<>(node.getRightTree());
    T newRootData = subTree.findMin();
    BinaryNode<T> newRightNode = subTree.remove(node.getRightTree(), newRootData);
    BinaryNode<T> newRoot = new BinaryNode<>(newRootData);
    newRoot.setRightTree(newRightNode);
    newRoot.setLeftTree(node.getLeftTree());
    return newRoot;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BinaryTree<?> that = (BinaryTree<?>) o;
    return Objects.equals(root, that.root);
  }

  @Override
  public int hashCode() {
    return Objects.hash(root);
  }

  @Override
  public String toString() {
    return "BinaryTree{" +
        "root=" + root +
        '}';
  }
}
