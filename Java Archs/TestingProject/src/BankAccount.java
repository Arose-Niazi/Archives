public class BankAccount {
    private int accountID;
    private int balance;

    public BankAccount(int accountID, int balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public int balanceInquiry() {
        return balance;
    }

    public void amountDeposit(int amount) {
         balance+=amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID=" + accountID +
                ", balance=" + balance +
                '}';
    }
}
