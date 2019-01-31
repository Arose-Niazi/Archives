import java.io.*;
public class ReadConsole {

   public static void main(String args[]) throws IOException {
      InputStreamReader cin = null;
	  FileOutputStream out = null;

      try {
         cin = new InputStreamReader(System.in);
		 out = new FileOutputStream("output.txt");
         System.out.println("Enter characters, 'q' to quit.");
         char c;
         do {
            c = (char) cin.read();
            System.out.print(c);
			out.write((int) c);
         } while(c != 'q');
      }finally {
         if (cin != null) {
            cin.close();
         }
		 if (out != null) {
            out.close();
         }
      }
   }
}