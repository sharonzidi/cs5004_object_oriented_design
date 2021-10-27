package shapes;

/**
 * Represents a circle.
 */
public class Circle extends AbstractShape {
  private double radius;

  /**
   * Constructor for the Circle class.
   * @param reference The reference point.
   * @param radius The radius of the circle.
   */
  public Circle(Point2D reference, double radius) {
    super(reference);
    this.radius = radius;
  }

  /**
   * Constructor for the Circle class. Initializes a Circle at the default location, 0,0.
   * @param radius The radius.
   */
  public Circle(double radius) {
    super(); //Not technically needed
    this.radius = radius;
  }

  /**
   * Calculates the area of the circle.
   * @return The area of the circle.
   */
  @Override
  public double area() {
    return Math.PI * this.radius * this.radius;
  }

  /**
   * Draws the circle.
   */
  @Override
  public void draw() {

  }

  /**
   * Resizes the circle.
   * @param amt The amount to resize the shape by.
   */
  @Override
  public void resize(double amt) {
    this.radius *= amt;
  }
}
