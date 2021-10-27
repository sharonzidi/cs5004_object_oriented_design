package designPatterns.factory;


import designPatterns.factory.shapes.Circle;
import designPatterns.factory.shapes.Posn;
import designPatterns.factory.shapes.Rectangle;
import designPatterns.factory.shapes.Shape;

/**
 * Created by therapon on 7/18/16.
 */
public class ShapeFactory {

    private static ShapeFactory instance;
    private final Posn posn;
    private final Integer radius;
    private final Integer side;
    private final Integer height;
    private final Integer width;

    public static ShapeFactory getInstance() {
        if (ShapeFactory.instance == null) {
            ShapeFactory.instance = new ShapeFactory();
        }
        return ShapeFactory.instance;
    }

    private ShapeFactory() {
        this.posn = new Posn(0, 0);
        this.radius = 10;
        this.side = 10;
        this.width = 20;
        this.height = 10;
    }

    public Shape getCircle(ShapeName name) {
        if (ShapeName.circleName().equals(name)) {
            return new Circle(posn, radius);
        } else if (ShapeName.squareName().equals(name)) {
            return new Rectangle(posn, side, side);
        } else if (ShapeName.rectangleName().equals(name)) {
            return new Rectangle(posn, width, height);
        } else {
            throw new IllegalArgumentException("Unknown product : " + name);
        }
    }
}

