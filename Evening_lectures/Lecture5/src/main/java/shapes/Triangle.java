package shapes;

public class Triangle extends AbstractShape {
    public static final int RIGHT = 90;
    public static final int EQUILATERAL = 60;
    public static final int TOTAL = 180;
    private int sideA;
    private int sideB;
    private int sideC;
    private int angleA;
    private int angleB;
    private int angleC;

    /**
     * Constructor for the Triangle class.
     *
     * @param reference The 2D point that anchors the shape. Operations such as draw begin from the reference point.
     * @param sideA The length of side A.
     * @param sideB The length of side B.
     * @param sideC The length of side C.
     * @param angleA angle A.
     * @param angleB angle B.
     * @param angleC angle C.
     */
    public Triangle(Point2D reference, int sideA, int sideB, int sideC, int angleA, int angleB, int angleC) {
        super(reference);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
    }

    /**
     * Constructor for the Triangle class.
     *
     * @param sideA The length of side A.
     * @param sideB The length of side B.
     * @param sideC The length of side C.
     * @param angleA angle A.
     * @param angleB angle B.
     * @param angleC angle C.
     */
    public Triangle(int sideA, int sideB, int sideC, int angleA, int angleB, int angleC) {
        super();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
    }

    // What additional constructors can we have? Three values (angles, sides) are enough to calculate the missing
    // angles and/or sides. One of the provided values must be a side.

    /**
     * Helper method that determines if a triangle is valid (incomplete).
     * @param sideA The length of side A.
     * @param sideB The length of side B.
     * @param sideC The length of side C.
     * @param angleA angle A.
     * @param angleB angle B.
     * @param angleC angle C.
     * @throws InvalidTriangleException If the triangle does not meet the criteria for a valid triangle.
     */
    private void validateTriangle(int sideA, int sideB, int sideC, int angleA, int angleB, int angleC) throws InvalidTriangleException {
        if (angleA + angleB + angleC != TOTAL)
            throw new InvalidTriangleException();
        if (this.hasEquilateralAngles(angleA, angleB, angleC) != this.hasEquilateralSides(sideA, sideB, sideC))
            throw new InvalidTriangleException();
    }

    /**
     * Checks if the angles are all 60 degrees.
     * @param angleA angle A
     * @param angleB angle B
     * @param angleC angle C
     * @return true if the angles are all 60 degrees, false otherwise.
     */
    private boolean hasEquilateralAngles(int angleA, int angleB, int angleC) {
        return angleA == EQUILATERAL && angleB == EQUILATERAL && angleC == EQUILATERAL;
    }

    /**
     * Checks if the sides are all the same length.
     * @param sideA Side A.
     * @param sideB Side B.
     * @param sideC Side C.
     * @return true if the sides are all the same length.
     */
    private boolean hasEquilateralSides(double sideA, double sideB, double sideC) {
        return sideA == sideB && sideA == sideC;
    }

    /**
     * Calculates the area of the shape.
     *
     * @return The area of the shape.
     */
    @Override
    public double area() {
        double s = this.semiPerimeter();
        return Math.sqrt(s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC));
    }

    /**
     * Calculates the semi-perimeter of the triangle. Used as part of the area calculation.
     * @return The semi-perimeter of the triangle.
     */
    private double semiPerimeter() {
        return (this.sideA + this.sideB + this.sideC) / 2;
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
        this.sideA *= amt;
        this.sideB *= amt;
        this.sideC *= amt;
    }
}
