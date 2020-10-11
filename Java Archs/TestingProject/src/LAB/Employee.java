package LAB;

public abstract class Employee {
    private String name;
    private int age;
    private String SSN;

    public Employee(String name, int age, String SSN) {
        this.name = name;
        this.age = age;
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return String.format("%s %s%nSocial Security Number: %s",name,age, SSN);
    }

    public abstract double earnings();
}
