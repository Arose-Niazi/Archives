import java.util.Arrays;

public class Player {

    private static int last_id;
    private int ID;
    public String name;
    public Country country;
    public Status status;
    int matchfee[];

    public Player(String name, Country country) {
        this.name = name;
        this.country = country;
        ID=++last_id;
        matchfee = new int[0];
        status=Status.FIT;
    }

    public int getAverageFeePerMatch()
    {
        int avg=0;
        for(int x: matchfee) avg+=x;
        avg/=matchfee.length;
        return avg;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void addMatchFee(int fee) {
        int matchfee[] = new int[this.matchfee.length+1];
        int x=0;
        for(; x<this.matchfee.length; x++) matchfee[x]=this.matchfee[x];
        matchfee[x] = fee;
        this.matchfee=matchfee;
    }

    //Not Required.
    @Override
    public String toString() {
        return "Player{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", status=" + status +
                ", matchfee=" + Arrays.toString(matchfee) +
                ", Avg Fee=" + getAverageFeePerMatch() +
                '}';
    }

    public static void main(String args[])
    {
        Player one = new Player("Arose", new Country(1,"Mianwali"));
        Player two = new Player("Niazi", new Country(2,"Lahore"));
        //Not Required
        two.status=Status.UNFIT;
        one.addMatchFee(500);
        one.addMatchFee(1000);
        one.addMatchFee(1000);

        two.addMatchFee(500);
        System.out.println(one);
        System.out.println(two);
    }
}