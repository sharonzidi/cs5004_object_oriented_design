package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InfantTeacherTest {

  private Person teacher0;
  private Person teacher1;
  private Person teacher2;
  private Person teacher3;
  private Person teacher4;

  private Person coTeacher0;
  private Person coTeacher1;
  private Person coTeacher2;
  private Person coTeacher3;
  private Person coTeacher4;

  private InfantTeacher infant0;
  private InfantTeacher infant1;
  private InfantTeacher infant2;
  private InfantTeacher infant3;
  private InfantTeacher infant4;

  private InfantTeacher expInfant0;
  private InfantTeacher expInfant1;
  private InfantTeacher expInfant2;
  private InfantTeacher expInfant3;
  private InfantTeacher expInfant4;
  private InfantTeacher expInfant5;
  private InfantTeacher expInfant6;
  private InfantTeacher expInfant7;

  @Before
  public void setUp() throws Exception {
    teacher0 = new Person("Tamara", "Bonaci");
    teacher1 = new Person("Will", "Super");
    teacher2 = new Person("Kyle", "Boole");
    teacher3 = new Person("Todd", "Delonge");
    teacher4 = new Person("Sarah", "Knee");

    coTeacher0 = new Person("Emily", "Hi");
    coTeacher1 = new Person("Sarah", "Zoo");
    coTeacher2 = new Person("Peter", "Hams");
    coTeacher3 = new Person("Porter", "Fly");
    coTeacher4 = new Person("Alex", "Lok");

    infant0 = new InfantTeacher(teacher0, "Water", coTeacher0, 8, 8, 0, true);
    infant1 = new InfantTeacher(teacher1, "", coTeacher1, 1, 0, 1, false);
    infant2 = new InfantTeacher(teacher2, "Kids", coTeacher2, 6, 3, 3, false);
    infant3 = new InfantTeacher(teacher3, "Kiddos", coTeacher3, 5, 5, 5, false);
    infant4 = new InfantTeacher(teacher4, "Munchkins", coTeacher4, 3, 2, 3, true);

    Person expTeacher0 = new Person("Superman", "Bonaci");
    Person expTeacher1 = new Person("Will", "Super");
    Person expTeacher2 = new Person("Kyle", "Boole");
    Person expTeacher3 = new Person("Todd", "Delonge");
    Person expTeacher4 = new Person("Sarah", "Knee");

    Person expCoTeacher0 = new Person("Emily", "Hi");
    Person expCoTeacher1 = new Person("Sarah", "Zoo");
    Person expCoTeacher2 = new Person("Peter", "Hambini");
    Person expCoTeacher3 = new Person("Porter", "Fly");
    Person expCoTeacher4 = new Person("Alex", "Lok");

    expInfant0 = new InfantTeacher(expTeacher0, "Water", expCoTeacher0, 8, 8, 0, true);
    expInfant1 = new InfantTeacher(expTeacher1, "T", expCoTeacher1, 1, 0, 1, false);
    expInfant2 = new InfantTeacher(expTeacher2, "Kids", expCoTeacher2, 6, 3, 3, false);
    expInfant3 = new InfantTeacher(expTeacher3, "Kiddos", expCoTeacher3, 7, 5, 5, false);
    expInfant4 = new InfantTeacher(expTeacher4, "Munchkins", expCoTeacher4, 3, 1, 3, true);
    expInfant5 = new InfantTeacher(expTeacher4, "Munchkins", expCoTeacher4, 3, 2, 0, true);
    expInfant6 = new InfantTeacher(expTeacher4, "Munchkins", expCoTeacher4, 3, 2, 3, false);
    expInfant7 = new InfantTeacher(expTeacher4, "Munchkins", expCoTeacher4, 3, 2, 3, true);
  }

  @Test(expected = IllegalNumberOfChildrenException.class)
  public void testIllegalNumberOfChildrenZero() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    InfantTeacher illegal = new InfantTeacher(p1, "class", p2, 0, 0, 0, true);
  }

  @Test(expected = IllegalNumberOfChildrenException.class)
  public void testIllegalNumberOfChildrenAboveMax() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    InfantTeacher illegal = new InfantTeacher(p1, "class", p2, 9, 1, 1, true);
  }

  @Test(expected = IllegalNumberOfCrawlersException.class)
  public void testIllegalNumberOfCrawlersNegative() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    InfantTeacher illegal = new InfantTeacher(p1, "class", p2, 6, -1, 0, true);
  }

  @Test(expected = IllegalNumberOfCrawlersException.class)
  public void testIllegalNumberOfCrawlersTooMany() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    InfantTeacher illegal = new InfantTeacher(p1, "class", p2, 6, 7, 0, true);
  }

  @Test(expected = IllegalNumberOfWalkersException.class)
  public void testIllegalNumberOfWalkersNegative() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    InfantTeacher illegal = new InfantTeacher(p1, "class", p2, 6, 0, -1, true);
  }

  @Test(expected = IllegalNumberOfWalkersException.class)
  public void testIllegalNumberOfWalkersTooMany() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    InfantTeacher illegal = new InfantTeacher(p1, "class", p2, 6, 0, 7, true);
  }

  @Test
  public void getName() {
    assertEquals(new Person("Tamara", "Bonaci"), infant0.getName());
    assertEquals(new Person("Will", "Super"), infant1.getName());
    assertEquals(new Person("Kyle", "Boole"), infant2.getName());
    assertEquals(new Person("Todd", "Delonge"), infant3.getName());
    assertEquals(new Person("Sarah", "Knee"), infant4.getName());
  }

  @Test
  public void getClassroom() {
    assertEquals("Water", infant0.getClassroom());
    assertEquals("", infant1.getClassroom());
    assertEquals("Kids", infant2.getClassroom());
    assertEquals("Kiddos", infant3.getClassroom());
    assertEquals("Munchkins", infant4.getClassroom());
  }

  @Test
  public void getCoTeacher() {
    assertEquals(new Person("Emily", "Hi"), infant0.getCoTeacher());
    assertEquals(new Person("Sarah", "Zoo"), infant1.getCoTeacher());
    assertEquals(new Person("Peter", "Hams"), infant2.getCoTeacher());
    assertEquals(new Person("Porter", "Fly"), infant3.getCoTeacher());
    assertEquals(new Person("Alex", "Lok"), infant4.getCoTeacher());
  }

  @Test
  public void isOnVacation() {
    assertTrue(infant0.isOnVacation());
    assertFalse(infant1.isOnVacation());
    assertFalse(infant2.isOnVacation());
    assertFalse(infant3.isOnVacation());
    assertTrue(infant4.isOnVacation());
  }

  @Test
  public void getNumChildren() {
    assertEquals(new Integer(8), infant0.getNumChildren());
    assertEquals(new Integer(1), infant1.getNumChildren());
    assertEquals(new Integer(6), infant2.getNumChildren());
    assertEquals(new Integer(5), infant3.getNumChildren());
    assertEquals(new Integer(3), infant4.getNumChildren());
  }

  @Test
  public void getMaxChildren() {
    assertEquals(new Integer(8), infant0.getMaxChildren());
    assertEquals(new Integer(8), infant1.getMaxChildren());
    assertEquals(new Integer(8), infant2.getMaxChildren());
    assertEquals(new Integer(8), infant3.getMaxChildren());
    assertEquals(new Integer(8), infant4.getMaxChildren());
  }

  @Test
  public void getNumCrawlers() {
    assertEquals(new Integer(8), infant0.getNumCrawlers());
    assertEquals(new Integer(0), infant1.getNumCrawlers());
    assertEquals(new Integer(3), infant2.getNumCrawlers());
    assertEquals(new Integer(5), infant3.getNumCrawlers());
    assertEquals(new Integer(2), infant4.getNumCrawlers());
  }

  @Test
  public void getNumWalkers() {
    assertEquals(new Integer(0), infant0.getNumWalkers());
    assertEquals(new Integer(1), infant1.getNumWalkers());
    assertEquals(new Integer(3), infant2.getNumWalkers());
    assertEquals(new Integer(5), infant3.getNumWalkers());
    assertEquals(new Integer(3), infant4.getNumWalkers());
  }

  @Test
  public void requestVacation() throws Exception {
    InfantTeacher coworker0 = new InfantTeacher(coTeacher1, "", teacher1, 1, 0, 1, false);
    InfantTeacher coworker1 = new InfantTeacher(coTeacher3, "Kiddos", teacher3, 5, 5, 5, true);
    SubstituteTeacher coworker2 = new SubstituteTeacher(coTeacher1, "", teacher1, 1, false);
    SubstituteTeacher coworker3 = new SubstituteTeacher(coTeacher3, "Kiddos", teacher3, 33, true);

    assertTrue(infant1.requestVacation(coworker0));
    assertFalse(infant3.requestVacation(coworker1));
    assertTrue(infant1.requestVacation(coworker2));
    assertFalse(infant3.requestVacation(coworker3));
  }

  @Test(expected = IllegalVacationStatusException.class)
  public void testIllegalVacationStatus() throws Exception {
    InfantTeacher coworker = new InfantTeacher(coTeacher0, "Water", teacher0, 8, 8, 0, true);

    boolean illegal = infant0.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames1() throws Exception {
    InfantTeacher coworker = new InfantTeacher(coTeacher1, "", new Person("False", "False"), 1, 0,
        1, false);

    boolean illegal = infant1.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames2() throws Exception {
    InfantTeacher coworker = new InfantTeacher(new Person("a", "a"), "", teacher1, 1, 0, 1, false);

    boolean illegal = infant1.requestVacation(coworker);
  }

  @Test(expected = MismatchClassroomException.class)
  public void testMismatchClassroomException() throws Exception {
    InfantTeacher coworker = new InfantTeacher(coTeacher1, "fail", teacher1, 1, 0, 1, false);

    boolean illegal = infant1.requestVacation(coworker);
  }

  @Test
  public void testToString() {
    String expected0 = "Teacher- Tamara Bonaci\n\n"
        + "Classroom name- Water\n"
        + "Co-teacher- Emily Hi\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of children- 8\n"
        + "Maximum number of children- 8\n"
        + "Number of crawlers- 8\n"
        + "Number of walkers- 0\n\n"
        + "Type of teacher- infant\n";

    String expected1 = "Teacher- Will Super\n\n"
        + "Classroom name- \n"
        + "Co-teacher- Sarah Zoo\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 1\n"
        + "Maximum number of children- 8\n"
        + "Number of crawlers- 0\n"
        + "Number of walkers- 1\n\n"
        + "Type of teacher- infant\n";

    String expected2 = "Teacher- Kyle Boole\n\n"
        + "Classroom name- Kids\n"
        + "Co-teacher- Peter Hams\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 6\n"
        + "Maximum number of children- 8\n"
        + "Number of crawlers- 3\nNumber of walkers- 3\n\n"
        + "Type of teacher- infant\n";

    String expected3 = "Teacher- Todd Delonge\n\n"
        + "Classroom name- Kiddos\n"
        + "Co-teacher- Porter Fly\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 5\n"
        + "Maximum number of children- 8\n"
        + "Number of crawlers- 5\n"
        + "Number of walkers- 5\n\n"
        + "Type of teacher- infant\n";

    String expected4 = "Teacher- Sarah Knee\n\n"
        + "Classroom name- Munchkins\n"
        + "Co-teacher- Alex Lok\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of children- 3\n"
        + "Maximum number of children- 8\n"
        + "Number of crawlers- 2\n"
        + "Number of walkers- 3\n\n"
        + "Type of teacher- infant\n";

    assertEquals(expected0, infant0.toString());
    assertEquals(expected1, infant1.toString());
    assertEquals(expected2, infant2.toString());
    assertEquals(expected3, infant3.toString());
    assertEquals(expected4, infant4.toString());
  }

  @Test
  public void equals() {
    assertTrue(infant0.equals(infant0));
    assertFalse(infant0.equals(null));
    assertFalse(infant0.equals(new Integer(9)));
    assertFalse(infant0.equals(expInfant0));
    assertFalse(infant1.equals(expInfant1));
    assertFalse(infant2.equals(expInfant2));
    assertFalse(infant3.equals(expInfant3));
    assertFalse(infant4.equals(expInfant4));
    assertFalse(infant4.equals(expInfant5));
    assertFalse(infant4.equals(expInfant6));
    assertTrue(infant4.equals(expInfant7));
  }

  @Test
  public void testHashCode() {
    Integer illegal = new Integer(0);

    assertEquals(infant0.hashCode(), infant0.hashCode());
    assertNotEquals(expInfant0.hashCode(), infant0.hashCode());
    assertNotEquals(expInfant1.hashCode(), infant1.hashCode());
    assertNotEquals(expInfant2.hashCode(), infant2.hashCode());
    assertNotEquals(expInfant3.hashCode(), infant3.hashCode());
    assertNotEquals(expInfant4.hashCode(), infant4.hashCode());
    assertNotEquals(expInfant5.hashCode(), infant4.hashCode());
    assertNotEquals(expInfant6.hashCode(), infant4.hashCode());
    assertEquals(expInfant7.hashCode(), infant4.hashCode());
    assertNotEquals(infant0.hashCode(), illegal.hashCode());
  }
}