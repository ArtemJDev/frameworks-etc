package main.xmlpack.SAX_object_1.entity;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import main.xmlpack.SAX_object_1.SandwichHandler;
import main.xmlpack.classtest.MyHandler;
import org.xml.sax.SAXException;

public class Main {

  public static void main(String[] args)
      throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    //создаем парсер из фабрики
    SAXParser saxParser = factory.newSAXParser();
    SandwichHandler sandwich = new SandwichHandler();

    //файл для считывания
    File file = new File("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\SAX_object_1\\sandwich.xml");
    if(file.exists()) {
      saxParser.parse(file,sandwich);
      Sandwich sh = sandwich.getSandwich();
      System.out.println("Sandwich info :");
      System.out.println(sh.getTitle());

      List<Ingridient> ingridients = sh.getIngridients();

      for(Ingridient ingridient : ingridients) {
        System.out.println(ingridient.getTitle());
      }
    }
  }
}
