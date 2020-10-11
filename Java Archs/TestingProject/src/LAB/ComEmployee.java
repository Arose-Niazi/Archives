package LAB;

public class ComEmployee extends  Employee{
    private double commissionRate;
    private double grossSale;

    public ComEmployee(String name, int age, String SSN, double commissionRate, double grossSale) {
        super(name, age, SSN);
        this.commissionRate = commissionRate;
        this.grossSale = grossSale;
    }

    @Override
    public double earnings() {
        return grossSale * commissionRate;
    }

    @Override
    public String toString() {
        return "Commission Employee\n" + super.toString() + "\nGross Sale: " +
                grossSale +
                "\nCommission Rate: " + commissionRate;
    }
}
