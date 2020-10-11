package LAB;

public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String name, int age, String SSN, double weeklySalary) {
        super(name, age, SSN);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public String toString() {
        return  "Salaried Employee\n" + super.toString() + "\nWeekly Salary: " + weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary * 4;
    }
}
