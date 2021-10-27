package designofsystems.contentcoupling;

import java.util.Objects;

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
   * Constructor for the AbstractShape class. Initializes a new shape at reference 0,0.
   */
  protected AbstractShape() {
    this.reference = new Point2D(0, 0);
  }


  public void move(Point2D point) {
    this.reference.setX(point.getX());
    this.reference.setY(point.getY());
  }

  /**
   * Describes the shape object.
   * @return A description of the shape.
   */
  public String describeShape() {
    return "This shape is located at " + this.reference.getX() + ", " + this.reference.getY() + " and has an area of " + String.format("%.2f", this.area());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return Objects.equals(reference, that.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference);
  }
}
