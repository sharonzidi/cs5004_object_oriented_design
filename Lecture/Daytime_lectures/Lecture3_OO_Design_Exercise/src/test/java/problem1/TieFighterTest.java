package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TieFighterTest {

  private TieFighter tieFighter0;
  private TieFighter tieFighter1;
  private TieFighter tieFighter2;
  private TieFighter tieFighter3;
  private TieFighter tieFighter4;

  @Before
  public void setUp() throws Exception {
    tieFighter0 = new TieFighter(90, 0);
    tieFighter1 = new TieFighter(35, 10);
    tieFighter2 = new TieFighter(20, 30);
    tieFighter3 = new TieFighter(40, 60);
    tieFighter4 = new TieFighter(100, 100);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelNegative() throws Exception {
    TieFighter illegal = new TieFighter(-10, 50);
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelExcess() throws Exception {
    TieFighter illegal = new TieFighter(101, 50);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelNegative() throws Exception {
    TieFighter illegal = new TieFighter(50, -10);
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelExcess() throws Exception {
    TieFighter illegal = new TieFighter(50, 101);
  }

  @Test
  public void getFuelLevel() {
    assertEquals(new Integer(90), tieFighter0.getFuelLevel());
    assertEquals(new Integer(35), tieFighter1.getFuelLevel());
    assertEquals(new Integer(20), tieFighter2.getFuelLevel());
    assertEquals(new Integer(40), tieFighter3.getFuelLevel());
    assertEquals(new Integer(100), tieFighter4.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals(new Integer(0), tieFighter0.getDestructionLevel());
    assertEquals(new Integer(10), tieFighter1.getDestructionLevel());
    assertEquals(new Integer(30), tieFighter2.getDestructionLevel());
    assertEquals(new Integer(60), tieFighter3.getDestructionLevel());
    assertEquals(new Integer(100), tieFighter4.getDestructionLevel());
  }

  @Test
  public void getIsDestroyed() {
    assertFalse(tieFighter0.isDestroyed());
    assertFalse(tieFighter1.isDestroyed());
    assertFalse(tieFighter2.isDestroyed());
    assertFalse(tieFighter3.isDestroyed());
    assertTrue(tieFighter4.isDestroyed());
  }

  @Test
  public void increaseFuelHelper() {
    assertEquals(new Integer(90), tieFighter0.increaseFuelHelper(0));
    assertEquals(new Integer(45), tieFighter1.increaseFuelHelper(10));
    assertEquals(new Integer(70), tieFighter2.increaseFuelHelper(50));
    assertEquals(new Integer(100), tieFighter3.increaseFuelHelper(120));
    assertEquals(new Integer(100), tieFighter4.increaseFuelHelper(1));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper1() throws Exception {
    Integer illegal = tieFighter0.increaseFuelHelper(-1);
  }

  @Test
  public void decreaseFuelHelper() {
    assertEquals(new Integer(89), tieFighter0.decreaseFuelHelper(1));
    assertEquals(new Integer(15), tieFighter1.decreaseFuelHelper(20));
    assertEquals(new Integer(0), tieFighter2.decreaseFuelHelper(30));
    assertEquals(new Integer(35), tieFighter3.decreaseFuelHelper(5));
    assertEquals(new Integer(10), tieFighter4.decreaseFuelHelper(90));
  }

  @Test(expected = InvalidFuelException.class)
  public void testIllegalFuelHelper2() throws Exception {
    Integer illegal = tieFighter0.decreaseFuelHelper(-1);
  }

  @Test
  public void increaseDestructionLevelHelper() {
    assertEquals(new Integer(1), tieFighter0.increaseDestructionLevelHelper(1));
    assertEquals(new Integer(20), tieFighter1.increaseDestructionLevelHelper(10));
    assertEquals(new Integer(35), tieFighter2.increaseDestructionLevelHelper(5));
    assertEquals(new Integer(100), tieFighter3.increaseDestructionLevelHelper(90));
    assertEquals(new Integer(100), tieFighter4.increaseDestructionLevelHelper(1));
  }

  @Test(expected = InvalidDestructionLevelException.class)
  public void testIllegalDestructionLevelHelper() throws Exception {
    Integer illegal = tieFighter0.increaseDestructionLevelHelper(-5);
  }

  @Test
  public void increaseFuel() throws Exception {
    TieFighter expTieFighter0 = new TieFighter(90, 0);
    TieFighter expTieFighter1 = new TieFighter(45, 10);
    TieFighter expTieFighter2 = new TieFighter(60, 30);
    TieFighter expTieFighter3 = new TieFighter(90, 60);
    TieFighter expTieFighter4 = new TieFighter(100, 100);

    assertEquals(expTieFighter0, tieFighter0.increaseFuel(0));
    assertEquals(expTieFighter1, tieFighter1.increaseFuel(10));
    assertEquals(expTieFighter2, tieFighter2.increaseFuel(40));
    assertEquals(expTieFighter3, tieFighter3.increaseFuel(50));
    assertEquals(expTieFighter4, tieFighter4.increaseFuel(5));
  }

  @Test
  public void testIllegalFuelIncrease() throws Exception {
    IStarship illegal = tieFighter0.increaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void decreaseFuel() throws Exception {
    TieFighter expTieFighter0 = new TieFighter(80, 0);
    TieFighter expTieFighter1 = new TieFighter(25, 10);
    TieFighter expTieFighter2 = new TieFighter(0, 30);
    TieFighter expTieFighter3 = new TieFighter(0, 60);
    TieFighter expTieFighter4 = new TieFighter(0, 100);

    assertEquals(expTieFighter0, tieFighter0.decreaseFuel(10));
    assertEquals(expTieFighter1, tieFighter1.decreaseFuel(10));
    assertEquals(expTieFighter2, tieFighter2.decreaseFuel(30));
    assertEquals(expTieFighter3, tieFighter3.decreaseFuel(70));
    assertEquals(expTieFighter4, tieFighter4.decreaseFuel(110));
  }

  @Test
  public void testIllegalFuelDecrease() throws Exception {
    IStarship illegal = tieFighter0.decreaseFuel(-1);
    assertEquals(null, illegal);
  }

  @Test
  public void increaseDestructionLevel() throws Exception {
    TieFighter expTieFighter0 = new TieFighter(90, 0);
    TieFighter expTieFighter1 = new TieFighter(35, 20);
    TieFighter expTieFighter2 = new TieFighter(20, 60);
    TieFighter expTieFighter3 = new TieFighter(40, 100);
    TieFighter expTieFighter4 = new TieFighter(100, 100);

    assertEquals(expTieFighter0, tieFighter0.increaseDestructionLevel(0));
    assertEquals(expTieFighter1, tieFighter1.increaseDestructionLevel(10));
    assertEquals(expTieFighter2, tieFighter2.increaseDestructionLevel(30));
    assertEquals(expTieFighter3, tieFighter3.increaseDestructionLevel(70));
    assertEquals(expTieFighter4, tieFighter4.increaseDestructionLevel(20));
  }

  @Test
  public void testIllegalDestructionLevelIncrease() throws Exception {
    IStarship illegal = tieFighter0.increaseDestructionLevel(-5);
    assertEquals(null, illegal);
  }

  @Test
  public void attack() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);
    XWingFighter opponent1 = new XWingFighter(60, 80);
    TieFighter opponent2 = new TieFighter(80, 40);
    StarDestroyer opponent3 = new StarDestroyer(10, 100);

    AWingFighter expOpponent0 = new AWingFighter(50, 0);
    XWingFighter expOpponent1 = new XWingFighter(60, 100);
    TieFighter expOpponent2 = new TieFighter(80, 55);
    StarDestroyer expOpponent3 = new StarDestroyer(10, 100);

    assertEquals(expOpponent0, tieFighter0.attack(opponent0, 0));
    assertEquals(expOpponent1, tieFighter1.attack(opponent1, 25));
    assertEquals(expOpponent2, tieFighter2.attack(opponent2, 15));
    assertEquals(expOpponent3, tieFighter3.attack(opponent3, 25));
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack1() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);

    IStarship illegal = tieFighter0.attack(opponent0, -5);
  }

  @Test(expected = IllegalAttackPowerException.class)
  public void testIllegalAttack2() throws Exception {
    AWingFighter opponent0 = new AWingFighter(50, 0);

    IStarship illegal = tieFighter0.attack(opponent0, 26);
  }

  @Test
  public void testToString() {
    String expected0 = "Starship- \n"
        + "Fuel Level = 90\n"
        + "Destruction Level = 0\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Tie fighter\n";

    String expected1 = "Starship- \n"
        + "Fuel Level = 35\n"
        + "Destruction Level = 10\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Tie fighter\n";

    String expected2 = "Starship- \n"
        + "Fuel Level = 20\n"
        + "Destruction Level = 30\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Tie fighter\n";

    String expected3 = "Starship- \n"
        + "Fuel Level = 40\n"
        + "Destruction Level = 60\n"
        + "Destroyed? = false\n"
        + "Type- first order\n"
        + "Subtype- Tie fighter\n";

    String expected4 = "Starship- \n"
        + "Fuel Level = 100\n"
        + "Destruction Level = 100\n"
        + "Destroyed? = true\n"
        + "Type- first order\n"
        + "Subtype- Tie fighter\n";

    assertEquals(expected0, tieFighter0.toString());
    assertEquals(expected1, tieFighter1.toString());
    assertEquals(expected2, tieFighter2.toString());
    assertEquals(expected3, tieFighter3.toString());
    assertEquals(expected4, tieFighter4.toString());
  }

  @Test
  public void equals() throws Exception {
    assertTrue(tieFighter0.equals(tieFighter0));
    assertFalse(tieFighter0.equals(null));
    assertFalse(tieFighter0.equals(new Integer(8)));
    assertFalse(tieFighter0.equals(tieFighter1));
    assertTrue(tieFighter0.equals(new TieFighter(90, 0)));
  }

  @Test
  public void testHashCode() throws Exception {
    TieFighter dupTieFighter0 = new TieFighter(90, 0);
    Integer test0 = new Integer(2);

    assertEquals(tieFighter0.hashCode(), tieFighter0.hashCode());
    assertNotEquals(tieFighter0.hashCode(), tieFighter1.hashCode());
    assertEquals(tieFighter0.hashCode(), dupTieFighter0.hashCode());
    assertNotEquals(tieFighter0.hashCode(), test0.hashCode());
  }
}