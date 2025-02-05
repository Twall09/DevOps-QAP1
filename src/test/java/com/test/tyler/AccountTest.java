package com.test.tyler;

import com.account.tyler.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

// WRITE AT LEAST UNIT TESTS USING JUNIT 5:
// All three has passed when I ran them!!

public class AccountTest {

    @Test
    // validate transactions, so test deposit
    public void testDeposit() {
        BankAccount account = new BankAccount("TylerAcc", 100.00); // name of my account + the initial money that's in it

        // deposit $50
        account.deposit(50.0);
        List<String> transactions = account.showTransactions();

        Assertions.assertEquals(150.0, account.getBalance()); // if passed, 150.0 should be the updated balance
        Assertions.assertTrue(transactions.contains("Deposit Successful: 50.0"));
    }

    @Test
    // and now test withdraw
    public void testWithdraw() {
        BankAccount account = new BankAccount("TylerAcc", 100.00); // again, initially $100 in the account

        account.withdraw(30.0);
        List<String> transactions = account.showTransactions();

        Assertions.assertEquals(70.0, account.getBalance()); // if passed, updated balance is $70
        Assertions.assertTrue(transactions.contains("Withdraw Successful: 30.0"));
    }

    @Test
    // negative scenario where i tested the insufficient funds part from the code
    public void testInsufficientFunds() {
        BankAccount account = new BankAccount("TylerAcc", 100.00); // 100 in there

        // attempts to withdraw $200 which is more than the balance
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));

        Assertions.assertEquals("Insufficient Funds.", exception.getMessage());
    }
}
