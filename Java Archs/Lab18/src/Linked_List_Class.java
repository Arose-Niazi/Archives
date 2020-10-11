/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A J
 */
public class Linked_List_Class 
{
    String student_name;
    String student_password;
    Linked_List_Class next_location;
    
    public Linked_List_Class (String student_name , String student_password)
    {
        this.student_name     = student_name;
        this.student_password = student_password;
        this.next_location    = null;
    }
    
    public String getStudent_name() 
    {
        return student_name;
    }
    
    public String getStudent_password() 
    {
        return student_password;
    }

    public void setValue(String student_password) 
    {
        this.student_password = student_password;
    }

    public Linked_List_Class getNext() 
    {
        return next_location;
    }

    public void setNext(Linked_List_Class next_location ) 
    {
        this.next_location  = next_location ;
    }
}
