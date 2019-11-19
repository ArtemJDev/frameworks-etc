package com.company.threadsadvice;

import java.util.concurrent.locks.Lock;
/**
 * Simple method implementation ReentrantLock
 * increment field by two threads
 */
public class ReentrantLock {

  public static void main(String[] args) {
    Task task = new Task();
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        task.firstThread();
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        task.secondThread();
      }
    });
    task.showCounter();
  }
}

class Task {

  private int counter;
  private Lock lock = new java.util.concurrent.locks.ReentrantLock();

  private void increment() {
    for (int i = 0; i < 10000; i++) {
      counter++;
    }
  }

  public void firstThread() {
    lock.lock();
    increment();
    lock.unlock();
  }

  public void secondThread() {
    lock.lock();
    increment();
    lock.unlock();
  }
  public void showCounter() {
    System.out.println(counter);
  }
}
