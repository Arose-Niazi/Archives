/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arose
 */
public class Person
{
 private static int totalpersons;
 private int age;
 private int ID;
 private String firstname;
 private String lastname;
 public Person(int age,String firstname,String lastname){
  this.age= age;
  this.firstname=firstname;
  this.lastname=lastname;
  totalpersons++;
  ID=totalpersons;
 }
 public void setAge(int age){
    this.age=age;
  
 }
 public int getAge(){
     return age;
 
 }
 
 static{
	totalpersons=0;  
 }
 public String toString(){
	 
return  "Studen\n"+"\tFirt Name:"+firstname+"\n\tLast Name:"+lastname+"\n\tID:"+ID+"\n\tAge:"+age;
	 
 }
 
 
}
