package designPatterns.factory.shapes;

/**
 * Represents a Shape in our shapes program.
 */
public interface Shape {

    /**
     * Move this shape by {@code dx} units in the x-direction.
     *
     * @param dx units to move in the x-direction
     * @return new shape with its x coordinate moved dx units
     */
    Shape moveX(Integer dx);

    /**
     * Move this shape by {@code dy} units in the y-direction.
     *
     * @param dy units to move in the y-direction
     * @return new shape with its y-coordinate moved dy units
     */
    Shape moveY(Integer dy);

    /**
     * Get the area of this shape.
     * @return  area of this shape
     */
    Double area();

    /**
     * Get the circumference of this shape.
     * @return  circumference of this shape
     */
    Double circumference();
}
