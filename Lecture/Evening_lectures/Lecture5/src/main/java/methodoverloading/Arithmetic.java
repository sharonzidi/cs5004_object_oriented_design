package methodoverloading;

/**
 * This class contains static utility methods for performing calculations.
 */
public class Arithmetic {

    /**
     * Calculates the sum of two integers.
     * @param one The first integer.
     * @param two The second integer.
     * @return The sum of the integers.
     */
    public static int sum(int one, int two) {
        return one + two;
    }

    /**
     * Calculates the sum of three integers
     * @param one The first integer.
     * @param two The second integer.
     * @param three The third integer.
     * @return The sum of the integers.
     */
    public static int sum(int one, int two, int three) {
        return one + two + three;
    }

    /**
     * Calculates the sum of two doubles.
     * @param one The first double.
     * @param two The second double.
     * @return The sum of the doubles.
     */
    public static double sum(double one, double two) {
        return one + two;
    }

    /**
     * Calculates the sum of three doubles.
     * @param one The first double.
     * @param two The second double.
     * @param three The third double.
     * @return The sum of the doubles.
     */
    public static double sum(double one, double two, double three) {
        return one + two + three;
    }

    /**
     * Multiplies two integers.
     * @param one The first integer.
     * @param two The second integer.
     * @return The result of the multiplication.
     */
    public static int multiply(int one, int two) {
        return one * two;
    }

    /**
     * Multiplies three integers.
     * @param one The first integer.
     * @param two The second integer.
     * @param three The third integer.
     * @return The result of the multiplication.
     */
    public static int multiply(int one, int two, int three) {
        return one * two * three;
    }

    /**
     * Multiplies two doubles.
     * @param one The first double.
     * @param two The second double.
     * @return The result of the multiplication.
     */
    public static double multiply(double one, double two) {
        return one * two;
    }

    /**
     * Multiplies three doubles.
     * @param one The first double.
     * @param two The second double.
     * @param three The third double.
     * @return The result of the multiplication.
     */
    public static double multiply(double one, double two, double three) {
        return one * two * three;
    }

}
