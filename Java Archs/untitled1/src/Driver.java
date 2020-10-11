import java.util.ArrayList;

public class Driver {
    public static void main(String args[])
    {
        ArrayList<GeomatricObject> a = new ArrayList<GeomatricObject>();

        a.add(new Circle(20.0));
        a.add(new Circle(30.0));
        a.add(new Circle(40.0));
        a.add(new ResizeableCircle(50.0));
        a.add(new ResizeableCircle(60.0));

        for(GeomatricObject x : a)
        {
            System.out.println(x + "\n\tArea: " + x.getArea() + "\n\tPerimeter: " + x.getPerimetere());
        }

        int c=0,rc=0;
        for(GeomatricObject x : a)
        {
            if(x instanceof Resizeable) rc++;
            else c++;
        }

        Circle circle[] = new Circle[c];
        ResizeableCircle resizeableCircle[] = new ResizeableCircle[rc];

        c=rc=0;
        for(GeomatricObject x : a)
        {
            if(x instanceof Resizeable) resizeableCircle[rc++] = (ResizeableCircle) x;
            else circle[c++] = (Circle) x;
        }

        System.out.println("\nAfter resizing by 350%:");
        for(ResizeableCircle x : resizeableCircle)
        {
            x.resize(350);
            System.out.println(x + "\n\tArea: " + x.getArea() + "\n\tPerimeter: " + x.getPerimetere());
        }
    }
}
