package Lab3;

public abstract class TwoDimensionalShape extends Shape {
    private double d1;
    private double d2;

    public TwoDimensionalShape(double x, double y, double d1, double d2) {
        super(x, y);
        this.d1 = d1;
        this.d2 = d2;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return super.toString() +"\n\tTwoDimensionalShape{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                '}';
    }
}
