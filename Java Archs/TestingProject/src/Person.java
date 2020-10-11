public class Person {
    private int age;
    private String name;
    private String NIC;

    public Person() {
    }

    public Person(int age, String name, String NIC) {
        this.age = age;
        this.name = name;
        this.NIC = NIC;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
}
