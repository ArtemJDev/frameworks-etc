package main.xmlpack.SAX_object_2;

import java.util.ArrayList;
import java.util.List;
import main.xmlpack.SAX_object_2.entity.Country;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CountryHandler extends DefaultHandler {

  private String currentQname;

  public List<Country> getCountries() {
    return countries;
  }

  private List<Country> countries;
  private Country currentCountry;
  private String currentAttributes;

  public CountryHandler() {
    countries = new ArrayList<>();
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
    System.out.println("Start element: " + qName);
    currentQname = qName;

    if(attributes.getLength() > 0) {
      currentAttributes = attributes.getValue(0);
    }

  }
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
  String value = new String(ch,start,length);
    System.out.println("Characters: " + value);

    switch (currentQname) {
      case "country" :
        currentCountry = new Country();
        currentCountry.setCode(currentAttributes);
        break;
      case "name" :
        currentCountry.setName(value);
        break;
      case "capital" :
        currentCountry.setCapital(value);
        break;
      case "description" :
        currentCountry.setDescription(value);
    }
  }
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    System.out.println("End element : " + qName);
    currentQname = "";

    if(qName.equals("country")) {
      countries.add(currentCountry);
    }
  }
}
