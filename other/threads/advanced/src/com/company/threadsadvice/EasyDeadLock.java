package com.company.threadsadvice.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

  public static void main(String[] args) {

    final String lock1 = "lock1";
    final String lock2 = "lock2";
    deadLock(lock1, lock2);
    deadLock(lock2, lock1);

  }

  private static void deadLock(String lock1, String lock2) {
    new Thread(() -> {
      System.out.println("Waiting " + lock1);
      synchronized (lock1) {
        System.out.println("Holding " + lock1);
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Waiting " + lock2);
        synchronized (lock2) {
          System.out.println("Holding " + lock2);
        }
      }
    }).start();
  }

