import java.io.UnsupportedEncodingException;

public class BinaryString {
    public static void main(String[] args) throws UnsupportedEncodingException 
	{
		byte[] infoBin = null;
		
		infoBin = "YourName".getBytes("UTF-8"); //Replace YourName with your name without any spaces
        
		for (byte b : infoBin) 
		{
            System.out.print("0"+Integer.toBinaryString(b) + "  ");
        }
		
		System.out.println("\nPrinting ODD parity");
		
		for (byte b : infoBin) 
		{
            System.out.print(((checkParity((char) b))? "0":"1")
                   + Integer.toBinaryString(b) 
					+ "  ");
        }
				
    }
	
	public static boolean checkParity(char myChar) 
	{
	  int i;
	  int parity = 0;

	  while(myChar != 0){    //while myChar != 0
		parity += (myChar&1);   //add result of myChar AND 1 to parity
		myChar = (char)  (myChar>>1);     //shift bits left by 1
	  }
	  //printf("parity equals: %d\n", parity);
	  if(parity % 2 != 0){ // if odd parity
		return true;
	  }
	  else { //even parity
		return false;
	  }
	}
}