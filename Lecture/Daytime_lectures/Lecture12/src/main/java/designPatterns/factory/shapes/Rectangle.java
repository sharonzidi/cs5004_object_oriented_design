package designPatterns.factory.shapes;

/**
 * Represents a rectangle in our shapes program.
 */
public class Rectangle extends AbstractShape {

    private Integer width;
    private Integer height;

    public Rectangle(Posn pin, Integer width, Integer height) {
        super(pin);
        this.width = width;
        this.height = height;
    }

    /**
     * Getter for property 'width'.
     *
     * @return Value for property 'width'.
     */
    public Integer getWidth() {
        return this.width;
    }

    /**
     * Getter for property 'height'.
     *
     * @return Value for property 'height'.
     */
    public Integer getHeight() {
        return this.height;
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
        return new Double(width * height);
    }

    @Override
    public Double circumference() {
        return new Double((2 * width) + (2 * height));
    }
}
