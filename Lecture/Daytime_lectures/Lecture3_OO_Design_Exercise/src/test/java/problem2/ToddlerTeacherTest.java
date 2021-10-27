package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ToddlerTeacherTest {

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

  private ToddlerTeacher toddler0;
  private ToddlerTeacher toddler1;
  private ToddlerTeacher toddler2;
  private ToddlerTeacher toddler3;
  private ToddlerTeacher toddler4;

  private ToddlerTeacher expToddler0;
  private ToddlerTeacher expToddler1;
  private ToddlerTeacher expToddler2;
  private ToddlerTeacher expToddler3;
  private ToddlerTeacher expToddler4;
  private ToddlerTeacher expToddler5;
  private ToddlerTeacher expToddler6;
  private ToddlerTeacher expToddler7;

  @Before
  public void setUp() throws Exception {
    teacher0 = new Person("Tamara", "Runs");
    teacher1 = new Person("Will", "Super");
    teacher2 = new Person("Kyle", "Steps");
    teacher3 = new Person("Todd", "Dels");
    teacher4 = new Person("Sarah", "Knee");

    coTeacher0 = new Person("Emily", "Hi");
    coTeacher1 = new Person("Sarah", "Zeds");
    coTeacher2 = new Person("Tyler", "Hams");
    coTeacher3 = new Person("Porter", "Fly");
    coTeacher4 = new Person("Dan", "Lok");

    toddler0 = new ToddlerTeacher(teacher0, "Sky", coTeacher0, 14, 3, 11, true);
    toddler1 = new ToddlerTeacher(teacher1, "", coTeacher1, 1, 0, 1, false);
    toddler2 = new ToddlerTeacher(teacher2, "Toothy", coTeacher2, 6, 3, 3, true);
    toddler3 = new ToddlerTeacher(teacher3, "Kiddos", coTeacher3, 12, 5, 7, false);
    toddler4 = new ToddlerTeacher(teacher4, "Shorties", coTeacher4, 3, 2, 1, false);

    Person expTeacher0 = new Person("Superman", "Runs");
    Person expTeacher1 = new Person("Will", "Super");
    Person expTeacher2 = new Person("Kyle", "Steps");
    Person expTeacher3 = new Person("Todd", "Dels");
    Person expTeacher4 = new Person("Sarah", "Knee");

    Person expCoTeacher0 = new Person("Emily", "Hi");
    Person expCoTeacher1 = new Person("Sarah", "Zeds");
    Person expCoTeacher2 = new Person("Tyler", "Hambini");
    Person expCoTeacher3 = new Person("Porter", "Fly");
    Person expCoTeacher4 = new Person("Dan", "Lok");

    expToddler0 = new ToddlerTeacher(expTeacher0, "Sky", expCoTeacher0, 14, 3, 11, true);
    expToddler1 = new ToddlerTeacher(expTeacher1, "K", expCoTeacher1, 1, 0, 1, false);
    expToddler2 = new ToddlerTeacher(expTeacher2, "Toothy", expCoTeacher2, 6, 3, 3, true);
    expToddler3 = new ToddlerTeacher(expTeacher3, "Kiddos", expCoTeacher3, 11, 4, 7, false);
    expToddler4 = new ToddlerTeacher(expTeacher4, "Shorties", expCoTeacher4, 3, 1, 2, false);
    expToddler5 = new ToddlerTeacher(expTeacher4, "Shorties", expCoTeacher4, 3, 2, 0, false);
    expToddler6 = new ToddlerTeacher(expTeacher4, "Shorties", expCoTeacher4, 3, 2, 1, true);
    expToddler7 = new ToddlerTeacher(expTeacher4, "Shorties", expCoTeacher4, 3, 2, 1, false);
  }

  @Test(expected = IllegalNumberOfChildrenException.class)
  public void testIllegalNumberOfChildrenZero() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    ToddlerTeacher illegal = new ToddlerTeacher(p1, "class", p2, 0, 0, 0, true);
  }

  @Test(expected = IllegalNumberOfChildrenException.class)
  public void testIllegalNumberOfChildrenAboveMax() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    ToddlerTeacher illegal = new ToddlerTeacher(p1, "class", p2, 15, 1, 1, true);
  }

  @Test(expected = IllegalNumberOfDiapersException.class)
  public void testIllegalNumberOfDiapersNegative() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    ToddlerTeacher illegal = new ToddlerTeacher(p1, "class", p2, 6, -1, 1, true);
  }

  @Test(expected = IllegalNumberOfDiapersException.class)
  public void testIllegalNumberOfDiapersTooMany() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    ToddlerTeacher illegal = new ToddlerTeacher(p1, "class", p2, 6, 7, 1, true);
  }

  @Test(expected = IllegalNumberOfPottyTrainedException.class)
  public void testIllegalNumberOfPottyTrainedNegative() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    ToddlerTeacher illegal = new ToddlerTeacher(p1, "class", p2, 6, 1, -1, true);
  }

  @Test(expected = IllegalNumberOfPottyTrainedException.class)
  public void testIllegalNumberOfPottyTrainedTooMany() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    ToddlerTeacher illegal = new ToddlerTeacher(p1, "class", p2, 6, 1, 7, true);
  }

  @Test
  public void getName() {
    assertEquals(new Person("Tamara", "Runs"), toddler0.getName());
    assertEquals(new Person("Will", "Super"), toddler1.getName());
    assertEquals(new Person("Kyle", "Steps"), toddler2.getName());
    assertEquals(new Person("Todd", "Dels"), toddler3.getName());
    assertEquals(new Person("Sarah", "Knee"), toddler4.getName());
  }

  @Test
  public void getClassroom() {
    assertEquals("Sky", toddler0.getClassroom());
    assertEquals("", toddler1.getClassroom());
    assertEquals("Toothy", toddler2.getClassroom());
    assertEquals("Kiddos", toddler3.getClassroom());
    assertEquals("Shorties", toddler4.getClassroom());
  }

  @Test
  public void getCoTeacher() {
    assertEquals(new Person("Emily", "Hi"), toddler0.getCoTeacher());
    assertEquals(new Person("Sarah", "Zeds"), toddler1.getCoTeacher());
    assertEquals(new Person("Tyler", "Hams"), toddler2.getCoTeacher());
    assertEquals(new Person("Porter", "Fly"), toddler3.getCoTeacher());
    assertEquals(new Person("Dan", "Lok"), toddler4.getCoTeacher());
  }

  @Test
  public void isOnVacation() {
    assertTrue(toddler0.isOnVacation());
    assertFalse(toddler1.isOnVacation());
    assertTrue(toddler2.isOnVacation());
    assertFalse(toddler3.isOnVacation());
    assertFalse(toddler4.isOnVacation());
  }

  @Test
  public void getNumChildren() {
    assertEquals(new Integer(14), toddler0.getNumChildren());
    assertEquals(new Integer(1), toddler1.getNumChildren());
    assertEquals(new Integer(6), toddler2.getNumChildren());
    assertEquals(new Integer(12), toddler3.getNumChildren());
    assertEquals(new Integer(3), toddler4.getNumChildren());
  }

  @Test
  public void getMaxChildren() {
    assertEquals(new Integer(14), toddler0.getMaxChildren());
    assertEquals(new Integer(14), toddler1.getMaxChildren());
    assertEquals(new Integer(14), toddler2.getMaxChildren());
    assertEquals(new Integer(14), toddler3.getMaxChildren());
    assertEquals(new Integer(14), toddler4.getMaxChildren());
  }

  @Test
  public void getNumDiapers() {
    assertEquals(new Integer(3), toddler0.getNumDiapers());
    assertEquals(new Integer(0), toddler1.getNumDiapers());
    assertEquals(new Integer(3), toddler2.getNumDiapers());
    assertEquals(new Integer(5), toddler3.getNumDiapers());
    assertEquals(new Integer(2), toddler4.getNumDiapers());
  }

  @Test
  public void getNumPottyTrained() {
    assertEquals(new Integer(11), toddler0.getNumPottyTrained());
    assertEquals(new Integer(1), toddler1.getNumPottyTrained());
    assertEquals(new Integer(3), toddler2.getNumPottyTrained());
    assertEquals(new Integer(7), toddler3.getNumPottyTrained());
    assertEquals(new Integer(1), toddler4.getNumPottyTrained());
  }

  @Test
  public void requestVacation() throws Exception {
    ToddlerTeacher coworker0 = new ToddlerTeacher(coTeacher1, "", teacher1, 1, 0, 1, false);
    ToddlerTeacher coworker1 = new ToddlerTeacher(coTeacher3, "Kiddos", teacher3, 12, 5, 7, true);
    SubstituteTeacher coworker2 = new SubstituteTeacher(coTeacher1, "", teacher1, 1, false);
    SubstituteTeacher coworker3 = new SubstituteTeacher(coTeacher3, "Kiddos", teacher3, 33, true);

    assertTrue(toddler1.requestVacation(coworker0));
    assertFalse(toddler3.requestVacation(coworker1));
    assertTrue(toddler1.requestVacation(coworker2));
    assertFalse(toddler3.requestVacation(coworker3));
  }

  @Test(expected = IllegalVacationStatusException.class)
  public void testIllegalVacationStatus() throws Exception {
    ToddlerTeacher coworker = new ToddlerTeacher(coTeacher0, "Sky", teacher0, 14, 3, 11, true);

    boolean illegal = toddler0.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames1() throws Exception {
    ToddlerTeacher coworker = new ToddlerTeacher(coTeacher1, "", new Person("False", "False"), 1, 0,
        1, false);

    boolean illegal = toddler1.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames2() throws Exception {
    ToddlerTeacher coworker = new ToddlerTeacher(new Person("a", "a"), "", teacher1, 1, 0, 1,
        false);

    boolean illegal = toddler1.requestVacation(coworker);
  }

  @Test(expected = MismatchClassroomException.class)
  public void testMismatchClassroomException() throws Exception {
    ToddlerTeacher coworker = new ToddlerTeacher(coTeacher1, "fail", teacher1, 1, 0, 1, false);

    boolean illegal = toddler1.requestVacation(coworker);
  }

  @Test
  public void testToString() {
    String expected0 = "Teacher- Tamara Runs\n\n"
        + "Classroom name- Sky\n"
        + "Co-teacher- Emily Hi\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of children- 14\n"
        + "Maximum number of children- 14\n"
        + "Number of children wearing diapers- 3\n"
        + "Number of potty-trained children- 11\n\n"
        + "Type of teacher- toddler\n";

    String expected1 = "Teacher- Will Super\n\n"
        + "Classroom name- \n"
        + "Co-teacher- Sarah Zeds\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 1\n"
        + "Maximum number of children- 14\n"
        + "Number of children wearing diapers- 0\n"
        + "Number of potty-trained children- 1\n\n"
        + "Type of teacher- toddler\n";

    String expected2 = "Teacher- Kyle Steps\n\n"
        + "Classroom name- Toothy\n"
        + "Co-teacher- Tyler Hams\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of children- 6\n"
        + "Maximum number of children- 14\n"
        + "Number of children wearing diapers- 3\n"
        + "Number of potty-trained children- 3\n\n"
        + "Type of teacher- toddler\n";

    String expected3 = "Teacher- Todd Dels\n\n"
        + "Classroom name- Kiddos\n"
        + "Co-teacher- Porter Fly\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 12\n"
        + "Maximum number of children- 14\n"
        + "Number of children wearing diapers- 5\n"
        + "Number of potty-trained children- 7\n\n"
        + "Type of teacher- toddler\n";

    String expected4 = "Teacher- Sarah Knee\n\n"
        + "Classroom name- Shorties\n"
        + "Co-teacher- Dan Lok\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 3\n"
        + "Maximum number of children- 14\n"
        + "Number of children wearing diapers- 2\n"
        + "Number of potty-trained children- 1\n\n"
        + "Type of teacher- toddler\n";

    assertEquals(expected0, toddler0.toString());
    assertEquals(expected1, toddler1.toString());
    assertEquals(expected2, toddler2.toString());
    assertEquals(expected3, toddler3.toString());
    assertEquals(expected4, toddler4.toString());
  }

  @Test
  public void equals() {
    assertTrue(toddler0.equals(toddler0));
    assertFalse(toddler0.equals(null));
    assertFalse(toddler0.equals(new Integer(9)));
    assertFalse(toddler0.equals(expToddler0));
    assertFalse(toddler1.equals(expToddler1));
    assertFalse(toddler2.equals(expToddler2));
    assertFalse(toddler3.equals(expToddler3));
    assertFalse(toddler4.equals(expToddler4));
    assertFalse(toddler4.equals(expToddler5));
    assertFalse(toddler4.equals(expToddler6));
    assertTrue(toddler4.equals(expToddler7));
  }

  @Test
  public void testHashCode() {
    assertEquals(toddler0.hashCode(), toddler0.hashCode());
    assertNotEquals(expToddler0.hashCode(), toddler0.hashCode());
    assertNotEquals(expToddler1.hashCode(), toddler1.hashCode());
    assertNotEquals(expToddler2.hashCode(), toddler2.hashCode());
    assertNotEquals(expToddler3.hashCode(), toddler3.hashCode());
    assertNotEquals(expToddler4.hashCode(), toddler4.hashCode());
    assertNotEquals(expToddler5.hashCode(), toddler4.hashCode());
    assertNotEquals(expToddler6.hashCode(), toddler4.hashCode());
    assertEquals(expToddler7.hashCode(), toddler4.hashCode());
  }
}