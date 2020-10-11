public class SavingsAccount extends BankAccount{
    public SavingsAccount(int accountID, int balance) {
        super(accountID, balance);
    }

    public void amountWithdraw(int amount)
    {
        if(balanceInquiry() - amount >= 10000) amountDeposit(-amount);
        else System.out.println("Error low balance, than the limit.");
    }
}
