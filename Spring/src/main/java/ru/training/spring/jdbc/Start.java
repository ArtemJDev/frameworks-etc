package ru.training.spring.jdbc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.training.spring.dao.interfaces.MP3Dao;
import ru.training.spring.dao.objects.MP3;

public class Start {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    MP3Dao sqLiteDAO = (MP3Dao) context.getBean("sqliteDAO");

    MP3 mp3 = new MP3();
    mp3.setName("1112Song name12");
    mp3.setAuthor("1112Song Author12");

    MP3 mp3Second= new MP3();
    mp3Second.setName("22Song name122");
    mp3Second.setAuthor("22Song Author1222");

    //FOR JDBC
//    new SQLiteDAO().insertWithJDBC(mp3);

    //массовая вставка
    List<MP3> mp3List = new ArrayList<MP3>();
    mp3List.add(mp3);
    mp3List.add(mp3Second);
    System.out.println(sqLiteDAO.batchInsert(mp3List));


    //вставка в табилцу
//    sqLiteDAO.insert(mp3);

//    System.out.println(sqLiteDAO.getMP3ListByAuthor("Justin").size());

//    System.out.println(sqLiteDAO.getStat());
  }
}
