package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StarDestroyerTest {

  private StarDestroyer starDestroyer0;
  private StarDestroyer starDestroyer1;
  private StarDestroyer starDestroyer2;
  private StarDestroyer starDestroyer3;
  private StarDestroyer starDestroyer4;

  @Before
  public void setUp() throws Exception {
    starDestroyer0 = new StarDestroyer(0, 0);
    starDestroyer1 = new StarDestroyer(10, 100);
    starDestroyer2 = new StarDestroyer(50, 60);
    starDestroyer3 = new StarDestroyer(60, 40);
    starDestroyer4 = new StarDestroyer(100, 30);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelNegative() throws Exception {
    StarDestroyer illegal = new StarDestroyer(-10, 50);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelExcess() throws Exception {
    StarDestroyer illegal = new StarDestroyer(101, 50);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelNegative() throws Exception {
    StarDestroyer illegal = new StarDestroyer(50, -10);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelExcess() throws Exception {
    StarDestroyer illegal = new StarDestroyer(50, 101);
  }

  @Test
  public void getFuelLevel() {
    assertEquals(new Integer(0), starDestroyer0.getFuelLevel());
    assertEquals(new Integer(10), starDestroyer1.getFuelLevel());
    assertEquals(new Integer(50), starDestroyer2.getFuelLevel());
    assertEquals(new Integer(60), starDestroyer3.getFuelLevel());
    assertEquals(new Integer(100), starDestroyer4.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals(new Integer(0), starDestroyer0.getDestructionLevel());
    assertEquals(new Integer(100), starDestroyer1.getDestructionLevel());
    assertEquals(new Integer(60), starDestroyer2.getDestructionLevel());
    assertEquals(new Integer(40), starDestroyer3.getDestructionLevel());
    assertEquals(new Integer(30), starDestroyer4.getDestructionLevel());
  }

  @Test
  public void isDestroyed() {
    assertFalse(starDestroyer0.isDestroyed());
    assertTrue(starDestroyer1.isDestroyed());
    assertFalse(starDestroyer2.isDestroyed());
    assertFalse(starDestroyer3.isDestroyed());
    assertFalse(starDestroyer4.isDestroyed());
  }

  @Test
  public void increaseFuelHelper() {
    assertEquals(new Integer(0), starDestroyer0.increaseFuelHelper(0));
    assertEquals(new Integer(30), starDestroyer1.increaseFuelHelper(20));
    assertEquals(new Integer(90), starDestroyer2.increaseFuelHelper(40));
    assertEquals(new Integer(100), starDestroyer3.increaseFuelHelper(110));
    assertEquals(new Integer(100), starDestroyer4.increaseFuelHelper(11));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper1() throws Exception {
    Integer illegal = starDestroyer0.increaseFuelHelper(-1);
  }

  @Test
  public void decreaseFuelHelper() {
    assertEquals(new Integer(0), starDestroyer0.decreaseFuelHelper(1));
    assertEquals(new Integer(0), starDestroyer1.decreaseFuelHelper(80));
    assertEquals(new Integer(20), starDestroyer2.decreaseFuelHelper(30));
    assertEquals(new Integer(45), starDestroyer3.decreaseFuelHelper(15));
    assertEquals(new Integer(10), starDestroyer4.decreaseFuelHelper(90));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper2() throws Exception {
    Integer illegal = starDestroyer0.decreaseFuelHelper(-1);
  }

  @Test
  public void increaseDestructionLevelHelper() {
    assertEquals(new Integer(1), starDestroyer0.increaseDestructionLevelHelper(1));
    assertEquals(new Integer(100), starDestroyer1.increaseDestructionLevelHelper(20));
    assertEquals(new Integer(70), starDestroyer2.increaseDestructionLevelHelper(10));
    assertEquals(new Integer(100), starDestroyer3.increaseDestructionLevelHelper(90));
    assertEquals(new Integer(45), starDestroyer4.increaseDestructionLevelHelper(15));
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelHelper() throws Exception {
    Integer illegal = starDestroyer0.increaseDestructionLevelHelper(-5);
  }

  @Test
  public void increaseFuel() throws Exception {
    StarDestroyer expStarDestroyer0 = new StarDestroyer(0, 0);
    StarDestroyer expStarDestroyer1 = new StarDestroyer(30, 100);
    StarDestroyer expStarDestroyer2 = new StarDestroyer(80, 60);
    StarDestroyer expStarDestroyer3 = new StarDestroyer(100, 40);
    StarDestroyer expStarDestroyer4 = new StarDestroyer(100, 30);

    assertEquals(expStarDestroyer0, starDestroyer0.increaseFuel(0));
    assertEquals(expStarDestroyer1, starDestroyer1.increaseFuel(20));
    assertEquals(expStarDestroyer2, starDestroyer2.increaseFuel(30));
    assertEquals(expStarDestroyer3, starDestroyer3.increaseFuel(70));
    assertEquals(expStarDestroyer4, starDestroyer4.increaseFuel(10));
  }

  @Test
  public void testIllegalFuelIncrease() throws Exception {
    IStarship illegal = starDestroyer0.increaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void decreaseFuel() throws Exception {
    StarDestroyer expStarDestroyer0 = new StarDestroyer(0, 0);
    StarDestroyer expStarDestroyer1 = new StarDestroyer(0, 100);
    StarDestroyer expStarDestroyer2 = new StarDestroyer(20, 60);
    StarDestroyer expStarDestroyer3 = new StarDestroyer(10, 40);
    StarDestroyer expStarDestroyer4 = new StarDestroyer(30, 30);

    assertEquals(expStarDestroyer0, starDestroyer0.decreaseFuel(10));
    assertEquals(expStarDestroyer1, starDestroyer1.decreaseFuel(10));
    assertEquals(expStarDestroyer2, starDestroyer2.decreaseFuel(30));
    assertEquals(expStarDestroyer3, starDestroyer3.decreaseFuel(50));
    assertEquals(expStarDestroyer4, starDestroyer4.decreaseFuel(70));
  }

  @Test
  public void testIllegalFuelDecrease() throws Exception {
    IStarship illegal = starDestroyer0.decreaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void increaseDestructionLevel() throws Exception {
    StarDestroyer expStarDestroyer0 = new StarDestroyer(0, 0);
    StarDestroyer expStarDestroyer1 = new StarDestroyer(10, 100);
    StarDestroyer expStarDestroyer2 = new StarDestroyer(50, 90);
    StarDestroyer expStarDestroyer3 = new StarDestroyer(60, 100);
    StarDestroyer expStarDestroyer4 = new StarDestroyer(100, 50);

    assertEquals(expStarDestroyer0, starDestroyer0.increaseDestructionLevel(0));
    assertEquals(expStarDestroyer1, starDestroyer1.increaseDestructionLevel(10));
    assertEquals(expStarDestroyer2, starDestroyer2.increaseDestructionLevel(30));
    assertEquals(expStarDestroyer3, starDestroyer3.increaseDestructionLevel(70));
    assertEquals(expStarDestroyer4, starDestroyer4.increaseDestructionLevel(20));
  }

  @Test
  public void testIllegalDestructionLevelIncrease() throws Exception {
    IStarship illegal = starDestroyer0.increaseDestructionLevel(-5);
    assertEquals(null, illegal);
  }

  @Test
  public void attack() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);
    XWingFighter opponent1 = new XWingFighter(60, 50);
    TieFighter opponent2 = new TieFighter(80, 20);
    StarDestroyer opponent3 = new StarDestroyer(10, 60);

    AWingFighter expOpponent0 = new AWingFighter(50, 0);
    XWingFighter expOpponent1 = new XWingFighter(60, 100);
    TieFighter expOpponent2 = new TieFighter(80, 50);
    StarDestroyer expOpponent3 = new StarDestroyer(10, 100);

    assertEquals(expOpponent0, starDestroyer0.attack(opponent0, 0));
    assertEquals(expOpponent1, starDestroyer1.attack(opponent1, 50));
    assertEquals(expOpponent2, starDestroyer2.attack(opponent2, 30));
    assertEquals(expOpponent3, starDestroyer3.attack(opponent3, 50));
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack1() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);

    IStarship illegal = starDestroyer0.attack(opponent0, -5);
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack2() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);

    IStarship illegal = starDestroyer0.attack(opponent0, 51);
  }

  @Test
  public void testToString() {
    String expected0 = "Starship- \n"
        + "Fuel Level = 0\n"
        + "Destruction Level = 0\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Star destroyer\n";

    String expected1 = "Starship- \n"
        + "Fuel Level = 10\n"
        + "Destruction Level = 100\n"
        + "Destroyed? = true\n"
        + "Type- first order\n"
        + "Subtype- Star destroyer\n";

    String expected2 = "Starship- \n"
        + "Fuel Level = 50\n"
        + "Destruction Level = 60\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Star destroyer\n";

    String expected3 = "Starship- \n"
        + "Fuel Level = 60\n"
        + "Destruction Level = 40\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Star destroyer\n";

    String expected4 = "Starship- \n"
        + "Fuel Level = 100\n"
        + "Destruction Level = 30\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Star destroyer\n";

    assertEquals(expected0, starDestroyer0.toString());
    assertEquals(expected1, starDestroyer1.toString());
    assertEquals(expected2, starDestroyer2.toString());
    assertEquals(expected3, starDestroyer3.toString());
    assertEquals(expected4, starDestroyer4.toString());
  }

  @Test
  public void equals() throws Exception {
    assertTrue(starDestroyer0.equals(starDestroyer0));
    assertFalse(starDestroyer0.equals(null));
    assertFalse(starDestroyer0.equals(new Integer(8)));
    assertFalse(starDestroyer0.equals(starDestroyer1));
    assertTrue(starDestroyer0.equals(new StarDestroyer(0, 0)));
  }

  @Test
  public void testHashCode() throws Exception {
    StarDestroyer dupStarDestroyer0 = new StarDestroyer(0, 0);
    Integer test0 = new Integer(2);

    assertEquals(starDestroyer0.hashCode(), starDestroyer0.hashCode());
    assertNotEquals(starDestroyer0.hashCode(), starDestroyer1.hashCode());
    assertEquals(starDestroyer0.hashCode(), dupStarDestroyer0.hashCode());
    assertNotEquals(starDestroyer0.hashCode(), test0.hashCode());
  }
}