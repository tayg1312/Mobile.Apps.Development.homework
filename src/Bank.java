import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        Iterator<IAccount> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            IAccount account = iterator.next();
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) {
                    iterator.remove();
                } else {
                    System.out.println("Account not closed due to debt.");
                }
                return;
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                inDebtAccounts.add(account);
            }
        }
        return inDebtAccounts;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalanceAbove = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithBalanceAbove.add(account);
            }
        }
        return accountsWithBalanceAbove;
    }
}
