/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arose
 */

    public class Student {
    private int age;
    private int ID;
    private String firstname;
    private String lastname;
    private static int totalstudents;
    
    public Student(int age,String firstname,String lastname){
       
     this.age=age;  
     this.firstname=firstname;
     this.lastname=lastname;
     totalstudents++;
     ID=totalstudents;
    }
    static
    {
       totalstudents =0;
    }

    
    public String toString() {
        return "Person"+"\n\tFirst Name:"+firstname+"\n\tLast Name:"+lastname+"\n\tID:"+ID+"\n\tAge:"+age;
    }
    
    
}

