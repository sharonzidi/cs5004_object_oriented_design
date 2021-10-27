package lambdas;

/**
 * Created by therapon on 7/11/16.
 */
public class MainStudents {
    private static String SEPARATOR = ",\n";

    public static void main(String[] args) {
        List<Integer> l1 = List.createEmpty();
        l1 = l1.add(99).add(88).add(79);

        List<Integer> l2 = List.createEmpty();
        l2 = l2.add(89).add(78).add(79);

        List<Integer> l3 = List.createEmpty();
        l3 = l3.add(90).add(88).add(65);

        List<Integer> l4 = List.createEmpty();
        l4 = l4.add(90).add(88).add(65);

        List<Integer> l5 = List.createEmpty();
        l5 = l5.add(90).add(88).add(65);

        Student s1 = new Student("john doe", "jd", l1);
        Student s2 = new Student("mary eliz", "me", l2);
        Student s3 = new Student("alex pratt", "ap", l3);
        Student s4 = new Student("krista allen", "ka", l4);
        Student s5 = new Student("andy howell", "ah", l5);


        List<Student> course101 = List.createEmpty();
        course101 = course101.add(s1).add(s2).add(s3).add(s4).add(s5);
        System.out.println(course101.join(SEPARATOR));

        Function<Student, Student> updateLogin = (Student s)  -> {
            return new Student(s.getName(), s.getLogin() + "@github", s.getGrades());
        };
        List<Student> updatedCourse = course101.applyToEach(updateLogin);

        System.out.println(updatedCourse.join(SEPARATOR));

        System.out.println(updatedCourse.applyToEach(
                (Student s) -> {
                    return new Student(s.getName(), s.getLogin() + ".com", s.getGrades());
                }).join(SEPARATOR));


        System.out.println(updatedCourse.foldOver((Student s, String acc) -> {
            return s.getLogin() + SEPARATOR + acc;
        }, ""));

    }
}