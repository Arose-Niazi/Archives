package April17;

public class Doctor {
     private String docName;
     private String docSpec;
     private double docFee;

    public Doctor(String docName, String docSpec, double docFee) {
        this.docName = docName;
        this.docSpec = docSpec;
        this.docFee = docFee;
    }

    @Override
    public String toString() {
        return docName;
    }

    public double getDocFee() {
        return docFee;
    }
}
