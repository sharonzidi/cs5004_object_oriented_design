package problem1_daytimeLab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodItemTest {
  private FoodItem testFoodItem1;
  private FoodItem testFoodItem2;
  private FoodItem testFoodItem3;
  private String expectedName = "Banana";
  private Double expectedUnitPrice = 0.19;
  private Integer expectedQuantity = 5;
  private Integer expectedMaxQuantity = 15;

  @Before
  public void setUp() throws Exception {
    testFoodItem1 = new Fruit(expectedName, expectedUnitPrice, expectedQuantity,
        expectedMaxQuantity, 2032021, 2172021);
    testFoodItem2 = new Rice("Jasmine Rice", 5.0, 2, 50);
    testFoodItem3 = testFoodItem1;

  }

  @Test
  public void getName() {
    assertEquals(expectedName, testFoodItem1.getName());
  }

  @Test
  public void getUnitPrice() {
    assertEquals(expectedUnitPrice, testFoodItem1.getUnitPrice());
  }

  @Test
  public void getAvailableQuantity() {
    assertEquals(expectedQuantity, testFoodItem1.getAvailableQuantity());
  }

  @Test
  public void getMaxQuantity() {
    assertEquals(expectedMaxQuantity, testFoodItem1.getMaxQuantity());
  }

  @Test
  public void testEqualsReflexivity() {
    assertTrue(testFoodItem1.equals(testFoodItem1));
  }

  @Test
  public void testEqualsSymmetry() {
    assertTrue(testFoodItem1.equals(testFoodItem2) == testFoodItem2.equals(testFoodItem1));
  }

  @Test
  public void testEqualsNullTest() {
    assertFalse(testFoodItem1.equals(null));
  }

  @Test
  public void testEqualsConsistency(){
    Boolean testResult = testFoodItem1.equals(testFoodItem2);
    assertEquals(testResult, testFoodItem1.equals(testFoodItem2));
  }

  @Test
  public void testEqualsTransitivity(){
    testFoodItem2 = testFoodItem1;
    assertTrue(testFoodItem1.equals(testFoodItem2) && testFoodItem1.equals(testFoodItem3) &&
        testFoodItem2.equals(testFoodItem3));
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void testToString() {
  }
}