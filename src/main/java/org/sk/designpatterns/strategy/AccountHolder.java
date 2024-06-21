package org.sk.designpatterns.strategy;

public class AccountHolder {

    private String name;
    private AccountType accountType;
    private double balance;

    public AccountHolder(String name, AccountType accountType, double balance) {
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "name='" + name + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }
}
