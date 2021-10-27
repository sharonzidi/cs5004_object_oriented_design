package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XWingFighterTest {

  private XWingFighter xWing0;
  private XWingFighter xWing1;
  private XWingFighter xWing2;
  private XWingFighter xWing3;
  private XWingFighter xWing4;

  @Before
  public void setUp() throws Exception {
    xWing0 = new XWingFighter(0, 10);
    xWing1 = new XWingFighter(100, 10);
    xWing2 = new XWingFighter(50, 100);
    xWing3 = new XWingFighter(20, 80);
    xWing4 = new XWingFighter(30, 60);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelNegative() throws Exception {
    XWingFighter illegal = new XWingFighter(-10, 50);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelExcess() throws Exception {
    XWingFighter illegal = new XWingFighter(101, 50);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelNegative() throws Exception {
    XWingFighter illegal = new XWingFighter(50, -10);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelExcess() throws Exception {
    XWingFighter illegal = new XWingFighter(50, 101);
  }

  @Test
  public void getFuelLevel() {
    assertEquals(new Integer(0), xWing0.getFuelLevel());
    assertEquals(new Integer(100), xWing1.getFuelLevel());
    assertEquals(new Integer(50), xWing2.getFuelLevel());
    assertEquals(new Integer(20), xWing3.getFuelLevel());
    assertEquals(new Integer(30), xWing4.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals(new Integer(10), xWing0.getDestructionLevel());
    assertEquals(new Integer(10), xWing1.getDestructionLevel());
    assertEquals(new Integer(100), xWing2.getDestructionLevel());
    assertEquals(new Integer(80), xWing3.getDestructionLevel());
    assertEquals(new Integer(60), xWing4.getDestructionLevel());
  }

  @Test
  public void getIsDestroyed() {
    assertFalse(xWing0.isDestroyed());
    assertFalse(xWing1.isDestroyed());
    assertTrue(xWing2.isDestroyed());
    assertFalse(xWing3.isDestroyed());
    assertFalse(xWing4.isDestroyed());
  }

  @Test
  public void increaseFuelHelper() {
    assertEquals(new Integer(0), xWing0.increaseFuelHelper(0));
    assertEquals(new Integer(100), xWing1.increaseFuelHelper(10));
    assertEquals(new Integer(100), xWing2.increaseFuelHelper(50));
    assertEquals(new Integer(100), xWing3.increaseFuelHelper(120));
    assertEquals(new Integer(31), xWing4.increaseFuelHelper(1));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper1() throws Exception {
    Integer illegal = xWing0.increaseFuelHelper(-1);
  }

  @Test
  public void decreaseFuelHelper() {
    assertEquals(new Integer(0), xWing0.decreaseFuelHelper(1));
    assertEquals(new Integer(80), xWing1.decreaseFuelHelper(20));
    assertEquals(new Integer(20), xWing2.decreaseFuelHelper(30));
    assertEquals(new Integer(15), xWing3.decreaseFuelHelper(5));
    assertEquals(new Integer(0), xWing4.decreaseFuelHelper(90));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper2() throws Exception {
    Integer illegal = xWing0.decreaseFuelHelper(-1);
  }

  @Test
  public void increaseDestructionLevelHelper() {
    assertEquals(new Integer(11), xWing0.increaseDestructionLevelHelper(1));
    assertEquals(new Integer(20), xWing1.increaseDestructionLevelHelper(10));
    assertEquals(new Integer(100), xWing2.increaseDestructionLevelHelper(5));
    assertEquals(new Integer(100), xWing3.increaseDestructionLevelHelper(90));
    assertEquals(new Integer(61), xWing4.increaseDestructionLevelHelper(1));
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelHelper() throws Exception {
    Integer illegal = xWing0.increaseDestructionLevelHelper(-5);
  }

  @Test
  public void increaseFuel() throws Exception {
    XWingFighter expXWing0 = new XWingFighter(0, 10);
    XWingFighter expXWing1 = new XWingFighter(100, 10);
    XWingFighter expXWing2 = new XWingFighter(90, 100);
    XWingFighter expXWing3 = new XWingFighter(70, 80);
    XWingFighter expXWing4 = new XWingFighter(35, 60);

    assertEquals(expXWing0, xWing0.increaseFuel(0));
    assertEquals(expXWing1, xWing1.increaseFuel(10));
    assertEquals(expXWing2, xWing2.increaseFuel(40));
    assertEquals(expXWing3, xWing3.increaseFuel(50));
    assertEquals(expXWing4, xWing4.increaseFuel(5));
  }

  @Test
  public void testIllegalFuelIncrease() throws Exception {
    IStarship illegal = xWing0.increaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void decreaseFuel() throws Exception {
    XWingFighter expXWing0 = new XWingFighter(0, 10);
    XWingFighter expXWing1 = new XWingFighter(90, 10);
    XWingFighter expXWing2 = new XWingFighter(20, 100);
    XWingFighter expXWing3 = new XWingFighter(0, 80);
    XWingFighter expXWing4 = new XWingFighter(0, 60);

    assertEquals(expXWing0, xWing0.decreaseFuel(10));
    assertEquals(expXWing1, xWing1.decreaseFuel(10));
    assertEquals(expXWing2, xWing2.decreaseFuel(30));
    assertEquals(expXWing3, xWing3.decreaseFuel(70));
    assertEquals(expXWing4, xWing4.decreaseFuel(110));
  }

  @Test
  public void testIllegalFuelDecrease() throws Exception {
    IStarship illegal = xWing0.decreaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void increaseDestructionLevel() throws Exception {
    XWingFighter expXWing0 = new XWingFighter(0, 10);
    XWingFighter expXWing1 = new XWingFighter(100, 20);
    XWingFighter expXWing2 = new XWingFighter(50, 100);
    XWingFighter expXWing3 = new XWingFighter(20, 100);
    XWingFighter expXWing4 = new XWingFighter(30, 80);

    assertEquals(expXWing0, xWing0.increaseDestructionLevel(0));
    assertEquals(expXWing1, xWing1.increaseDestructionLevel(10));
    assertEquals(expXWing2, xWing2.increaseDestructionLevel(30));
    assertEquals(expXWing3, xWing3.increaseDestructionLevel(70));
    assertEquals(expXWing4, xWing4.increaseDestructionLevel(20));
  }

  @Test
  public void testIllegalDestructionLevelIncrease() throws Exception {
    IStarship illegal = xWing0.increaseDestructionLevel(-5);
    assertEquals(null, illegal);
  }

  @Test
  public void attack() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);
    XWingFighter opponent1 = new XWingFighter(60, 50);
    TieFighter opponent2 = new TieFighter(80, 80);
    StarDestroyer opponent3 = new StarDestroyer(10, 60);

    AWingFighter expOpponent0 = new AWingFighter(50, 0);
    XWingFighter expOpponent1 = new XWingFighter(60, 65);
    TieFighter expOpponent2 = new TieFighter(80, 100);
    StarDestroyer expOpponent3 = new StarDestroyer(10, 100);

    assertEquals(expOpponent0, xWing0.attack(opponent0, 0));
    assertEquals(expOpponent1, xWing1.attack(opponent1, 15));
    assertEquals(expOpponent2, xWing2.attack(opponent2, 40));
    assertEquals(expOpponent3, xWing3.attack(opponent3, 40));
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack1() throws Exception {
    TieFighter opponent0 = new TieFighter(80, 80);

    IStarship illegal = xWing0.attack(opponent0, -5);
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack2() throws Exception {
    TieFighter opponent0 = new TieFighter(80, 80);

    IStarship illegal = xWing0.attack(opponent0, 41);
  }

  @Test
  public void testToString() {
    String expected0 = "Starship- \n"
        + "Fuel Level = 0\n"
        + "Destruction Level = 10\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- X-wing fighter\n";

    String expected1 = "Starship- \n"
        + "Fuel Level = 100\n"
        + "Destruction Level = 10\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- X-wing fighter\n";

    String expected2 = "Starship- \n"
        + "Fuel Level = 50\n"
        + "Destruction Level = 100\n"
        + "Destroyed? = true\n"
        + "Type- resistance\n"
        + "Subtype- X-wing fighter\n";

    String expected3 = "Starship- \n"
        + "Fuel Level = 20\n"
        + "Destruction Level = 80\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- X-wing fighter\n";

    String expected4 = "Starship- \n"
        + "Fuel Level = 30\n"
        + "Destruction Level = 60\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- X-wing fighter\n";

    assertEquals(expected0, xWing0.toString());
    assertEquals(expected1, xWing1.toString());
    assertEquals(expected2, xWing2.toString());
    assertEquals(expected3, xWing3.toString());
    assertEquals(expected4, xWing4.toString());
  }

  @Test
  public void equals() throws Exception {
    assertTrue(xWing0.equals(xWing0));
    assertFalse(xWing0.equals(null));
    assertFalse(xWing0.equals(new Integer(8)));
    assertFalse(xWing0.equals(xWing1));
    assertTrue(xWing0.equals(new XWingFighter(0, 10)));
  }

  @Test
  public void testHashCode() throws Exception {
    XWingFighter dupXWing0 = new XWingFighter(0, 10);
    Integer test0 = new Integer(9);

    assertEquals(xWing0.hashCode(), xWing0.hashCode());
    assertNotEquals(xWing0.hashCode(), xWing1.hashCode());
    assertEquals(xWing0.hashCode(), dupXWing0.hashCode());
    assertNotEquals(xWing0.hashCode(), test0.hashCode());
  }
}