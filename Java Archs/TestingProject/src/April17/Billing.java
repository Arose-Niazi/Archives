package April17;

import java.util.ArrayList;

public class Billing implements Payable {
    private int billID;
    private Doctor docInfo;
    private Patient pInfo;
    private ArrayList<Medicine> MedInfo;
    private ArrayList<MedicalTest> Test;
    private static int totalBills;

    static {
        totalBills = 0;
    }

    public Billing(Doctor docInfo, Patient pInfo, ArrayList<Medicine> medInfo, ArrayList<MedicalTest> test) {
        this.docInfo = docInfo;
        this.pInfo = pInfo;
        MedInfo = medInfo;
        Test = test;
        billID = ++totalBills;
    }

    @Override
    public String toString() {
        String s =String.format("\tMedCare Services\nBill ID: %d\tDoctor Name: %s\n\t\t\tPatient Name: %s\n",billID,docInfo,pInfo);
        s += String.format("Medicines\tUnitCost\tQuantity\tTotal\n");
        double bill = 0;
        for(Medicine x : MedInfo) {
            s += x;
            bill+=x.getMedPricePerUnit() * x.getMedQty();
        }
        s += String.format("-------------------------------------------------\n");
        s += String.format("MedTotal\t\t\t\t\t\t\t%d\n",(int) bill);
        s += String.format("DocFee\t\t\t\t\t\t\t\t%d\n",(int) docInfo.getDocFee());
        s += String.format("TestName\t\t\t\t\t\t\tTest Fee\n");
        bill = 0;
        for(MedicalTest x : Test) {
            s += x;
            bill+=x.getTestFee();
        }
        s += String.format("-------------------------------------------------\n");
        s += String.format("Test Total\t\t\t\t\t\t\t%d\n",(int) bill);
        s += String.format("GTotal\t\t\t\t\t\t\t\t%d\n",(int) getPaymentAmount());
        return s;
    }

    public  double getPaymentAmount() {

        double bill = 0;
        for(Medicine x : MedInfo)
        {
            bill+=x.getMedPricePerUnit() * x.getMedQty();
        }
        for(MedicalTest x : Test) {
            bill+=x.getTestFee();
        }
        bill+=docInfo.getDocFee();
        return bill;
    }

}
