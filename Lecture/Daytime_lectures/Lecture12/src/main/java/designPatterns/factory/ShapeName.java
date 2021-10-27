package designPatterns.factory;

/**
 * Created by therapon on 7/18/16.
 */
class  ShapeName {

    private static ShapeName self = new ShapeName();
    private static ShapeName circleInstance;
    private static ShapeName squareInstance;
    private static ShapeName rectangleInstance;

    static ShapeName circleName(){
        if (ShapeName.circleInstance == null) {
            ShapeName.circleInstance = self.new CircleName();
        }
        return ShapeName.circleInstance;
    }

    static ShapeName squareName(){
        if (ShapeName.squareInstance== null) {
            ShapeName.squareInstance= self.new SquareName();
        }
        return ShapeName.squareInstance;
    }

    static ShapeName rectangleName(){
        if (ShapeName.rectangleInstance == null) {
            ShapeName.rectangleInstance = self.new RectangleName();
        }
        return ShapeName.rectangleName();
    }

    private ShapeName() {}


    private class CircleName extends ShapeName {
        private CircleName(){}
    }

    private class SquareName extends ShapeName {
        private SquareName(){}
    }

    private class RectangleName extends ShapeName {
        private RectangleName(){}
    }
}