package April17;

import java.util.ArrayList;

public class Driver2 {

    public static void main(String args[])
    {
        ArrayList<Medicine> m = new ArrayList<Medicine>();
        m.add(new Medicine(1,"Panadol", 2,10));
        m.add(new Medicine(2,"Disprine", 1,20));
        ArrayList<MedicalTest> test = new ArrayList<MedicalTest>();
        test.add(new MedicalTest(1,"ECG",1000.0));
        test.add(new MedicalTest(2,"ECO", 1000.0));
        Billing a = new Billing(new Doctor("XYZ", "Brain", 500), new Patient(1,"Mufti","Dead Brain"), m,test);

        System.out.println(a);
    }
}
