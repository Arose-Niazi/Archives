package Lab3;

public class Cube extends ThreeDimensionalShape {
    private double length;

    public Cube(double x, double y, double d1, double d2, double d3, double length) {
        super(x, y, d1, d2, d3);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return 6*length*length;
    }

    @Override
    public double getVolume() {
        return length*length*length;
    }

    @Override
    public String getName() {
        return "Cube";
    }

    @Override
    public String toString() {
        return super.toString() +"\n\t\tCube{" +
                "length=" + length +
                '}';
    }
}
