
public class Areacheck {

    public static void main(String[] args) {
		Area ar = new Area();
		Area ar2 = new Area();
		ar.setlength(5);
		ar.setwidth(10);
		ar.setheight(2);
        System.out.println("Length of rectangle is"+ar.getlength());
        System.out.println("width of rectangle is"+ar.getwidth());
        System.out.println("height of rectangle is"+ar.getheight());
		ar.PrintArea();
		
		ar2.setlength(10);
		ar2.setwidth(10);
		ar2.setheight(10);
        System.out.println("Length of rectangle is"+ar2.getlength());
        System.out.println("width of rectangle is"+ar2.getwidth());
        System.out.println("height of rectangle is"+ar2.getheight());
		ar2.PrintArea();
    }
}
