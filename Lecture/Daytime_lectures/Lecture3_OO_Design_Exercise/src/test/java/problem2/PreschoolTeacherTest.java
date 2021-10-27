package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PreschoolTeacherTest {

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

  private PreschoolTeacher preschool0;
  private PreschoolTeacher preschool1;
  private PreschoolTeacher preschool2;
  private PreschoolTeacher preschool3;
  private PreschoolTeacher preschool4;

  private PreschoolTeacher expPreschool0;
  private PreschoolTeacher expPreschool1;
  private PreschoolTeacher expPreschool2;
  private PreschoolTeacher expPreschool3;
  private PreschoolTeacher expPreschool4;
  private PreschoolTeacher expPreschool5;
  private PreschoolTeacher expPreschool6;

  @Before
  public void setUp() throws Exception {
    teacher0 = new Person("Kaylee", "Bonaci");
    teacher1 = new Person("Will", "Chi");
    teacher2 = new Person("Kyle", "Steps");
    teacher3 = new Person("David", "Delonge");
    teacher4 = new Person("Susan", "Knee");

    coTeacher0 = new Person("Emily", "Hi");
    coTeacher1 = new Person("Susan", "Zoo");
    coTeacher2 = new Person("Tyler", "Hams");
    coTeacher3 = new Person("Porter", "Fly");
    coTeacher4 = new Person("Alex", "Bryan");

    preschool0 = new PreschoolTeacher(teacher0, "Earth", coTeacher0, 20, 8, true);
    preschool1 = new PreschoolTeacher(teacher1, "", coTeacher1, 1, 0, false);
    preschool2 = new PreschoolTeacher(teacher2, "Kids", coTeacher2, 10, 10, true);
    preschool3 = new PreschoolTeacher(teacher3, "Rainbows", coTeacher3, 15, 5, false);
    preschool4 = new PreschoolTeacher(teacher4, "Rockets", coTeacher4, 7, 6, false);

    Person expTeacher0 = new Person("Chiman", "Bonaci");
    Person expTeacher1 = new Person("Will", "Chi");
    Person expTeacher2 = new Person("Kyle", "Steps");
    Person expTeacher3 = new Person("David", "Delonge");
    Person expTeacher4 = new Person("Susan", "Knee");

    Person expCoTeacher0 = new Person("Emily", "Hi");
    Person expCoTeacher1 = new Person("Susan", "Zoo");
    Person expCoTeacher2 = new Person("Tyler", "Hambini");
    Person expCoTeacher3 = new Person("Porter", "Fly");
    Person expCoTeacher4 = new Person("Alex", "Bryan");

    expPreschool0 = new PreschoolTeacher(expTeacher0, "Earth", expCoTeacher0, 20, 8, true);
    expPreschool1 = new PreschoolTeacher(expTeacher1, "Test", expCoTeacher1, 1, 0, false);
    expPreschool2 = new PreschoolTeacher(expTeacher2, "Kids", expCoTeacher2, 10, 10, true);
    expPreschool3 = new PreschoolTeacher(expTeacher3, "Rainbows", expCoTeacher3, 11, 5, false);
    expPreschool4 = new PreschoolTeacher(expTeacher4, "Rockets", expCoTeacher4, 7, 2, false);
    expPreschool5 = new PreschoolTeacher(expTeacher4, "Rockets", expCoTeacher4, 7, 6, true);
    expPreschool6 = new PreschoolTeacher(expTeacher4, "Rockets", expCoTeacher4, 7, 6, false);
  }

  @Test(expected = IllegalNumberOfChildrenException.class)
  public void testIllegalNumberOfChildrenZero() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    PreschoolTeacher illegal = new PreschoolTeacher(p1, "class", p2, 0, 0, true);
  }

  @Test(expected = IllegalNumberOfChildrenException.class)
  public void testIllegalNumberOfChildrenAboveMax() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    PreschoolTeacher illegal = new PreschoolTeacher(p1, "class", p2, 21, 0, true);
  }

  @Test(expected = IllegalNumberOfLiterateChildrenException.class)
  public void testIllegalNumberOfLiterateChildrenNegative() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    PreschoolTeacher illegal = new PreschoolTeacher(p1, "class", p2, 10, -1, true);
  }

  @Test(expected = IllegalNumberOfLiterateChildrenException.class)
  public void testIllegalNumberOfLiteralChildrenTooMany() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    PreschoolTeacher illegal = new PreschoolTeacher(p1, "class", p2, 10, 11, true);
  }

  @Test
  public void getName() {
    assertEquals(new Person("Kaylee", "Bonaci"), preschool0.getName());
    assertEquals(new Person("Will", "Chi"), preschool1.getName());
    assertEquals(new Person("Kyle", "Steps"), preschool2.getName());
    assertEquals(new Person("David", "Delonge"), preschool3.getName());
    assertEquals(new Person("Susan", "Knee"), preschool4.getName());
  }

  @Test
  public void getClassroom() {
    assertEquals("Earth", preschool0.getClassroom());
    assertEquals("", preschool1.getClassroom());
    assertEquals("Kids", preschool2.getClassroom());
    assertEquals("Rainbows", preschool3.getClassroom());
    assertEquals("Rockets", preschool4.getClassroom());
  }

  @Test
  public void getCoTeacher() {
    assertEquals(new Person("Emily", "Hi"), preschool0.getCoTeacher());
    assertEquals(new Person("Susan", "Zoo"), preschool1.getCoTeacher());
    assertEquals(new Person("Tyler", "Hams"), preschool2.getCoTeacher());
    assertEquals(new Person("Porter", "Fly"), preschool3.getCoTeacher());
    assertEquals(new Person("Alex", "Bryan"), preschool4.getCoTeacher());
  }

  @Test
  public void isOnVacation() {
    assertTrue(preschool0.isOnVacation());
    assertFalse(preschool1.isOnVacation());
    assertTrue(preschool2.isOnVacation());
    assertFalse(preschool3.isOnVacation());
    assertFalse(preschool4.isOnVacation());
  }

  @Test
  public void getNumChildren() {
    assertEquals(new Integer(20), preschool0.getNumChildren());
    assertEquals(new Integer(1), preschool1.getNumChildren());
    assertEquals(new Integer(10), preschool2.getNumChildren());
    assertEquals(new Integer(15), preschool3.getNumChildren());
    assertEquals(new Integer(7), preschool4.getNumChildren());
  }

  @Test
  public void getMaxChildren() {
    assertEquals(new Integer(20), preschool0.getMaxChildren());
    assertEquals(new Integer(20), preschool1.getMaxChildren());
    assertEquals(new Integer(20), preschool2.getMaxChildren());
    assertEquals(new Integer(20), preschool3.getMaxChildren());
    assertEquals(new Integer(20), preschool4.getMaxChildren());
  }

  @Test
  public void getNumLiterate() {
    assertEquals(new Integer(8), preschool0.getNumLiterate());
    assertEquals(new Integer(0), preschool1.getNumLiterate());
    assertEquals(new Integer(10), preschool2.getNumLiterate());
    assertEquals(new Integer(5), preschool3.getNumLiterate());
    assertEquals(new Integer(6), preschool4.getNumLiterate());
  }

  @Test
  public void requestVacation() throws Exception {
    PreschoolTeacher coworker0 = new PreschoolTeacher(coTeacher1, "", teacher1, 1, 0, false);
    PreschoolTeacher coworker1 = new PreschoolTeacher(coTeacher3, "Rainbows", teacher3, 15, 5,
        true);
    SubstituteTeacher coworker2 = new SubstituteTeacher(coTeacher1, "", teacher1, 1, false);
    SubstituteTeacher coworker3 = new SubstituteTeacher(coTeacher3, "Rainbows", teacher3, 33, true);

    assertTrue(preschool1.requestVacation(coworker0));
    assertFalse(preschool3.requestVacation(coworker1));
    assertTrue(preschool1.requestVacation(coworker2));
    assertFalse(preschool3.requestVacation(coworker3));
  }

  @Test(expected = IllegalVacationStatusException.class)
  public void testIllegalVacationStatus() throws Exception {
    PreschoolTeacher coworker = new PreschoolTeacher(coTeacher0, "Earth", teacher0, 20, 8, true);

    boolean illegal = preschool0.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames1() throws Exception {
    PreschoolTeacher coworker = new PreschoolTeacher(coTeacher1, "", new Person("false", "false"),
        1, 0, false);

    boolean illegal = preschool1.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames2() throws Exception {
    PreschoolTeacher coworker = new PreschoolTeacher(new Person("false", "false"), "", teacher1, 1,
        0, false);

    boolean illegal = preschool1.requestVacation(coworker);
  }

  @Test(expected = MismatchClassroomException.class)
  public void testMismatchClassroomException() throws Exception {
    PreschoolTeacher coworker = new PreschoolTeacher(coTeacher1, "false", teacher1, 1, 0, false);

    boolean illegal = preschool1.requestVacation(coworker);
  }

  @Test
  public void testToString() {
    String expected0 = "Teacher- Kaylee Bonaci\n\n"
        + "Classroom name- Earth\n"
        + "Co-teacher- Emily Hi\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of children- 20\n"
        + "Maximum number of children- 20\n"
        + "Number of literate children- 8\n\n"
        + "Type of teacher- preschool\n";

    String expected1 = "Teacher- Will Chi\n\n"
        + "Classroom name- \n"
        + "Co-teacher- Susan Zoo\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 1\n"
        + "Maximum number of children- 20\n"
        + "Number of literate children- 0\n\n"
        + "Type of teacher- preschool\n";

    String expected2 = "Teacher- Kyle Steps\n\n"
        + "Classroom name- Kids\n"
        + "Co-teacher- Tyler Hams\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of children- 10\n"
        + "Maximum number of children- 20\n"
        + "Number of literate children- 10\n\n"
        + "Type of teacher- preschool\n";

    String expected3 = "Teacher- David Delonge\n\n"
        + "Classroom name- Rainbows\n"
        + "Co-teacher- Porter Fly\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 15\n"
        + "Maximum number of children- 20\n"
        + "Number of literate children- 5\n\n"
        + "Type of teacher- preschool\n";

    String expected4 = "Teacher- Susan Knee\n\n"
        + "Classroom name- Rockets\n"
        + "Co-teacher- Alex Bryan\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of children- 7\n"
        + "Maximum number of children- 20\n"
        + "Number of literate children- 6\n\n"
        + "Type of teacher- preschool\n";

    assertEquals(expected0, preschool0.toString());
    assertEquals(expected1, preschool1.toString());
    assertEquals(expected2, preschool2.toString());
    assertEquals(expected3, preschool3.toString());
    assertEquals(expected4, preschool4.toString());
  }

  @Test
  public void equals() {
    assertTrue(preschool0.equals(preschool0));
    assertFalse(preschool0.equals(null));
    assertFalse(preschool0.equals(new Integer(9)));
    assertFalse(preschool0.equals(expPreschool0));
    assertFalse(preschool1.equals(expPreschool1));
    assertFalse(preschool2.equals(expPreschool2));
    assertFalse(preschool3.equals(expPreschool3));
    assertFalse(preschool4.equals(expPreschool4));
    assertFalse(preschool4.equals(expPreschool5));
    assertTrue(preschool4.equals(expPreschool6));
  }

  @Test
  public void testHashCode() {
    assertEquals(preschool0.hashCode(), preschool0.hashCode());
    assertNotEquals(preschool0.hashCode(), expPreschool0.hashCode());
    assertNotEquals(preschool1.hashCode(), expPreschool1.hashCode());
    assertNotEquals(preschool2.hashCode(), expPreschool2.hashCode());
    assertNotEquals(preschool3.hashCode(), expPreschool3.hashCode());
    assertNotEquals(preschool4.hashCode(), expPreschool4.hashCode());
    assertNotEquals(preschool4.hashCode(), expPreschool5.hashCode());
    assertEquals(preschool4.hashCode(), expPreschool6.hashCode());
  }
}