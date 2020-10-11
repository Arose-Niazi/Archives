/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arose
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code     
        Student s[]=new Student[2];
        s[0]=new Student(21,"qasim","ali");
        s[1]=new Student(22,"fawad","mufti");
        Person p[]=new Person[2];
        p[0]=new Person(19,"hammad","waqar");
        p[1]=new Person(20,"raheem","nomi");
        p[0].setAge(50);
        p[1].setAge(p[1].getAge()+5);
        for(Student e:s)
        {
            System.out.println(e);
            
        }
        for(Person y:p)
        {
            System.out.println(y);
            
        }
        
    }  
    
}
