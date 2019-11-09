package main.testeeal.ee.src.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainExample {

  public static void main(String[] args) {
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bookInit");
    EntityManager entityManager = managerFactory.createEntityManager();

//    Book book = new Book("main");

    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();
//    entityManager.persist(book);
    entityTransaction.commit();

    entityManager.close();
    managerFactory.close();
  }
}
