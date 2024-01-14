public class Main {
    public static void main(String[] args) {
        // Create and test StandardAccount
        StandardAccount standardAccount = new StandardAccount(12345, -200);
        standardAccount.Deposit(100);
        System.out.println("Standard Account Balance after deposit: " + standardAccount.GetCurrentBalance());
        double withdrawnStandard = standardAccount.Withdraw(250); // More than balance but within credit limit
        System.out.println("Amount withdrawn from Standard Account: " + withdrawnStandard);
        System.out.println("Standard Account Balance after withdrawal: " + standardAccount.GetCurrentBalance());

// Create and test BasicAccount
        BasicAccount basicAccount = new BasicAccount(54321);
        basicAccount.Deposit(100);
        System.out.println("\nBasic Account Balance after deposit: " + basicAccount.GetCurrentBalance());

// Attempt to withdraw 150 (will be limited to 100 in BasicAccount)
        System.out.println("Original attempt to withdraw from Basic Account: 150");
        double withdrawnBasic = basicAccount.Withdraw(150); // More than the withdrawal limit of 100
        System.out.println("Amount actually withdrawn from Basic Account: " + withdrawnBasic);
        System.out.println("Basic Account Balance after withdrawal: " + basicAccount.GetCurrentBalance());


// Create and test PremiumAccount
        PremiumAccount premiumAccount = new PremiumAccount(67890);
        premiumAccount.Deposit(300);
        System.out.println("\nPremium Account Balance after deposit: " + premiumAccount.GetCurrentBalance());

// Attempt to withdraw 350 (more than balance, but should be allowed in PremiumAccount)
        double withdrawnPremiumExceed = premiumAccount.Withdraw(350);
        System.out.println("Attempt to withdraw : " + withdrawnPremiumExceed);
        System.out.println("Premium Account Balance after withdrawal: " + premiumAccount.GetCurrentBalance());

// Further attempt to withdraw 250 (will result in further negative balance)
        double withdrawnPremium = premiumAccount.Withdraw(250);
        System.out.println("Amount withdrawn from Premium Account: " + withdrawnPremium);
        System.out.println("Premium Account Balance after additional withdrawal: " + premiumAccount.GetCurrentBalance());

        // Testing Bank operations with these accounts

        // Create a Bank instance
        Bank bank = new Bank();

        // Open accounts in the bank
        bank.OpenAccount(standardAccount);
        bank.OpenAccount(basicAccount);
        bank.OpenAccount(premiumAccount);
        System.out.println("\nTotal accounts after opening: " + bank.GetAllAccounts().size());

        // Close an account
        bank.CloseAccount(12345); // Example: Closing StandardAccount
        System.out.println("Total accounts after closing StandardAccount: " + bank.GetAllAccounts().size());

        // Get accounts in debt
        System.out.println("Accounts in debt: " + bank.GetAllAccountsInDebt().size());

        // Get accounts with a balance above a certain amount
        System.out.println("Accounts with balance above 100: " + bank.GetAllAccountsWithBalance(100).size());
    }
}







