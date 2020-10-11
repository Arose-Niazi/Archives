public class HourlyEmployee extends Employee {
    private int hourlyIncome;
    private int totalHours;

    public HourlyEmployee(String name, int empID, int hourlyIncome) {
        super(name, empID);
        this.hourlyIncome = hourlyIncome;
    }

    public int calculate_the_hourly_income(){
        return hourlyIncome*totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThis month salary = " + totalHours + " * "+ hourlyIncome + " = " + calculate_the_hourly_income();
    }
}
