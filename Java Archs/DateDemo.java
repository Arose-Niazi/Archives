import java.util.*;
import java.text.*;

public class DateDemo {

   public static void main(String args[]) {
      Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd G 'at' hh:mm:ss a zzz");

      System.out.println("Current Date: " + ft.format(dNow));
	  System.out.printf("Current Date/Time : %tc\n", dNow );
	   System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", dNow);
   }
}