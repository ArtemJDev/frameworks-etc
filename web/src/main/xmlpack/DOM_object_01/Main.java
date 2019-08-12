package main.xmlpack.DOM_object_01;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

  public static void main(String[] args)
      throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setIgnoringElementContentWhitespace(true);

    DocumentBuilder  db = dbf.newDocumentBuilder();
    Document document =  db.parse("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\DOM\\books.xml");

    Element root = document.getDocumentElement();

    System.out.println(root.getNodeName()); //root tag
    System.out.println(root.getNodeType()); //

    NodeList list = root.getElementsByTagName("book");

    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);

      System.out.println("Book Name :" + root.getElementsByTagName("title").item(i).getFirstChild().getTextContent());
      System.out.println("Author Name :" + root.getElementsByTagName("author").item(i).getFirstChild().getTextContent());
      System.out.println("ID :" + node.getAttributes().item(0).getNodeValue());
      System.out.println("ISBN :" + node.getAttributes().item(1).getNodeValue());

    }
  }

}
