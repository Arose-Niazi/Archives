public class Employee {
    private String name;
    private int empID;

    @Override
    public String toString() {
        return  name  +
                "(ID: "+empID+")";
    }

    public Employee(String name, int empID) {
        this.name = name;
        this.empID = empID;
    }
}
