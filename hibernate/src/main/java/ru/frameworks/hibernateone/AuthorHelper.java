package ru.frameworks.hibernateone;

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
    public List<Author> getAuthorList(){
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();
         // этап подготовки запроса
        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from), от чего отталкиваемся
        cq.select(root);// необязательный оператор, если просто нужно получить все значения
        // этап выполнения запроса
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }
    public Author getAuthor(String name){
        return null;
    }
}
