package LAB;

public class HourlyEmployee extends Employee {
    private double hours;
    private double wage;

    public HourlyEmployee(String name, int age, String SSN, double hours, double wage) {
        super(name, age, SSN);
        this.hours = hours;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Hourly Employee\n"+ super.toString() + "\nHourly wage: " + wage +
                "; hours worked : " + hours;
    }

    @Override
    public double earnings() {
        if(hours <= 40) return wage * hours;
        else return (40 * wage + (hours - 40 ) * wage * 1.5);
    }
}
