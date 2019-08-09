package main.xmlpack.SAX_object_1;

import main.xmlpack.SAX_object_1.entity.Ingridient;
import main.xmlpack.SAX_object_1.entity.Sandwich;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SandwichHandler extends DefaultHandler {

  private Sandwich sandwich;
  private String currentQname;
  private int countIngridients;

  public SandwichHandler() {
    sandwich = new Sandwich();
  }
 //можем взять имя тега
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
    System.out.println("Start element: " + qName);
    currentQname = qName;
    countIngridients = (attributes.getLength() > 0) ? Integer.parseInt(attributes.getValue(0)) : 1;
  }

  public Sandwich getSandwich() {
    return sandwich;
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    System.out.println("End Element " + qName);
    currentQname = "";
  }

  //можем взять имя строкового элемента
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    String value = new String(ch, start, length);
    System.out.println("Characters: " + value);

    switch (currentQname) {
      case "title" :
        sandwich.setTitle(value);
        break;
      case "ingridient" :
        for (int i = 0; i < countIngridients; i++) {
          sandwich.addIngridient(new Ingridient(value)); //добавляем по количеству значений
        }
    }
  }
}
