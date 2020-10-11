public class ResizeableCircle extends  Circle implements Resizeable {
    public ResizeableCircle(double radius) {
        super(radius);
    }

    public void resize(int percent)
    {
        radius += (radius * percent/100);
    }

    @Override
    public String toString() {
        return "Resizeable " + super.toString();
    }
}
