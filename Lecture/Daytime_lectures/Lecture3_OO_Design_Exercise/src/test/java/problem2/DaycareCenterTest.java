package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DaycareCenterTest {

  private InfantTeacher infant0;
  private InfantTeacher infant1;
  private InfantTeacher infant2;
  private InfantTeacher infant3;
  private InfantTeacher infant4;

  private ToddlerTeacher toddler0;
  private ToddlerTeacher toddler1;
  private ToddlerTeacher toddler2;
  private ToddlerTeacher toddler3;
  private ToddlerTeacher toddler4;

  private PreschoolTeacher preschool0;
  private PreschoolTeacher preschool1;
  private PreschoolTeacher preschool2;
  private PreschoolTeacher preschool3;
  private PreschoolTeacher preschool4;

  private SubstituteTeacher sub0;
  private SubstituteTeacher sub1;
  private SubstituteTeacher sub2;
  private SubstituteTeacher sub3;
  private SubstituteTeacher sub4;

  private DaycareCenter center0;

  @Before
  public void setUp() throws Exception {
    Person teacher0 = new Person("Cody", "Schraeder");
    Person teacher1 = new Person("Ryan", "Super");
    Person teacher2 = new Person("Kyle", "Steps");
    Person teacher3 = new Person("Todd", "Kim");
    Person teacher4 = new Person("Sarah", "Knee");

    Person coTeacher0 = new Person("Susanna", "Hi");
    Person coTeacher1 = new Person("Sarah", "Zoo");
    Person coTeacher2 = new Person("Tyler", "Bentley");
    Person coTeacher3 = new Person("Amanda", "Fly");
    Person coTeacher4 = new Person("Alex", "Lok");

    infant0 = new InfantTeacher(teacher0, "Fields", coTeacher0, 8, 8, 0, true);
    infant1 = new InfantTeacher(teacher1, "", coTeacher1, 1, 0, 1, false);
    infant2 = new InfantTeacher(teacher2, "Runners", coTeacher2, 6, 3, 3, true);
    infant3 = new InfantTeacher(teacher3, "Energizers", coTeacher3, 5, 5, 5, false);
    infant4 = new InfantTeacher(teacher4, "Munchkins", coTeacher4, 3, 2, 3, true);

    toddler0 = new ToddlerTeacher(teacher0, "Fields", coTeacher0, 14, 3, 11, true);
    toddler1 = new ToddlerTeacher(teacher1, "", coTeacher1, 1, 0, 1, false);
    toddler2 = new ToddlerTeacher(teacher2, "Runners", coTeacher2, 6, 3, 3, true);
    toddler3 = new ToddlerTeacher(teacher3, "Energizers", coTeacher3, 12, 5, 7, false);
    toddler4 = new ToddlerTeacher(teacher4, "Munchkins", coTeacher4, 3, 2, 1, true);

    preschool0 = new PreschoolTeacher(teacher0, "Fields", coTeacher0, 20, 8, true);
    preschool1 = new PreschoolTeacher(teacher1, "", coTeacher1, 1, 0, false);
    preschool2 = new PreschoolTeacher(teacher2, "Runners", coTeacher2, 10, 10, true);
    preschool3 = new PreschoolTeacher(teacher3, "Energizers", coTeacher3, 15, 5, false);
    preschool4 = new PreschoolTeacher(teacher4, "Munchkins", coTeacher4, 7, 6, true);

    sub0 = new SubstituteTeacher(coTeacher0, "Fields", teacher0, 0, true);
    sub1 = new SubstituteTeacher(coTeacher1, "", teacher1, 1, true);
    sub2 = new SubstituteTeacher(coTeacher2, "Runners", teacher2, 60, true);
    sub3 = new SubstituteTeacher(coTeacher3, "Energizers", teacher3, 33, false);
    sub4 = new SubstituteTeacher(coTeacher4, "Munchkins", teacher4, 20, false);

    center0 = new DaycareCenter();
  }

  @Test
  public void convertSubstituteTeacher() throws Exception {

    Person expTeacher0 = new Person("Susanna", "Hi");
    Person expTeacher1 = new Person("Sarah", "Zoo");
    Person expTeacher2 = new Person("Tyler", "Bentley");
    Person expTeacher3 = new Person("Amanda", "Fly");
    Person expTeacher4 = new Person("Alex", "Lok");

    Person expCoTeacher0 = new Person("Cody", "Schraeder");
    Person expCoTeacher1 = new Person("Ryan", "Super");
    Person expCoTeacher2 = new Person("Kyle", "Steps");
    Person expCoTeacher3 = new Person("Todd", "Kim");
    Person expCoTeacher4 = new Person("Sarah", "Knee");

    InfantTeacher expInfant0 = new InfantTeacher(expTeacher0, "Fields", expCoTeacher0, 8, 8, 0,
        true);
    InfantTeacher expInfant1 = new InfantTeacher(expTeacher1, "", expCoTeacher1, 1, 0, 1, true);
    InfantTeacher expInfant2 = new InfantTeacher(expTeacher2, "Runners", expCoTeacher2, 6, 3, 3,
        true);
    InfantTeacher expInfant3 = new InfantTeacher(expTeacher3, "Energizers", expCoTeacher3, 5, 5, 5,
        false);
    InfantTeacher expInfant4 = new InfantTeacher(expTeacher4, "Munchkins", expCoTeacher4, 3, 2, 3,
        false);

    ToddlerTeacher expToddler0 = new ToddlerTeacher(expTeacher0, "Fields", expCoTeacher0, 14, 3, 11,
        true);
    ToddlerTeacher expToddler1 = new ToddlerTeacher(expTeacher1, "", expCoTeacher1, 1, 0, 1, true);
    ToddlerTeacher expToddler2 = new ToddlerTeacher(expTeacher2, "Runners", expCoTeacher2, 6, 3, 3,
        true);
    ToddlerTeacher expToddler3 = new ToddlerTeacher(expTeacher3, "Energizers", expCoTeacher3, 12, 5,
        7,
        false);
    ToddlerTeacher expToddler4 = new ToddlerTeacher(expTeacher4, "Munchkins", expCoTeacher4, 3, 2,
        1, false);

    PreschoolTeacher expPreschool0 = new PreschoolTeacher(expTeacher0, "Fields", expCoTeacher0, 20,
        8,
        true);
    PreschoolTeacher expPreschool1 = new PreschoolTeacher(expTeacher1, "", expCoTeacher1, 1, 0,
        true);
    PreschoolTeacher expPreschool2 = new PreschoolTeacher(expTeacher2, "Runners", expCoTeacher2, 10,
        10, true);
    PreschoolTeacher expPreschool3 = new PreschoolTeacher(expTeacher3, "Energizers", expCoTeacher3,
        15,
        5, false);
    PreschoolTeacher expPreschool4 = new PreschoolTeacher(expTeacher4, "Munchkins", expCoTeacher4,
        7, 6, false);

    assertEquals(expInfant0, center0.convertSubstituteTeacher(sub0, "Infant", infant0));
    assertEquals(expInfant1, center0.convertSubstituteTeacher(sub1, "Infant", infant1));
    assertEquals(expInfant2, center0.convertSubstituteTeacher(sub2, "Infant", infant2));
    assertEquals(expInfant3, center0.convertSubstituteTeacher(sub3, "Infant", infant3));
    assertEquals(expInfant4, center0.convertSubstituteTeacher(sub4, "Infant", infant4));

    assertEquals(expToddler0, center0.convertSubstituteTeacher(sub0, "Toddler", toddler0));
    assertEquals(expToddler1, center0.convertSubstituteTeacher(sub1, "Toddler", toddler1));
    assertEquals(expToddler2, center0.convertSubstituteTeacher(sub2, "Toddler", toddler2));
    assertEquals(expToddler3, center0.convertSubstituteTeacher(sub3, "Toddler", toddler3));
    assertEquals(expToddler4, center0.convertSubstituteTeacher(sub4, "Toddler", toddler4));

    assertEquals(expPreschool0,
        center0.convertSubstituteTeacher(sub0, "Preschool", preschool0));
    assertEquals(expPreschool1,
        center0.convertSubstituteTeacher(sub1, "Preschool", preschool1));
    assertEquals(expPreschool2,
        center0.convertSubstituteTeacher(sub2, "Preschool", preschool2));
    assertEquals(expPreschool3,
        center0.convertSubstituteTeacher(sub3, "Preschool", preschool3));
    assertEquals(expPreschool4,
        center0.convertSubstituteTeacher(sub4, "Preschool", preschool4));
  }


  @Test(expected = MismatchTeacherLabelException.class)
  public void mismatchLabelException1() throws Exception {
    FullTimeDaycareTeacher illegal = center0.convertSubstituteTeacher(sub0, "Toddler", infant0);
  }

  @Test(expected = MismatchTeacherLabelException.class)
  public void mismatchLabelException2() throws Exception {
    FullTimeDaycareTeacher illegal = center0.convertSubstituteTeacher(sub0, "None", infant0);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void mismatchTeacherNamesException1() throws Exception {
    SubstituteTeacher illegalSub = new SubstituteTeacher(new Person("Susanna", "Hi"), "Fields",
        new Person("a", "a"), 0, true);
    FullTimeDaycareTeacher illegal = center0
        .convertSubstituteTeacher(illegalSub, "Infant", infant0);
  }

  @Test(expected = MismatchTeacherNamesException.class)
  public void mismatchTeacherNamesException2() throws Exception {
    SubstituteTeacher illegalSub = new SubstituteTeacher(new Person("False", "False"), "Fields",
        new Person("Cody", "Schraeder"), 0, true);
    FullTimeDaycareTeacher illegal = center0
        .convertSubstituteTeacher(illegalSub, "Infant", infant0);
  }

  @Test(expected = MismatchClassroomException.class)
  public void mismatchClassroomException() throws Exception {
    SubstituteTeacher illegalSub = new SubstituteTeacher(new Person("Susanna", "Hi"), "Clouds",
        new Person("Cody", "Schraeder"), 0, true);
    FullTimeDaycareTeacher illegal = center0
        .convertSubstituteTeacher(illegalSub, "Infant", infant0);
  }

  @Test
  public void testToString() {
    assertEquals("This is a daycare center.", center0.toString());
  }

  @Test
  public void equals() {
    assertTrue(center0.equals(new DaycareCenter()));
    assertFalse(center0.equals(null));
    assertFalse(center0.equals(new Integer(2)));
  }

  @Test
  public void testHashCode() {
    Integer test0 = new Integer(8);
    Double test1 = new Double(8.2);

    assertEquals(center0.hashCode(), center0.hashCode());
    assertNotEquals(center0.hashCode(), test0.hashCode());
    assertNotEquals(center0.hashCode(), test1.hashCode());
  }
}