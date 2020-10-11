public class Country {

    public int ID;
    public String name;
    public Country(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "country{" + "ID=" + ID + ", name=" + name + '}';
    }

}