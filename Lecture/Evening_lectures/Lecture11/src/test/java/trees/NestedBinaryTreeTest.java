package trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NestedBinaryTreeTest {
  IBinaryTree<String> tree1;
  IBinaryTree<String> tree2;
  IBinaryTree<String> tree3;

  @Before
  public void setUp() {
    tree1 = new NestedBinaryTree<>();
    tree2 = new NestedBinaryTree<>();
    tree3 = new NestedBinaryTree<>();

    tree1.insert("A");
    tree1.insert("B");
    tree1.insert("C");
    tree1.insert("D");

    tree2.insert("D");
    tree2.insert("C");
    tree2.insert("B");
    tree2.insert("A");

    tree3.insert("C");
    tree3.insert("A");
    tree3.insert("D");
    tree3.insert("B");
  }

  @Test
  public void contains() {
    assertTrue(tree1.contains("D"));
    assertFalse(tree2.contains("X"));
  }

  @Test
  public void findMin() {
    assertEquals("A", tree1.findMin());
    assertEquals("A", tree2.findMin());
    assertEquals("A", tree3.findMin());
  }

  @Test
  public void findMax() {
    assertEquals("D", tree1.findMax());
    assertEquals("D", tree2.findMax());
    assertEquals("D", tree3.findMax());
  }

  @Test
  public void insert() {
    tree1.insert("E");
    assertEquals("E", tree1.findMax());
    tree3.insert("E");
    assertEquals("E", tree3.findMax());
  }

  @Test
  public void remove() {
    tree1.remove("C");
    assertEquals("A", tree1.findMin());
    assertEquals("D", tree1.findMax());
    assertFalse(tree1.contains("C"));
    tree1.remove("A");
    assertEquals("B", tree1.findMin());
  }
}