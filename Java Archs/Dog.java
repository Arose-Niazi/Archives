class Barking {
	String bark = "Woff Woff...";
}

public class Dog {
	String breed = "German";
	int age=2;
	String color="White";

	String hungry() {
	   return "Wooff...";
	}

	void sleeping() {
		System.out.println("Sleeping: zzZZZZZ...");
	}
	
	public Dog() {
		Barking dbark = new Barking();
		System.out.println("Breed: " + breed
		+ "\nAge: " + age
		+ "\nColor: " + color
		+ "\nHungry: " + hungry()
		+ "\nBarking: " + dbark.bark);
		sleeping();
	}
	
	public static void main(String args[])
	{
		new Dog();
	}
}