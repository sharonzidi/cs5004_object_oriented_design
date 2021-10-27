package designPatterns.factory.shapes;

/**
 * Represents a Circle in our shapes program.
 */
public class Circle extends AbstractShape {
    private Integer radius;

    public Circle(Posn pin, Integer radius) {
        super(pin);
        this.radius = radius;
    }

    /**
     * Getter for property 'radius'.
     *
     * @return Value for property 'radius'.
     */
    public Integer getRadius() {
        return this.radius;
    }

    @Override
    public Shape moveX(Integer dx) {
        return null;
    }

    @Override
    public Shape moveY(Integer dy) {
        return null;
    }

    @Override
    public Double area() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public Double circumference() {
        return 2 * this.radius * Math.PI;
    }
}
