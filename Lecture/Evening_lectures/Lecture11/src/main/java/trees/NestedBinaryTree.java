package trees;

import java.util.NoSuchElementException;

public class NestedBinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {
  private NestedNode<T> root;

  public NestedBinaryTree() {
    this.root = null;
  }

  private NestedBinaryTree(NestedNode<T> root) {
    this.root = root;
  }

  private boolean isEmpty() {
    return this.root == null;
  }

  @Override
  public boolean contains(T x) {
    return this.contains(this.root, x);
  }

  private boolean contains(NestedNode<T> node, T x) {
    if (node == null) {
      return false;
    }
    if (node.getData().equals(x)) {
      return true;
    }

    return this.contains(node.getLeftTree(), x ) ||
        this.contains(node.getRightTree(), x);
  }

  @Override
  public T findMin() {
    if (this.isEmpty()) {
      throw new NullPointerException();
    }
    return this.findMin(this.root);
  }

  private T findMin(NestedNode<T> node) {
    if (node.getLeftTree() == null) {
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

  private T findMax(NestedNode<T> node) {
    if (node.getRightTree() == null) {
      return node.getData();
    } else {
      return this.findMax(node.getRightTree());
    }
  }

  @Override
  public void insert(T x) {
    this.root = insert(this.root, x);
  }

  private NestedNode<T> insert(NestedNode<T> node, T x) {
    if (node == null) {
      return new NestedNode<>(x);
    }
    else {
      if (x.compareTo(node.getData()) < 0 ) {
        node.setLeftTree(this.insert(node.getLeftTree(), x));
      }
      else {
        node.setRightTree(this.insert(node.getRightTree(), x));
      }
      return node;
    }
  }

  @Override
  public void remove(T x) {
    this.root = this.remove(this.root, x);
  }

  private NestedNode<T> remove(NestedNode<T> node, T x) {
    if (node == null) {
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

  private NestedNode<T> processRemove(NestedNode<T> node) {
    if (node.getRightTree() == null) {
      return node.getLeftTree();
    }
    if (node.getLeftTree() == null) {
      return node.getRightTree();
    }

    return this.rotateNodes(node);

  }

  private NestedNode<T> rotateNodes(NestedNode<T> node) {
    NestedBinaryTree<T> subTree = new NestedBinaryTree<>(node.getRightTree());
    T newRootData = subTree.findMin();
    NestedNode<T> newRightNode = subTree.remove(node.getRightTree(), newRootData);
    NestedNode<T> newRoot = new NestedNode<>(newRootData);
    newRoot.setRightTree(newRightNode);
    newRoot.setLeftTree(node.getLeftTree());
    return newRoot;
  }



  private static class NestedNode<T> {
    private T data;

    private NestedNode<T> leftTree;

    private NestedNode<T> rightTree;

    public NestedNode(T data) {
      this(data, null, null);
    }

    public NestedNode(T data, NestedNode<T> leftTree, NestedNode<T> rightTree) {
      this.data = data;
      this.leftTree = leftTree;
      this.rightTree = rightTree;
    }

    public T getData() {
      return this.data;
    }

    public NestedNode<T> getLeftTree() {
      return this.leftTree;
    }

    public NestedNode<T> getRightTree() {
      return this.rightTree;
    }

    public void setLeftTree(NestedNode<T> node) {
      this.leftTree = node;
    }

    public void setRightTree(NestedNode<T> node) {
      this.rightTree = node;
    }
  }

}
