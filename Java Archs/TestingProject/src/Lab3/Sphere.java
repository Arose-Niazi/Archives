package Lab3;

public class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(double x, double y, double d1, double d2, double d3, double radius) {
        super(x, y, d1, d2, d3);
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
        return Math.PI * 4 * radius * radius;
    }

    @Override
    public double getVolume() {
        return  (Math.PI * 4 * radius * radius *radius)/3;
    }

    @Override
    public String getName() {
        return "Sphere";
    }
}
