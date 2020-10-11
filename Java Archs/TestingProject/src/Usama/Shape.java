/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usama;

/**
 *
 * @author admin
 */
public class Shape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		ShapeClass s[]=new ShapeClass[4];
        s[0]= new Square(10.0, 15.0,150.0, "square", 0.0, 0.0, 10, 10);
        s[1]= new Circle(10.0, 356.0, "Circle", 0.0, 0.0, 0.0, 0.0);
        s[2]= new Sphere(56.0, 10.0, 169.0, 111.0, "Sphere", 0.0, 0.0, 0.0, 0.0, 0.0) ;
        s[3]= new Cube(11.0, 10.0, 13.0, 113.0, 666.0, "cube", 0.0, 0.0, 0.0, 0.0, 0.0);
    
		for(int x=0; x<s.length; x++)
		{
			System.out.println(s[x]);
			if(s[x] instanceof ThreeDShape)
			{
				ThreeDShape d = (ThreeDShape) s[x];
				System.out.println(d.getArea());
				System.out.println(d.getVolume());
			}
			else if(s[x] instanceof TwoDShape)
			{
				TwoDShape d = (TwoDShape) s[x];
				System.out.println(d.getArea());
			}	
		}
	
	}
}	