/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arose
 */
public class Marks {
    private String subject;
    private double marks;

    public Marks(String subject, double marks) {
        this.subject = subject;
        this.marks = marks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "\tsubject: "+subject+"\n\tMarks: " + marks+ "\n";
    }
    
}

