package Lab3;

public abstract class Shape {
    private double X;
    private  double Y;

    public Shape(double x, double y) {
        X = x;
        Y = y;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }

    public abstract String getName();
}
