package LAB;

public class BasePlusComE extends ComEmployee {
    private double baseSalary;

    public BasePlusComE(String name, int age, String SSN, double commissionRate, double grossSale, double baseSalary) {
        super(name, age, SSN, commissionRate, grossSale);
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "base salaried "+ super.toString() + "\nBase Salary: " +
                baseSalary;
    }

    @Override
    public double earnings() {
        return baseSalary + super.earnings();
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
