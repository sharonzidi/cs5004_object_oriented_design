package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AWingFighterTest {

  private AWingFighter aWing0;
  private AWingFighter aWing1;
  private AWingFighter aWing2;
  private AWingFighter aWing3;
  private AWingFighter aWing4;

  @Before
  public void setUp() throws Exception {
    aWing0 = new AWingFighter(0, 0);
    aWing1 = new AWingFighter(20, 80);
    aWing2 = new AWingFighter(50, 50);
    aWing3 = new AWingFighter(70, 40);
    aWing4 = new AWingFighter(100, 100);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelNegative() throws Exception {
    AWingFighter illegal = new AWingFighter(-10, 50);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelExcess() throws Exception {
    AWingFighter illegal = new AWingFighter(101, 50);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelNegative() throws Exception {
    AWingFighter illegal = new AWingFighter(50, -10);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelExcess() throws Exception {
    AWingFighter illegal = new AWingFighter(50, 101);
  }

  @Test
  public void getFuelLevel() {
    assertEquals(new Integer(0), aWing0.getFuelLevel());
    assertEquals(new Integer(20), aWing1.getFuelLevel());
    assertEquals(new Integer(50), aWing2.getFuelLevel());
    assertEquals(new Integer(70), aWing3.getFuelLevel());
    assertEquals(new Integer(100), aWing4.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals(new Integer(0), aWing0.getDestructionLevel());
    assertEquals(new Integer(80), aWing1.getDestructionLevel());
    assertEquals(new Integer(50), aWing2.getDestructionLevel());
    assertEquals(new Integer(40), aWing3.getDestructionLevel());
    assertEquals(new Integer(100), aWing4.getDestructionLevel());
  }

  @Test
  public void getIsDestroyed() {
    assertFalse(aWing0.isDestroyed());
    assertFalse(aWing1.isDestroyed());
    assertFalse(aWing2.isDestroyed());
    assertFalse(aWing3.isDestroyed());
    assertTrue(aWing4.isDestroyed());
  }

  @Test
  public void increaseFuelHelper() {
    assertEquals(new Integer(0), aWing0.increaseFuelHelper(0));
    assertEquals(new Integer(30), aWing1.increaseFuelHelper(10));
    assertEquals(new Integer(100), aWing2.increaseFuelHelper(50));
    assertEquals(new Integer(100), aWing3.increaseFuelHelper(120));
    assertEquals(new Integer(100), aWing4.increaseFuelHelper(1));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper1() throws Exception {
    Integer illegal = aWing0.increaseFuelHelper(-1);
  }

  @Test
  public void decreaseFuelHelper() {
    assertEquals(new Integer(0), aWing0.decreaseFuelHelper(1));
    assertEquals(new Integer(0), aWing1.decreaseFuelHelper(20));
    assertEquals(new Integer(20), aWing2.decreaseFuelHelper(30));
    assertEquals(new Integer(65), aWing3.decreaseFuelHelper(5));
    assertEquals(new Integer(10), aWing4.decreaseFuelHelper(90));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper2() throws Exception {
    Integer illegal = aWing0.decreaseFuelHelper(-1);
  }

  @Test
  public void increaseDestructionLevelHelper() {
    assertEquals(new Integer(1), aWing0.increaseDestructionLevelHelper(1));
    assertEquals(new Integer(90), aWing1.increaseDestructionLevelHelper(10));
    assertEquals(new Integer(55), aWing2.increaseDestructionLevelHelper(5));
    assertEquals(new Integer(100), aWing3.increaseDestructionLevelHelper(90));
    assertEquals(new Integer(100), aWing4.increaseDestructionLevelHelper(1));
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelHelper() throws Exception {
    Integer illegal = aWing0.increaseDestructionLevelHelper(-5);
  }

  @Test
  public void increaseFuel() throws Exception {
    AWingFighter expAWing0 = new AWingFighter(0, 0);
    AWingFighter expAWing1 = new AWingFighter(30, 80);
    AWingFighter expAWing2 = new AWingFighter(90, 50);
    AWingFighter expAWing3 = new AWingFighter(100, 40);
    AWingFighter expAWing4 = new AWingFighter(100, 100);

    assertEquals(expAWing0, aWing0.increaseFuel(0));
    assertEquals(expAWing1, aWing1.increaseFuel(10));
    assertEquals(expAWing2, aWing2.increaseFuel(40));
    assertEquals(expAWing3, aWing3.increaseFuel(50));
    assertEquals(expAWing4, aWing4.increaseFuel(5));
  }

  @Test
  public void testIllegalFuelIncrease() throws Exception {
    IStarship illegal = aWing0.increaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void decreaseFuel() throws Exception {
    AWingFighter expAWing0 = new AWingFighter(0, 0);
    AWingFighter expAWing1 = new AWingFighter(10, 80);
    AWingFighter expAWing2 = new AWingFighter(20, 50);
    AWingFighter expAWing3 = new AWingFighter(0, 40);
    AWingFighter expAWing4 = new AWingFighter(0, 100);

    assertEquals(expAWing0, aWing0.decreaseFuel(10));
    assertEquals(expAWing1, aWing1.decreaseFuel(10));
    assertEquals(expAWing2, aWing2.decreaseFuel(30));
    assertEquals(expAWing3, aWing3.decreaseFuel(70));
    assertEquals(expAWing4, aWing4.decreaseFuel(110));
  }

  @Test
  public void testIllegalFuelDecrease() throws Exception {
    IStarship illegal = aWing0.decreaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void increaseDestructionLevel() throws Exception {
    AWingFighter expAWing0 = new AWingFighter(0, 0);
    AWingFighter expAWing1 = new AWingFighter(20, 90);
    AWingFighter expAWing2 = new AWingFighter(50, 80);
    AWingFighter expAWing3 = new AWingFighter(70, 100);
    AWingFighter expAWing4 = new AWingFighter(100, 100);

    assertEquals(expAWing0, aWing0.increaseDestructionLevel(0));
    assertEquals(expAWing1, aWing1.increaseDestructionLevel(10));
    assertEquals(expAWing2, aWing2.increaseDestructionLevel(30));
    assertEquals(expAWing3, aWing3.increaseDestructionLevel(70));
    assertEquals(expAWing4, aWing4.increaseDestructionLevel(20));
  }

  @Test
  public void testIllegalDestructionLevelIncrease() throws Exception {
    IStarship illegal = aWing0.increaseDestructionLevel(-5);
    assertEquals(null, illegal);
  }

  @Test
  public void attack() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);
    XWingFighter opponent1 = new XWingFighter(60, 50);
    TieFighter opponent2 = new TieFighter(80, 80);
    StarDestroyer opponent3 = new StarDestroyer(10, 70);

    AWingFighter expOpponent0 = new AWingFighter(50, 0);
    XWingFighter expOpponent1 = new XWingFighter(60, 72);
    TieFighter expOpponent2 = new TieFighter(80, 100);
    StarDestroyer expOpponent3 = new StarDestroyer(10, 100);

    assertEquals(expOpponent0, aWing0.attack(opponent0, 0));
    assertEquals(expOpponent1, aWing1.attack(opponent1, 22));
    assertEquals(expOpponent2, aWing2.attack(opponent2, 30));
    assertEquals(expOpponent3, aWing3.attack(opponent3, 30));
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack1() throws Exception {
    TieFighter opponent0 = new TieFighter(80, 80);

    IStarship illegal = aWing0.attack(opponent0, -5);
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack2() throws Exception {
    TieFighter opponent0 = new TieFighter(80, 80);

    IStarship illegal = aWing0.attack(opponent0, 31);
  }

  @Test
  public void testToString() {
    String expected0 = "Starship- \n"
        + "Fuel Level = 0\n"
        + "Destruction Level = 0\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- A-wing fighter\n";

    String expected1 = "Starship- \n"
        + "Fuel Level = 20\n"
        + "Destruction Level = 80\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- A-wing fighter\n";

    String expected2 = "Starship- \n"
        + "Fuel Level = 50\n"
        + "Destruction Level = 50\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- A-wing fighter\n";

    String expected3 = "Starship- \n"
        + "Fuel Level = 70\n"
        + "Destruction Level = 40\n"
        + "Destroyed? = false\n"
        + "Type- resistance\n"
        + "Subtype- A-wing fighter\n";

    String expected4 = "Starship- \n"
        + "Fuel Level = 100\n"
        + "Destruction Level = 100\n"
        + "Destroyed? = true\n"
        + "Type- resistance\n"
        + "Subtype- A-wing fighter\n";

    assertEquals(expected0, aWing0.toString());
    assertEquals(expected1, aWing1.toString());
    assertEquals(expected2, aWing2.toString());
    assertEquals(expected3, aWing3.toString());
    assertEquals(expected4, aWing4.toString());
  }

  @Test
  public void equals() throws Exception {
    assertTrue(aWing0.equals(aWing0));
    assertFalse(aWing0.equals(null));
    assertFalse(aWing0.equals(new Integer(8)));
    assertFalse(aWing0.equals(aWing1));
    assertTrue(aWing0.equals(new AWingFighter(0, 0)));
  }

  @Test
  public void testHashCode() throws Exception {
    AWingFighter dupAWing0 = new AWingFighter(0, 0);
    Integer test0 = new Integer(9);

    assertEquals(aWing0.hashCode(), aWing0.hashCode());
    assertNotEquals(aWing0.hashCode(), aWing1.hashCode());
    assertEquals(aWing0.hashCode(), dupAWing0.hashCode());
    assertNotEquals(aWing0.hashCode(), test0.hashCode());
  }
}
