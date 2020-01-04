package ru.testapp;


public class ATM {

    int balance = 0;

    //add notes of different denominations
    public void deposit(int notes, int denomination) {
        balance += denomination * notes;
    }

    public int getBalance() {
        return balance;
    }
}
