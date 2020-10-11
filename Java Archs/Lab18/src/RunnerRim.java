/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A J
 */
public class RunnerRim {
    
    public static void main(String[] args) 
    {
        Hashing_Linked_List  list = new Hashing_Linked_List();
        
        list.put("Ali","hello");
        list.put("Sana","bye");
        list.put("Umer","Hi");
        list.put("Qasim","hello");
        list.put("Fahad","walk");
        list.put("Saba","Die");
        
        System.out.println(list.find("Hi") + "\tPass: Hi");
        System.out.println(list.find("bye") + "\tPass: bye");

        System.out.println("Students having password hello");
        list.findAdvance("hello");
    }
    
    
}
