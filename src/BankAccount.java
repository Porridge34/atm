import java.math.BigDecimal;
import java.util.*;
import java.text.*;
public class BankAccount {
    private AccountOwner owner = null;
    private double money = 0;
    private long accountNum = 0;
    private static List<BankAccount> accounts = new ArrayList<BankAccount>();

    public BankAccount (AccountOwner accountOwner, double balance){
        owner = accountOwner;
        money = validateBalance(balance).doubleValue();
        accountNum = accounts.size();
        accounts.add(this);
    }

    public int deposit(double amount) {
        if (amount > 0) {
            money += amount;
            return 1;
        }
        return 2;
    }

    public int withdraw(double amount) {
        if (amount > 0 && this.money - amount >= 0) {
            money -= amount;
            return 1;
        }
        else if (this.money - amount < 0) {
            return 3;
        }
        return 2;
    }

    public int transfer(long account, double amount) {
        if (amount <= 0) {
            return 2;
        }
        else if (this.money - amount < 0) {
            return 3;
        }
        else if (account < 0 || account > accounts.size()) {
            return 4;
        }
        else {
            for (BankAccount a : accounts) {
                if (a.getAccountNumber() == account) {
                    a.deposit(amount);
                }
            }
            this.withdraw(amount);
            return 1;
        }
    }

    public String getMaskedAccountNumber() {
        String accountNumber = String.valueOf(this.accountNum);
        for (int i = 0; i < 8; i++) {
            if (accountNumber.length() < 8){
                accountNumber = "0" + accountNumber;
            }
        }
        for (int i = 0; i < 4; i++) {
            accountNumber = "****" + accountNumber.substring(4);
        }
        return accountNumber;
    }

    public String getFormattedBalance() {
        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(true);
        return df.format(money);
    }

    public BigDecimal validateBalance(double balance) {
        if (balance < 0) {
            return BigDecimal.ZERO;
        }
        else {
            return BigDecimal.valueOf(balance);
        }
    }

    public long getAccountNumber() {
        return this.accountNum;
    }

    public AccountOwner getAccountOwner() {
        return owner;
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.owner = accountOwner;
    }

    public java.math.BigDecimal getBalance () {
        return new BigDecimal(money);
    }
}
