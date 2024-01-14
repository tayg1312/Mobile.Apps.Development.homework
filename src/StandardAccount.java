public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit >= 0 ? 0 : creditLimit; // Ensure credit limit is negative or zero
        this.balance = 0; // Starting balance is zero
    }

    @Override
    public void Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= 0) {
            return 0;
        }
        double maxWithdrawal = balance - creditLimit; // Max amount that can be withdrawn
        if (amount > maxWithdrawal) {
            balance -= maxWithdrawal;
            return maxWithdrawal;
        } else {
            balance -= amount;
            return amount;
        }
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}

