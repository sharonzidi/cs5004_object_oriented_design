package designofsystems.contentcoupling;

/**
 * Specification for a Shape.
 */
public interface Shape {

  /**
   * Calculates the area of the shape.
   * @return The area of the shape.
   */
  double area();

  /**
   * "Draws" the shape.
   */
  void draw();

  /**
   * Resizes the shape by the given amount.
   * @param amt The amount to resize the shape by.
   */
  void resize(double amt);

  /**
   * Moves a shape to a new location.
   * @param point The new location.
   */
  void move(Point2D point);

}
