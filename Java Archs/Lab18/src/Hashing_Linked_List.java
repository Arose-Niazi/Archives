/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A J
 */
public class Hashing_Linked_List 
{
   Linked_List_Class Hash_Table[] = new Linked_List_Class[3];
    
    public Hashing_Linked_List() 
    {
        for (int i = 0; i < Hash_Table.length ; i++)
        {
            Hash_Table[i] = null;
        }
    }

    public int Hash_Function(String student_pass)
    {
        int total = 0;
  
        char conversion_array[] = student_pass.toCharArray();
        
        for (int i = 0; i < conversion_array.length ; i++)
        {
            total += conversion_array[i];
        }
        
        return total;
    }
    
    public int Get_Index(String student_pass)
    {
        int modulus_result = Hash_Function(student_pass) % Hash_Table.length;
        
        return modulus_result;
    }
    
    public void put(String student_name, String student_password) 
    {
        Linked_List_Class Linked_List =new Linked_List_Class(student_name , student_password);
        
        int hash = Get_Index(student_password);

            if ( Hash_Table[hash] == null)
            {
                Hash_Table[hash] = Linked_List;
            }
            else 
            {
                Linked_List_Class entry = Hash_Table[hash];
                while (entry.getNext() != null)
                {
                      entry = entry.getNext();
                }
                entry.setNext(new Linked_List_Class(student_name , student_password));
            }
    }
    
    public String find(String student_pass)
    {
        int hash = Get_Index(student_pass);
        
        if(Hash_Table[hash].getStudent_password().equals(student_pass))
        {
            return Hash_Table[hash].getStudent_name();
        }
        
        else
        {
            Linked_List_Class entry = Hash_Table[hash];
            
            while(entry.student_password.equals(student_pass))
            {
                 entry = entry.getNext();
            }
            return entry.getStudent_name();
        }
    }

    public void findAdvance(String student_pass)
    {
        int hash = Get_Index(student_pass);
        Linked_List_Class entry = Hash_Table[hash];
        while (true)
        {
            if(entry.getStudent_password().equals(student_pass))
            {
                System.out.println(entry.getStudent_name());
            }
            if(entry.getNext() == null) break;
            entry = entry.getNext();
        }
    }
}

