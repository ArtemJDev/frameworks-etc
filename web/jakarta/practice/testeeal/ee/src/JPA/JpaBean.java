package main.testeeal.ee.src.JPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaBean {
@PersistenceContext
  EntityManager entityManager;
//public void saveBook(Book book) {
//  entityManager.persist(book);
}
//}
