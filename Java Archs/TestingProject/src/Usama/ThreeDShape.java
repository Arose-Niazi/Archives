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
public abstract class ThreeDShape extends ShapeClass {
    private double d1;
    private double d2;
    private double d3;
    private double Area;
    private double Volume;
    public ThreeDShape(double d1, double d2, double d3, double X, double Y) {
        super(X, Y);
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }

    public void setD3(double d3) {
        this.d3 = d3;
    }

    public double getD1() {
        return d1;
    }

    public double getD2() {
        return d2;
    }

    public double getD3() {
        return d3;
    }
public abstract double getArea();
public abstract double getVolume();

    @Override
    public String toString() {
        return "ThreeDShape{"+ super.toString() + "d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + ", Area=" + Area + ", Volume=" + Volume + '}';
    }
    
    
}
