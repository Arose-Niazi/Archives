package Lab3;

public class Driver {
    public static void main(String args[])
    {
        Shape s[] = new Shape[4];
        s[0] = new Circle(0.0,0.0,1.0,2.0,15.0);
        s[1] = new Square(1.0,1.0,1.0,2.0,10.0);

        s[2] = new Sphere(0.0,0.0,1.0,2.0,3.0, 15.0);
        s[3] = new Cube(0.0,0.0,1.0,2.0,3.0, 10.0);

        for(Shape x: s)
        {
            System.out.println(x);
            if(x instanceof TwoDimensionalShape) {
                System.out.println("Area: " + ((TwoDimensionalShape) x).getArea());
            }
            else
            {
                System.out.println("Area: " + ((ThreeDimensionalShape) x).getArea());
                System.out.println("Volume: " + ((ThreeDimensionalShape) x).getArea());
            }
            System.out.println("\n");
        }
    }
}
