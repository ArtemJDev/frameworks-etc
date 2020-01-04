package ru.testapp;

import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Must accept different denominations
 * Should give amount with a minimum number of bills or an error if impossible
 * Should give the balance amount
 */
public class ATMTest {

    private ATM atm;

    @Before
    public void setUp() {
        atm = new ATM();
    }

    @Test
    public void shouldDepositNotesOfDifferentDenominations() {
        atm.deposit(10, 100);
        atm.deposit(5, 500);
        int balance = atm.getBalance();
        Assert.assertEquals(3500, balance);
    }

    @Test
    public void shouldWithdrawAmountMinimumOfNotes() {
        atm.deposit(10, 100);
        atm.deposit(5, 500);
        Map<Integer, Integer> withdrawal  = atm.withDraw(700);
        Assert.assertEquals(5300, atm.getBalance());
        Assert.assertEquals(1, withdrawal.get(100).byteValue());
        Assert.assertEquals(2, withdrawal.get(200).byteValue());

    }

}
