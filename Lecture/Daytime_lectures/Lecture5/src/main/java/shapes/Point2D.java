package shapes;

import java.util.Objects;

/**
 * Represents an x, y coordinate.
 */
public class Point2D {
  public final double x;
  public final double y;

  /**
   * Constructor for the Point2D class
   * @param x The x coordinate.
   * @param y The y coordinate.
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets the x coordinate.
   * @return The x coordinate.
   */
  public double getX() {
    return this.x;
  }

  /**
   * Get the y coordinate.
   * @return The y coordinate.
   */
  public double getY() {
    return this.y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point2D point2D = (Point2D) o;
    return Double.compare(point2D.x, x) == 0 &&
            Double.compare(point2D.y, y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
