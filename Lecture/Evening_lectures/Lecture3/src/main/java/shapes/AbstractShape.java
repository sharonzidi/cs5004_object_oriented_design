package shapes;

/**
 * An class containing shared fields and methods for Shape implementations.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;

  /**
   * Constructor for the AbstractShape class.
   * @param reference The 2D point that anchors the shape. Operations such as draw begin from the reference point.
   */
  protected AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  /**
   * Describes the shape object.
   * @return A description of the shape.
   */
  public String describeShape() {
    return "This shape is located at " + this.reference.x + ", " + this.reference.y + " and has an area of " + String.format("%.2f", this.area());
  }

}
