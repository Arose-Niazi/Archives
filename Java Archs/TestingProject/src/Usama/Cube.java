/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usama;


public class Cube extends ThreeDShape {
    private double width;
    private double length;
    private double height;
    private double Area;
    private double Volume;
    private String Name;

    public Cube(double width, double length, double height, double Area, double Volume, String Name, double d1, double d2, double d3, double X, double Y) {
        super(d1, d2, d3, X, Y);
        this.width = width;
        this.length = length;
        this.height = height;
        this.Area = Area;
        this.Volume = Volume;
        this.Name = Name;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
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

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }
    @Override
    public double getArea() {
       return Area= 6*length*length;      }
    
    @Override
    public double getVolume() {
        return Volume= length*width*height;
    }
    @Override
    public String getname() {
        return Name;
    }

    @Override
    public String toString() {
        return "Cube{"+ super.toString() + "width=" + width + ", length=" + length + ", height=" + height + ", Area=" + Area + ", Volume=" + Volume + ", Name=" + Name + '}';
    }
    
    
    
    
}
