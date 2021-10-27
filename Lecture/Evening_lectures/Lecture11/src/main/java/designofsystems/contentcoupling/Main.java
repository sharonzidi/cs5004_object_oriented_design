package designofsystems.contentcoupling;

public class Main {
    public static void main(String[] args) {
        Point2D center = new Point2D(0,0);
        AbstractShape circle = new Circle(center, 5);
        AbstractShape square = new Square(center, 5);

        circle.move(new Point2D(100, 100));

        System.out.println(circle.describeShape());
        System.out.println(square.describeShape());
    }
}
