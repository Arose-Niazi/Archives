package LAB;

import java.util.ArrayList;

public class EmployeeDriver {
    public static void main(String args[]) {
        Employee e[] = new Employee[4];

        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();

        e[0] = new BasePlusComE("Ali", 23, "6611111111-5", 50.0, 1500.0, 35000.0);
        e[1] = new ComEmployee("Ben", 58, "66111125861-5", 60.0, 500.0);
        e[2] = new HourlyEmployee("Hamza", 22, "651555811121-5", 25.0, 500.0);
        e[3] = new SalariedEmployee("Imran", 33, "28585293547-5", 50000.0);

        System.out.println("\nPrinting using Employee class:");
        for(Employee a: e)
        {
            System.out.print("\n\t");
            System.out.println(a);
        }


        Object o[] = new Object[4];
        o = e;

        System.out.println("\n\n\nPrinting using Object variable:");
        for(Object a: o)
        {
            System.out.print("\n\t");
            System.out.println(a);
        }
        BasePlusComE b;

        System.out.println("\n\n\nPrinting after 10% add in base commission:");
        for(Employee a: e)
        {
            System.out.print("\n\t");
            if(a instanceof BasePlusComE)
            {
                b = (BasePlusComE) a;
                b.setBaseSalary(b.getBaseSalary() + b.getBaseSalary()*0.1);
            }
            System.out.println(a + "\nEarnings: " + a.earnings());
        }

        for(Employee a: e)
        {
            employeeArrayList.add(a);
        }
        System.out.println("\n\n\nPrinting using arraylist:");
        for(Employee a: employeeArrayList)
        {
            System.out.print("\n\t");
            System.out.println(a);
        }

    }
}
