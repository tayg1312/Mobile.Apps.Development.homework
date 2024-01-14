public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private final double withdrawalLimit = 100; // Assuming a fixed withdrawal limit

    public BasicAccount(int accountNumber) {
        this.accountNumber = accountNumber;
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
        if (amount > withdrawalLimit) {
            amount = withdrawalLimit; // Restrict withdrawal to the limit
        }
        if (balance >= amount) {
            balance -= amount;
            return amount;
        }
        return 0; // If insufficient balance, no withdrawal is made
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

