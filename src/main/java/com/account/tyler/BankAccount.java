package com.account.tyler;

// code for the required features (account creation, deposit/withdraw, balance inquiry)

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String myAccount;
    private double balance;
    private List<String> transactionHistory;

    // constructor

    public BankAccount(String myAccount, double Deposit) {
        this.myAccount = myAccount;
        if (Deposit < 0) {
            throw new Error("Deposit must be greater than 0.");
        }
        this.balance = Deposit;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to deposit
    public void deposit(double money) {
        if (money <= 0) {
            throw new Error("You cannot deposit anything $0 or less.");
        }
        balance += money;
        transactionHistory.add("Deposit Successful: " + money);
    }

    // Method to withdraw
    public void withdraw(double money) {
        if (money <= 0) {
            throw new Error("Withdraw means take money out, can't be $0.");
        }
        if (money > balance) {
            throw new Error("Insufficient Funds.");
        }
        balance -= money;
        transactionHistory.add("Withdraw Successful: " + money);
    }

    // Balance Inquiry

    public double getBalance() {
        return balance;
    }

    // Transactions. Also need to validate transactions for tests.
    public List<String> showTransactions() {
        return transactionHistory;
    }
}
