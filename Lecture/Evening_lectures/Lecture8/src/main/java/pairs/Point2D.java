package pairs;

public class Point2D extends Pair<Double, Double> {
    public Point2D(Double x, Double y) {
        super(x, y);
    }

    public Double getX() {
        return super.getFirst();
    }

    public Double getY() {
        return super.getSecond();
    }
}
