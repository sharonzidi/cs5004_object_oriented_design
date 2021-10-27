package designPatterns.adapter;

import designPatterns.adapter.colours.Blue;
import designPatterns.adapter.colours.Green;
import designPatterns.adapter.colours.Red;
import designPatterns.adapter.concreteadapters.CircleAdapter;
import designPatterns.adapter.concreteadapters.RectangleAdapter;
import designPatterns.adapter.shapes.Circle;
import designPatterns.adapter.shapes.Posn;
import designPatterns.adapter.shapes.Rectangle;

/**
 * Created by therapon on 7/18/16.
 */
public class Main {

    public static void main(String[] args) {
        Adapter circle = new CircleAdapter(new Circle(new Posn(1,1), 10));
        Adapter rect = new RectangleAdapter(new Rectangle(new Posn(1,1), 10, 20));

        circle.draw(new Red());
        circle.draw(new Green());
        rect.draw(new Blue());
    }
}

