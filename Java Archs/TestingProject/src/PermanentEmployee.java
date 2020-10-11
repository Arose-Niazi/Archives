public class PermanentEmployee extends  Employee {
    private int hourlyIncome;

    public PermanentEmployee(String name, int empID, int hourlyIncome) {
        super(name, empID);
        this.hourlyIncome = hourlyIncome;
    }

    public int calculate_the_hourly_income(){
        return hourlyIncome*180;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThis month salary  @" + hourlyIncome + "PKR/Hour = " + calculate_the_hourly_income();
    }
}
