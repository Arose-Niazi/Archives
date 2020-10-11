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
public class Square extends TwoDShape {
    private double length;
    private double width;
    private double Area;
    private String Name;

    public Square(double length, double width, double Area, String Name, double D1, double D2, double X, double Y) {
        super(D1, D2, X, Y);
        this.length = length;
        this.width = width;
        this.Area = Area;
        this.Name = Name;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setArea(double Area) {
        this.Area = Area;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
    @Override
    public double getArea() {
        return Area= length*width;
    }
    @Override
    public String getname() {
        return Name;
    }

    @Override
    public String toString() {
        return "Square{"+ super.toString() + "length=" + length + ", width=" + width + ", Area=" + Area + ", Name=" + Name + '}';
    }
    }
