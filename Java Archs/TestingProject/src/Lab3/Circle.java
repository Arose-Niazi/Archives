package Lab3;

public class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double x, double y, double d1, double d2, double radius) {
        super(x, y, d1, d2);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return super.toString() +"\n\t\tCircle{" +
                "radius=" + radius +
                '}';
    }
}
