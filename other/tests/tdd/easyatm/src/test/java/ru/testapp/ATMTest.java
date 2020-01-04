package ru.testapp;

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

}
