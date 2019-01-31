
public class Area {
    double length,width,height,perimeter,result;

	public void Area() {
		
	}
    public double getlength() {
        return length;
    }

    public double getwidth() {
        return width;
    }
    public double getheight() {
        return height;
    }

    public void setlength(double length) {
        this.length = length;
    }

    public void setwidth(double width) {
        this.width = width;
    }

    public void setheight(double height) {
        this.height = height;
    }
    void PrintArea()
    {
        result=length*width;
        perimeter=4*result;
        System.out.println("Area of rectangle is "+result);
        System.out.println("perimeter of rectangle is "+perimeter);
    }
}

