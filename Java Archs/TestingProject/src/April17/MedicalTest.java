package April17;

public class MedicalTest {
    private int testID;
    private String testName;
    private double testFee;

    public MedicalTest(int testID, String testName, double testFee) {
        this.testID = testID;
        this.testName = testName;
        this.testFee = testFee;
    }

    @Override
    public String toString() {
        return String.format("%10s\t\t\t\t\t\t%8d\n",testName,(int) testFee);
    }

    public double getTestFee() {
        return testFee;
    }
}