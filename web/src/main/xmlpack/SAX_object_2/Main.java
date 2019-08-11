package main.xmlpack.SAX_object_2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import main.xmlpack.SAX_object_2.entity.Country;
import org.xml.sax.SAXException;

public class Main {

  public static void main(String[] args)
      throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();
    CountryHandler countryHandler = new CountryHandler();

    File file = new File("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\SAX_object_2\\country.xml");

    if(file.exists()) {
      parser.parse(file,countryHandler);
      List<Country> countries = countryHandler.getCountries();

      System.out.println("All countries : ");

      for (Country country : countries) {
        System.out.println(country.getCode() + " " + country.getName() + " " + country.getCapital() + " " + country.getDescription());
      }

    }

  }


}
