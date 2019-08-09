package main.xmlpack.classtest;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class XmlTest {

  public static void main(String[] args)
      throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    //создаем парсер из фабрики
    SAXParser saxParser = factory.newSAXParser();

    //файл для считывания
    File file = new File("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\xmltest\\country_pars.xml");
    if(file.exists()) {
      saxParser.parse(file,new MyHandler());
    }
  }
}
