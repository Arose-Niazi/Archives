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
public class Sphere extends ThreeDShape {
    private double radius;
    private double height;
    private double Area;
    private double Volume;
    private String Name;

    public Sphere(double radius, double height, double Area, double Volume, String Name, double d1, double d2, double d3, double X, double Y) {
        super(d1, d2, d3, X, Y);
        this.radius = radius;
        this.height = height;
        this.Area = Area;
        this.Volume = Volume;
        this.Name = Name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setArea(double Area) {
        this.Area = Area;
    }

    public void setVolume(double Volume) {
        this.Volume = Volume;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
    @Override
    public double getArea() {
        return Area=4*3.14*radius*radius;
    }
    @Override
    public double getVolume() {
        return Volume=4/3*3.14*radius*radius*radius;
    }
    @Override
    public String getname() {
        return Name;
    }

    @Override
    public String toString() {
        return "Sphere{"+super.toString() + "radius=" + radius + ", height=" + height + ", Area=" + Area + ", Volume=" + Volume + ", Name=" + Name + '}';
    }
    
    
    
}
