public class NestedStaticClass {
   static class Nested_Demo {
      public void my_method() {
         System.out.println("This is my nested class");
      }
   }
   
   public static void main(String args[]) {
      NestedStaticClass.Nested_Demo nested = new NestedStaticClass.Nested_Demo();	 
      nested.my_method();
   }
}