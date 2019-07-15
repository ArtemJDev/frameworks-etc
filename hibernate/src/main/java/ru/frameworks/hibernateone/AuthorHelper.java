package ru.frameworks.hibernateone;

import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Selection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.frameworks.hibernateone.entity.Author;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {

  private SessionFactory sessionFactory;

  public AuthorHelper() {
    sessionFactory = HibernateUtil.getSessionfactory();
  }

  public List<Author> getAuthorList() {
    // открыть сессию - для манипуляции с персист. объектами
    Session session = sessionFactory.openSession();
    // этап подготовки запроса
    // объект-конструктор запросов для Criteria API
    CriteriaBuilder cb = session
        .getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
    CriteriaQuery cq = cb.createQuery(Author.class);
    Root<Author> root = cq.from(
        Author.class);// первостепенный, корневой entity (в sql запросе - from), от чего отталкиваемся
    cq.select(root);// необязательный оператор, если просто нужно получить все значения
    // этап выполнения запроса
    Query query = session.createQuery(cq);
    List<Author> authorList = query.getResultList();
    session.close();
    return authorList;
  }

  public void deleteField() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Author a = session.get(Author.class, 39l);
    session.delete(a);
    session.getTransaction().commit();
    session.close();
  }

  public Author getAuthor(long id) {
    Session session = sessionFactory.openSession();

    Author author = session.get(Author.class, id);
    author.getBooks().get(0).getName();
    return  author;
  }

  public void updateField(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
    CriteriaUpdate<Author> criteriaUpdate = cb.createCriteriaUpdate(Author.class);
    Root<Author> root = criteriaUpdate.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)
    ParameterExpression<String> nameParam = cb.parameter(String.class, "name");
    Expression<Integer> length = cb.length(root.get("second_name"));

    criteriaUpdate.set(root.get("name"), java.util.Optional.ofNullable(nameParam)).
        where(cb.equal(length, 5));
    Query query = session.createQuery(criteriaUpdate);
    query.setParameter("name", "1111");
    query.executeUpdate();// вместо возврата результата - используется метод обновления

    session.getTransaction().commit();
    session.close();
  }

  public void deletePack() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaDelete<Author> criteriaDelete = cb.createCriteriaDelete(Author.class);
    Root<Author> root = criteriaDelete.from(Author.class);
    ParameterExpression<String> nameParam = cb.parameter(String.class, "name");

    criteriaDelete.where( //ставит Or между операторами
        cb.and(cb.like(root.get("name"), nameParam), cb.like(root.get("name"), nameParam)));

    Query query = session.createQuery(criteriaDelete);
    query.setParameter("name", "%4%");
    query.executeUpdate();
    session.getTransaction().commit();
    session.close();
  }

  public List<Author> takeAuthorWhere() {
    Session session = sessionFactory.openSession();

    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery cq = cb.createQuery(Author.class);
    Root<Author> root = cq.from(Author.class);
    Selection[] selections = {root.get("id"), root.get("name")};
    ParameterExpression<String> nameParam = cb.parameter(String.class, "name");
    cq.select(cb.construct(Author.class, selections)).where(cb.like(root.get("name"), nameParam));

    Query query = session.createQuery(cq);
    query.setParameter("name", "%1%");
    List<Author> authorList = query.getResultList();
    return authorList;
  }

  //Добавление нового автора в таблице
  public Author addAuthor(Author author) {

    Session session = sessionFactory.openSession();//Создаем сессию
    session.beginTransaction();//Начинаем транзакцию
    session.save(author);//сшенерит ID и вставит в объект
    session.getTransaction().commit();
    session.close(); //автоматически коммитится когда закрываем сессию
    return author;


  }

  public List<Author> getAuthotNotAllFields() {
    Session session = sessionFactory.openSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery cq = cb.createQuery(Author.class);
    Root<Author> root = cq.from(Author.class);
    Selection[] selections = {root.get("id"),
        root.get("name")}; //выборка полей, должен быть коснтурктор с этими
    cq.select(cb.construct(Author.class,
        selections)); //неогбязхательно, если надо просто получить занчение

    Query query = session.createQuery(cq);
    List<Author> authorList = query.getResultList();
    return authorList;
  }

  public Author setAuthor() {
    Session session = sessionFactory.openSession();//Создаем сессию
    Author a1 = session.get(Author.class, 1l);
    a1.setName("Лермонтов27");
    a1.setSecond_name("Tolstoy");
    session.beginTransaction();
    session.save(a1);
    session.getTransaction().commit();
    session.close();
    return a1;
  }

  public Author getAuthor(String name) {
    return null;
  }
}
