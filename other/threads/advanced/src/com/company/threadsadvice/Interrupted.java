package com.company.threadsadvice.interrupted;

import java.util.Random;

public class Interrupted {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
       Random random = new Random();
        for (int i = 0; i < 1_000_000_000; i++) {
          try {
            Thread.sleep(1);
          } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            System.out.println("i = " + i);
          }
//          if(Thread.currentThread().isInterrupted()) {
//            System.out.println("Thread was interrupted");
//            System.out.println("i = " + i);
//            break;
//          }
          Math.sin(random.nextInt(1000));
        }
      }
    });
    System.out.println("Statring thread");
    thread.start();
    Thread.sleep(1000);
    thread.interrupt();

    thread.join();
    System.out.println("Thread has finished");
  }
}
