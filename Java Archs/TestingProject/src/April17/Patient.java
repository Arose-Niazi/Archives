package April17;

public class Patient {
    private int pID;
    private String pName;
    private String pType;

    public Patient(int pID, String pName, String pType) {
        this.pID = pID;
        this.pName = pName;
        this.pType = pType;
    }

    @Override
    public String toString() {
        return pName;
    }
}
