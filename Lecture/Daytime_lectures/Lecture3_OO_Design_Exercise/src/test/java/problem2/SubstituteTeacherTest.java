package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubstituteTeacherTest {

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

  private SubstituteTeacher sub0;
  private SubstituteTeacher sub1;
  private SubstituteTeacher sub2;
  private SubstituteTeacher sub3;
  private SubstituteTeacher sub4;

  private SubstituteTeacher expSub0;
  private SubstituteTeacher expSub1;
  private SubstituteTeacher expSub2;
  private SubstituteTeacher expSub3;
  private SubstituteTeacher expSub4;
  private SubstituteTeacher expSub5;


  @Before
  public void setUp() throws Exception {
    teacher0 = new Person("Laura", "Tell");
    teacher1 = new Person("Brad", "Super");
    teacher2 = new Person("Kyle", "Steps");
    teacher3 = new Person("Sam", "Hoppus");
    teacher4 = new Person("Charlie", "Knee");

    coTeacher0 = new Person("Susan", "Hi");
    coTeacher1 = new Person("Charlie", "Zoo");
    coTeacher2 = new Person("Tyler", "Hams");
    coTeacher3 = new Person("Porter", "Hall");
    coTeacher4 = new Person("Alex", "Barty");

    sub0 = new SubstituteTeacher(teacher0, "Lightning", coTeacher0, 0, true);
    sub1 = new SubstituteTeacher(teacher1, "", coTeacher1, 1, false);
    sub2 = new SubstituteTeacher(teacher2, "Hornets", coTeacher2, 60, true);
    sub3 = new SubstituteTeacher(teacher3, "Cavaliers", coTeacher3, 33, false);
    sub4 = new SubstituteTeacher(teacher4, "Munchkins", coTeacher4, 20, true);

    Person expTeacher0 = new Person("Superman", "Tell");
    Person expTeacher1 = new Person("Brad", "Super");
    Person expTeacher2 = new Person("Kyle", "Steps");
    Person expTeacher3 = new Person("Sam", "Hoppus");
    Person expTeacher4 = new Person("Charlie", "Knee");

    Person expCoTeacher0 = new Person("Susan", "Hi");
    Person expCoTeacher1 = new Person("Charlie", "Zoo");
    Person expCoTeacher2 = new Person("Tyler", "Hambini");
    Person expCoTeacher3 = new Person("Porter", "Hall");
    Person expCoTeacher4 = new Person("Alex", "Barty");

    expSub0 = new SubstituteTeacher(expTeacher0, "Lightning", expCoTeacher0, 0, true);
    expSub1 = new SubstituteTeacher(expTeacher1, "A", expCoTeacher1, 1, false);
    expSub2 = new SubstituteTeacher(expTeacher2, "Hornets", expCoTeacher2, 60, true);
    expSub3 = new SubstituteTeacher(expTeacher3, "Cavaliers", expCoTeacher3, 22, false);
    expSub4 = new SubstituteTeacher(expTeacher4, "Munchkins", expCoTeacher4, 20, false);
    expSub5 = new SubstituteTeacher(expTeacher4, "Munchkins", expCoTeacher4, 20, true);
  }

  @Test(expected = IllegalNumberOfDaysInClassException.class)
  public void testIllegalNumberOfDaysInClass() throws Exception {
    Person p1 = new Person("a", "a");
    Person p2 = new Person("b", "b");

    SubstituteTeacher illegal = new SubstituteTeacher(p1, "class", p2, -1, true);
  }

  @Test
  public void getName() {
    assertEquals(new Person("Laura", "Tell"), sub0.getName());
    assertEquals(new Person("Brad", "Super"), sub1.getName());
    assertEquals(new Person("Kyle", "Steps"), sub2.getName());
    assertEquals(new Person("Sam", "Hoppus"), sub3.getName());
    assertEquals(new Person("Charlie", "Knee"), sub4.getName());
  }

  @Test
  public void getClassroom() {
    assertEquals("Lightning", sub0.getClassroom());
    assertEquals("", sub1.getClassroom());
    assertEquals("Hornets", sub2.getClassroom());
    assertEquals("Cavaliers", sub3.getClassroom());
    assertEquals("Munchkins", sub4.getClassroom());
  }

  @Test
  public void getCoTeacher() {
    assertEquals(new Person("Susan", "Hi"), sub0.getCoTeacher());
    assertEquals(new Person("Charlie", "Zoo"), sub1.getCoTeacher());
    assertEquals(new Person("Tyler", "Hams"), sub2.getCoTeacher());
    assertEquals(new Person("Porter", "Hall"), sub3.getCoTeacher());
    assertEquals(new Person("Alex", "Barty"), sub4.getCoTeacher());
  }

  @Test
  public void isOnVacation() {
    assertTrue(sub0.isOnVacation());
    assertFalse(sub1.isOnVacation());
    assertTrue(sub2.isOnVacation());
    assertFalse(sub3.isOnVacation());
    assertTrue(sub4.isOnVacation());
  }

  @Test
  public void getNumDaysInClassroom() {
    assertEquals(new Integer(0), sub0.getNumDaysInClassroom());
    assertEquals(new Integer(1), sub1.getNumDaysInClassroom());
    assertEquals(new Integer(60), sub2.getNumDaysInClassroom());
    assertEquals(new Integer(33), sub3.getNumDaysInClassroom());
    assertEquals(new Integer(20), sub4.getNumDaysInClassroom());
  }

  @Test
  public void requestVacation() throws Exception {
    InfantTeacher coworker0 = new InfantTeacher(coTeacher1, "", teacher1, 1, 0, 1, false);
    ToddlerTeacher coworker1 = new ToddlerTeacher(coTeacher3, "Cavaliers", teacher3, 12, 5, 7,
        true);
    PreschoolTeacher coworker2 = new PreschoolTeacher(coTeacher3, "Cavaliers", teacher3, 15, 5,
        true);
    SubstituteTeacher coworker3 = new SubstituteTeacher(coTeacher1, "", teacher1, 1, false);
    SubstituteTeacher coworker4 = new SubstituteTeacher(coTeacher3, "Cavaliers", teacher3, 33,
        true);

    assertTrue(sub1.requestVacation(coworker0));
    assertFalse(sub3.requestVacation(coworker1));
    assertFalse(sub3.requestVacation(coworker2));
    assertTrue(sub1.requestVacation(coworker3));
    assertFalse(sub3.requestVacation(coworker4));
  }

  @Test(expected = IllegalVacationStatusException.class)
  public void testIllegalVacationStatus() throws Exception {
    InfantTeacher coworker = new InfantTeacher(coTeacher0, "Lightning", teacher0, 8, 8, 0, true);

    boolean illegal = sub0.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames1() throws Exception {
    InfantTeacher coworker = new InfantTeacher(coTeacher1, "", new Person("False", "False"), 1, 0,
        1, false);

    boolean illegal = sub1.requestVacation(coworker);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void testMismatchTeacherNames2() throws Exception {
    InfantTeacher coworker = new InfantTeacher(new Person("a", "a"), "", teacher1, 1, 0, 1, false);

    boolean illegal = sub1.requestVacation(coworker);
  }

  @Test(expected = MismatchClassroomException.class)
  public void testMismatchClassroomException() throws Exception {
    InfantTeacher coworker = new InfantTeacher(coTeacher1, "fail", teacher1, 1, 0, 1, false);

    boolean illegal = sub1.requestVacation(coworker);
  }

  @Test
  public void testToString() {
    String expected0 = "Teacher- Laura Tell\n\n"
        + "Classroom name- Lightning\n"
        + "Co-teacher- Susan Hi\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of days in the classroom- 0\n\n"
        + "Type of teacher- substitute\n";

    String expected1 = "Teacher- Brad Super\n\n"
        + "Classroom name- \n"
        + "Co-teacher- Charlie Zoo\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of days in the classroom- 1\n\n"
        + "Type of teacher- substitute\n";

    String expected2 = "Teacher- Kyle Steps\n\n"
        + "Classroom name- Hornets\n"
        + "Co-teacher- Tyler Hams\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of days in the classroom- 60\n\n"
        + "Type of teacher- substitute\n";

    String expected3 = "Teacher- Sam Hoppus\n\n"
        + "Classroom name- Cavaliers\n"
        + "Co-teacher- Porter Hall\n\n"
        + "Teacher's vacation status- not on vacation\n\n"
        + "Number of days in the classroom- 33\n\n"
        + "Type of teacher- substitute\n";

    String expected4 = "Teacher- Charlie Knee\n\n"
        + "Classroom name- Munchkins\n"
        + "Co-teacher- Alex Barty\n\n"
        + "Teacher's vacation status- on vacation\n\n"
        + "Number of days in the classroom- 20\n\n"
        + "Type of teacher- substitute\n";

    assertEquals(expected0, sub0.toString());
    assertEquals(expected1, sub1.toString());
    assertEquals(expected2, sub2.toString());
    assertEquals(expected3, sub3.toString());
    assertEquals(expected4, sub4.toString());
  }

  @Test
  public void equals() {
    assertTrue(sub0.equals(sub0));
    assertFalse(sub0.equals(null));
    assertFalse(sub0.equals(new Integer(9)));
    assertFalse(sub0.equals(expSub0));
    assertFalse(sub1.equals(expSub1));
    assertFalse(sub2.equals(expSub2));
    assertFalse(sub3.equals(expSub3));
    assertFalse(sub4.equals(expSub4));
    assertTrue(sub4.equals(expSub5));
  }

  @Test
  public void testHashCode() {
    assertEquals(sub0.hashCode(), sub0.hashCode());
    assertNotEquals(expSub0.hashCode(), sub0.hashCode());
    assertNotEquals(expSub1.hashCode(), sub1.hashCode());
    assertNotEquals(expSub2.hashCode(), sub2.hashCode());
    assertNotEquals(expSub3.hashCode(), sub3.hashCode());
    assertNotEquals(expSub4.hashCode(), sub4.hashCode());
    assertEquals(expSub5.hashCode(), sub4.hashCode());
  }
}