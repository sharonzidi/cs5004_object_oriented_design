package functional_programming.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by therapon on 7/11/16.
 */
public class MainStreams {

    public static <R> void main(String[] args) {
        List<Integer> lint = new ArrayList<>();
        lint.add(1);
        lint.add(2);
        lint.add(3);
        lint.add(4);
        lint.add(5);
        lint.add(6);

        lint.stream()
                .filter((Integer val) -> val % 2 == 0)
                .forEach(System.out::println);

        List<String> chars = new ArrayList<>();
        chars.add("a");
        chars.add("b");
        chars.add("c");
        chars.add("d");

        List<String> result = chars
                .stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(result);

        System.out.println(result.stream().
            collect(Collectors.joining("|")));


        List<Author> authors = new ArrayList<>();
        authors.add(new Author("a", "b", 80));
        authors.add(new Author("Neil", "Gaiman", 70));
        authors.add(new Author("Franz", "Kafka", 88));
        authors.add(new Author("Albert", "Einstein", 80));
        authors.add(new Author("Sylvia", "Plath", 50));
        authors.add(new Author("Alan", "Moore", 100));

        Comparator<Author> firstName = new Comparator<Author>() {

            @Override
            public int compare(Author o1, Author o2) {
                return o1.getFirst().compareTo(o2.getFirst());
            }
        };

        authors.sort(firstName);
        System.out.println("\n Sort by first\n" + authors);

        authors.sort((Author o1, Author o2) -> {
            return o1.getLast().compareTo(o2.getLast());
        });

        System.out.println("\n Sort by last\n" +  authors);

        authors.sort((Author o1, Author o2) -> {
            return o1.getAge().compareTo(o2.getAge());
        });

        System.out.println("\n Sort by age\n" +  authors);


        System.out.println("\n First names \n" + authors.stream().map(Author::getFirst).collect
                (Collectors.toList()));


        System.out.println("\n Last names \n" + authors.stream().map(Author::getLast).collect
                (Collectors.toList()));



        System.out.println("\n Ages \n" + authors.stream().map(Author::getAge).collect
                (Collectors.toList()));
    }
}
