package com.company.threadsadvice.callablefuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallFuture {
  static private int result;
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    //except when thread is finish in future will be int
    Future<Integer> future = executorService.submit(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int randomValue = new Random().nextInt(10);
        if(randomValue < 5) {
          throw new Exception("Something bad happened");
        }
        return new Random().nextInt(10);
      }
    });
    executorService.shutdown();
    try {
      result = future.get();//get  - wait until the thread end
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      Throwable exc = e.getCause();
      System.out.println(exc.getMessage());
    }
    System.out.println(result);
  }
}
