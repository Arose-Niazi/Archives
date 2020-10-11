class Animal {
}

class Mammal extends Animal {
}

class Reptile extends Animal {
}

public class Dogsc extends Mammal {

   public static void main(String args[]) {
      Animal a = new Animal();
      Mammal m = new Mammal();
      Dogsc d = new Dogsc();

      System.out.println(m instanceof Animal);
      System.out.println(d instanceof Mammal);
      System.out.println(d instanceof Animal);
	  
   }
}