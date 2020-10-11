public class BankDriver {

    public  static void  main(String args[])
    {
        CurrentAccount a1 = new CurrentAccount(1,5000);
        SavingsAccount a2 = new SavingsAccount(2, 10000);


        System.out.println(a1);
        System.out.println(a2);

        System.out.println("Trying to withdraw Rs. 1 from both accounts:");
        a1.amountWithdraw(1);
        a2.amountWithdraw(1);

        System.out.println("Trying to deposit Rs. 1 in both accounts:");
        a1.amountDeposit(1);
        a2.amountDeposit(1);

        System.out.println("After deposit:");
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("Trying to withdraw Rs. 1 from both accounts:");
        a1.amountWithdraw(1);
        a2.amountWithdraw(1);

        System.out.println("After Withdraw:");
        System.out.println(a1);
        System.out.println(a2);


    }
}
