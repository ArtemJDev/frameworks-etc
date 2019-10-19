package ru.training.spring.jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.training.spring.dao.Impls.SQLiteDAO;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

  public static void main(String[] args) {
    MP3 mp3 = new MP3();
    mp3.setName("Song name");
    mp3.setAuthor("Song Author");

    //FOR JDBC 
//    new SQLiteDAO().insertWithJDBC(mp3);

    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");
    sqLiteDAO.insert(mp3);
  }
}
