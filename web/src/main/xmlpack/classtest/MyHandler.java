package main.xmlpack.classtest;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

  //вызывается в начале xml файла
  @Override
  public void startDocument() throws SAXException {
    System.out.println("Start Document");
  }

  //вызывается на начале любого тега
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
    System.out.println("Start Element" + qName);
    //идем в цикле по все маттрибутам - имя аттрибута + значение
    for (int i = 0; i < attributes.getLength(); i++) {
      System.out.println("Attribute:" + attributes.getQName(i) + " " + attributes.getValue(i));
    }
  }

  //вызывается в начале ст рокового значения + пробелы
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    System.out.println("Characters :"  + new String(ch, start, length) );
  }

  //вызывается в на закрывыающем теге
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    System.out.println("End Element" + qName);

  }

  @Override
  public void endDocument() throws SAXException {
    System.out.println("End Document");
  }
}
