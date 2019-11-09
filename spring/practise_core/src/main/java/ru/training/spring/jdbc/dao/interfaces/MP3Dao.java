package ru.training.spring.jdbc.dao.interfaces;

import java.util.List;
import java.util.Map;
import ru.javabegin.training.spring.dao.objects.MP3;

public interface MP3Dao {

  int insert(MP3 mp3);
  void insert(List<MP3> mp3);
  void delete(int id);
  void delete(MP3 mp3);
  MP3 getMP3ByID(int id);
  List<MP3> getMP3ListByName(String name);
  List<MP3> getMP3ListByAuthor(String name);
  Map<String, Integer> getStat();

}
