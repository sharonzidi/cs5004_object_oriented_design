package shapes;

public class Square extends Rectangle {
    /**
     * Constructor for the Square class.
     *
     * @param reference The reference point.
     * @param width     The width of the Square.
     */
    public Square(Point2D reference, double width) {
        super(reference, width, width);
    }

    /**
     * Constructor for the Square class. Initializes a square at the default location.
     * @param width The width of the Square.
     */
    public Square(double width) {
        super(width, width);
    }

}
