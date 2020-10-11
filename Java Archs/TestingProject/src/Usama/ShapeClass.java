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
public abstract class ShapeClass {
    private double X;
    private double Y;
    private String Name;
    public ShapeClass (double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public void setX(double X) {
        this.X = X;
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
    public abstract String getname();

    @Override
    public String toString() {
        return "ShapeClass{" + "X=" + X + ", Y=" + Y + ", Name=" + Name + '}';
    }
    
}
