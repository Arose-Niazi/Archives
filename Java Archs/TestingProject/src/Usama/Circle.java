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
public class Circle extends TwoDShape {
    private double radius;
    private double Area;
    private String Name;

    public Circle(double radius, double Area, String Name, double D1, double D2, double X, double Y) {
        super(D1, D2, X, Y);
        this.radius = radius;
        this.Area = Area;
        this.Name = Name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setArea(double Area) {
        this.Area = Area;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getRadius() {
        return radius;
    }
    @Override
    public double getArea() {
        return Area=3.14*radius;
    }
    @Override
    public String getname() {
        return Name;
    }

    @Override
    public String toString() {
        return "Circle{"+ super.toString()  + "radius=" + radius + ", Area=" + Area + ", Name=" + Name + '}';
    }
  
   
}
