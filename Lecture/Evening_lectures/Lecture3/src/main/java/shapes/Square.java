package shapes;

public class Square extends Rectangle {
    /**
     * Constructor for the Rectangle class.
     *
     * @param reference The reference point.
     * @param width     The width of the Rectangle.
     */
    public Square(Point2D reference, double width) {
        super(reference, width, width);
    }
}
