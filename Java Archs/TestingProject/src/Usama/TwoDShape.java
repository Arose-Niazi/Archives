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
public abstract class TwoDShape extends ShapeClass {
    
    private double D1;
    private double D2;
    private double Area;
    public TwoDShape(double D1, double D2, double X, double Y) {
        super(X, Y);
        this.D1 = D1;
        this.D2 = D2;
    }

    public void setD1(double D1) {
        this.D1 = D1;
    }

    public void setD2(double D2) {
        this.D2 = D2;
    }

    public double getD1() {
        return D1;
    }

    public double getD2() {
        return D2;
    }
    public abstract double getArea();

    @Override
    public String toString() {
        return "TwoDShape{"+ super.toString() + "D1=" + D1 + ", D2=" + D2 + ", Area=" + Area + '}';
    }
    
}
