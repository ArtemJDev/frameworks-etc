package ru.training.spring.jdbc.daoimprove.aoptransaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class CheckTransaaction {

  public void checkTransactionActive() {
    System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

  }

}
