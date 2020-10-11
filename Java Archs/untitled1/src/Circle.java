public class Circle implements GeomatricObject {
    protected double radius;

    public Circle() {
        radius=1.0;
    }

    public Circle(double radius) {
        this.radius=radius;
    }

    @Override
    public double getPerimetere() {
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }


    @Override
    public String toString() {
        return "Circle\n\t" +
                "radius: " + radius;
    }
}
