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
        atm.deposit(10, 500);

        int balanceBefore = atm.getBalance();
        Map<Integer, Integer> withdrawal  = atm.withDraw(700);
        Assert.assertEquals(balanceBefore - 700, atm.getBalance());
        Assert.assertEquals(2, withdrawal.get(100).byteValue());
        Assert.assertEquals(1, withdrawal.get(500).byteValue());
    }

    //returns small bills if there are no large
    @Test
    public void shouldNotDispenseMoreThanThereIsNotes() {
        atm.deposit(1, 1000);
        atm.deposit(10, 500);

        int balanceBefore = atm.getBalance();
        Map<Integer, Integer> withdrawal  = atm.withDraw(2500);
        Assert.assertEquals(balanceBefore - 2500, atm.getBalance());
        Assert.assertEquals(3, withdrawal.get(500).byteValue());
        Assert.assertEquals(1, withdrawal.get(1000).byteValue());



    }

}
