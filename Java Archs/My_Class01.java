// interface
interface Message {
   String greet();
}

public class My_Class01 {
 
	public void displayMessage(Message m) 
	{
		System.out.println(m.greet() +
		", This is an example of anonymous inner class as an argument");  
	}	

	public static void main(String args[]) 
	{
		// Instantiating the class
		My_Class01 obj = new My_Class01();

		// Passing an anonymous inner class as an argument
		obj.displayMessage(
			new Message() 
			{
				public String greet() 
				{
					return "Hello";
				}
			}
		);
   }
}