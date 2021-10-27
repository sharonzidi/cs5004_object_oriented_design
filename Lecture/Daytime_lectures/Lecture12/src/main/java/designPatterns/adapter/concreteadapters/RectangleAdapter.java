package designPatterns.adapter.concreteadapters;

import designPatterns.adapter.Adapter;
import designPatterns.adapter.Colour;
import designPatterns.adapter.shapes.Shape;

/**
 * Created by therapon on 7/18/16.
 */
public class RectangleAdapter extends Adapter {

    public RectangleAdapter(Shape original) {
        super(original);
    }

    @Override
    public void draw(Colour colour) {

        System.out.println(original.circumference() + " in colour " + colour);
    }
}
