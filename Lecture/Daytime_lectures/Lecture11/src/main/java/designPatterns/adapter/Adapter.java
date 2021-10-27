package designPatterns.adapter;

import designPatterns.adapter.shapes.Shape;

/**
 * Created by therapon on 7/18/16.
 */
public abstract class Adapter {

    protected Shape original;

    public Adapter(Shape original) {
        this.original = original;
    }

    public abstract void draw(Colour colour);

}