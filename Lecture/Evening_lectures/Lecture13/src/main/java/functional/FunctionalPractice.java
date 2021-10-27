package functional;

import java.util.Arrays;
import java.util.List;

public class FunctionalPractice {
    public static void main(String[] args) {
        Book b1 = new Book("A Book", "An Author", 1990, 4.99f);
        Book b2 = new Book("Book 2", "An Author", 1991, 8.99f);
        Book b3 = new Book("Book 3", "An Author", 2019, 14.99f);

        List<Book> books = Arrays.asList(b1, b2, b3);

        /**
         * Complete each of the following exercises using only Streams and lambda expressions.
         * Check your work by printing the output. For tasks 1 & 2, use Streams to print.
         *
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html
         *
         */

        // Exercise 1

        // 1. Make a new List containing only books published before a certain date

        // 2. Make a new List containing only books in a particular price range

        // 3. Get the total price of all books in the list

        // 4. Get the average price of all books in the list



        /**
         * Exercise 2
         * Add two function objects to the FunctionalBook class:
         *  - Discount a book by 10% (same as prev slide)
         *  - Double the price of the book
         *
         * Add a static method to the FunctionalBook class:
         *    Book adjustPrice(Book book, Function<Book, Book> adjuster)
         * Could be used to either decrease or increase the price
         *
         * Try it out!
         **/

    }
}
