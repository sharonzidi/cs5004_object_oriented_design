package trees;

public interface IBinaryTree<T extends Comparable<T>> {

  boolean contains(T x);

  T findMin();

  T findMax();

  void insert(T x);

  void remove(T x);
}
