package shapes;

/**
 * Represents a Rectangle
 */
public class Rectangle extends AbstractShape {

  private double width;
  private double height;

  /**
   * Constructor for the Rectangle class.
   * @param reference The reference point.
   * @param width The width of the Rectangle.
   * @param height The height of the Rectangle.
   */
  public Rectangle(Point2D reference, double width, double height) {
    super(reference);
    this.width = width;
    this.height = height;
  }

  /**
   * Gets the width of the Rectangle.
   * @return The width of the Rectangle.
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Gets the height of the rectangle.
   * @return Sets the height of the rectangle.
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Calculates the area of the Rectangle.
   * @return The area of the rectangle.
   */
  @Override
  public double area() {
    return this.width * this.height;
  }

  /**
   * Draws the Rectangle.
   */
  @Override
  public void draw() {

  }

  /**
   * Resizes the Rectangle.
   * @param amt The amount to resize the shape by.
   */
  @Override
  public void resize(double amt) {
    this.width *= amt;
    this.height *= amt;
  }
}
