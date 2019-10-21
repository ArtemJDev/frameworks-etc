package ru.training.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

  public static void main(String[] args) {
    MP3 mp3 = new MP3();
    mp3.setName("12Song name12");
    mp3.setAuthor("12Song Author12");

    //FOR JDBC
//    new SQLiteDAO().insertWithJDBC(mp3);

    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    MP3Dao sqLiteDAO = (MP3Dao) context.getBean("sqliteDAO");
    //вставка в табилцу
//    sqLiteDAO.insert(mp3);

//    System.out.println(sqLiteDAO.getMP3ListByAuthor("Justin").size());

    System.out.println(sqLiteDAO.getStat());
  }
}
