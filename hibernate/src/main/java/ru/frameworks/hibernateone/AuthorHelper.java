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

    //Добавление нового автора в таблице
    public Author addAuthor(Author author){

        Session session = sessionFactory.openSession();//Создаем сессию
        session.beginTransaction();//Начинаем транзакцию
        session.save(author);//сшенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close(); //автоматически коммитится когда закрываем сессию
        return  author;


    }

    public Author setAuthor(){
        Session session = sessionFactory.openSession();//Создаем сессию
        Author a1 = session.get(Author.class,1l);
        a1.setName("Лермонтов27");
        session.beginTransaction();
        session.save(a1);
        session.getTransaction().commit();
        session.close();
        return a1;
    }
    public Author getAuthor(String name){
        return null;
    }
}
