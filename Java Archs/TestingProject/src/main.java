public class main {

    public  static void  main(String args[])
    {
        PermanentEmployee e1 = new PermanentEmployee("Hamza", 1, 500);
        HourlyEmployee e2 = new HourlyEmployee("Ali", 2, 500);
        e2.setTotalHours(150);

        System.out.println(e1);
        System.out.println(e2);
    }
}
