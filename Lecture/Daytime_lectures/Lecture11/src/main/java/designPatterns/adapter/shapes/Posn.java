package designPatterns.adapter.shapes;

/**
 * Repersents a cartesian coordinate.
 *
 */
public class Posn {

    private Integer x;
    private Integer y;

    public Posn(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for property 'x'.
     *
     * @return Value for property 'x'.
     */
    public Integer getX() {
        return this.x;
    }

    /**
     * Getter for property 'y'.
     *
     * @return Value for property 'y'.
     */
    public Integer getY() {
        return this.y;
    }


}
