package designPatterns.adapter.shapes;

/**
 * Represents the common properties of a shape
 */
public abstract class AbstractShape implements Shape {
    protected Posn pin;

    public AbstractShape(Posn pin) {
        this.pin = pin;
    }

    /**
     * Getter for property 'pin'.
     *
     * @return Value for property 'pin'.
     */
    public Posn getPin() {
        return this.pin;
    }
}
