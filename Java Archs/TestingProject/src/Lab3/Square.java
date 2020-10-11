package Lab3;

public class Square extends TwoDimensionalShape {
    private double length;

    public Square(double x, double y, double d1, double d2, double length) {
        super(x, y, d1, d2);
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
        return length*length;
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public String toString() {
        return super.toString() +"\n\t\tSquare{" +
                "length=" + length +
                '}';
    }
}
