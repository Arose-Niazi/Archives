class FreshJuice {
   enum FreshJuiceSize{ SMALL, MEDIUM, LARGE }
   FreshJuiceSize size;
}

public class FreshJuiceTest {

   public static void main(String args[]) {
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.LARGE ;
      System.out.println("Size: " + juice.size
	  + "\nOther Size: " + FreshJuice.FreshJuiceSize.SMALL
	  );
	  //System.out.println("Other Size:" + FreshJuice.FreshJuiceSize.SMALL);
   }
}