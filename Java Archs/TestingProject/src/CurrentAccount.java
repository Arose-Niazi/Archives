public class CurrentAccount extends  BankAccount {

    public CurrentAccount(int accountID, int balance) {
        super(accountID, balance);
    }

    public void amountWithdraw(int amount)
    {
        if(balanceInquiry() - amount >= 5000) amountDeposit(-amount);
        else System.out.println("Error low balance, than the limit.");
    }
}
