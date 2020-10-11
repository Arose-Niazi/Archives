/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arose
 */
public class Student2 {
    private Marks marks[]; 
    private String rollno;
    private String name;
    private String Department;
    private String Degree;

    public Student2(String rollno, String name, String Department, String Degree,Marks marks[]) {
        this.marks = marks;
        this.rollno = rollno;
        this.name = name;
        this.Department = Department;
        this.Degree = Degree;
    }

    public Marks[] getMarks() {
        return marks;
    }

    public void setMarks(Marks marks[]) {
        this.marks = marks;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
    }
    
    
    
    

    @Override
    public String toString() {
        String s=  "rollno:" + rollno + "\nname:" + name + "\nDepartment:" + Department + "\nDegree:"+ Degree+"\nmarks\n";
        for(Marks x : marks)
        {
            s+=x;
        }
        return s;
        
    }
    
    
}
