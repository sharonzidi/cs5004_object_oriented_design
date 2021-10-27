package shapes;

public class Hexagon extends AbstractShape{
  public Hexagon(Posn reference) {
    super(reference);
  }

  /**
   * Computes and returns the area of this shape.
   *
   * @return the area of the shape
   */
  @Override
  public double area() {
    return 0;
  }

  /**
   * Computes and returns the perimeter of this shape.
   *
   * @return the perimeter of the shape
   */
  @Override
  public double perimeter() {
    return 0;
  }

  /**
   * Create and return a shape of the same kind as this one, resized
   * in area by the provided factor
   *
   * @param factor factor of resizing
   * @return the resized Shape
   */
  @Override
  public Shape resize(double factor) {
    return null;
  }
}
