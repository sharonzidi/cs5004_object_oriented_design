package shapes;

/**
 * A square class that duplicates some of the functionality in the rectangle class.
 */
public class SquareWithDuplication extends AbstractShape {
    private double width;

    public SquareWithDuplication(Point2D reference, double width) {
        super(reference);
        this.width = width;
    }

    /**
     * Gets the width of the rectangle.
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Calculates the area of the shape.
     *
     * @return The area of the shape.
     */
    @Override
    public double area() {
        return this.width * this.width;
    }

    /**
     * "Draws" the shape.
     */
    @Override
    public void draw() {

    }

    /**
     * Resizes the shape by the given amount.
     *
     * @param amt The amount to resize the shape by.
     */
    @Override
    public void resize(double amt) {
        this.width *= amt;
    }
}
