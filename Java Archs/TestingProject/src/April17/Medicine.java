package April17;

public class Medicine
{
    private int medID;
    private String medName;
    private int medQty;
    private double medPricePerUnit;

    public Medicine(int medID, String medName, int medQty, double medPricePerUnit) {
        this.medID = medID;
        this.medName = medName;
        this.medQty = medQty;
        this.medPricePerUnit = medPricePerUnit;
    }

    public int getMedQty() {
        return medQty;
    }

    public double getMedPricePerUnit() {
        return medPricePerUnit;
    }

    @Override
    public String toString() {
        return String.format("%10s\t%d\t\t\t%d\t\t\t%d\n", medName,(int)medPricePerUnit,medQty, (int) medPricePerUnit*medQty);
    }
}