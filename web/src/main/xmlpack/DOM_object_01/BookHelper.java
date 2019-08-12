package main.xmlpack.DOM_object_01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import main.xmlpack.DOM_object_01.entity.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BookHelper {

  private Document document;


  public BookHelper()
      throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setIgnoringElementContentWhitespace(true);

    DocumentBuilder db = dbf.newDocumentBuilder();
    document = db
        .parse("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\DOM_object_01\\books.xml");

  }

    public List<Book> getAll() {
      List<Book> books = new ArrayList<>();

      Element root = document.getDocumentElement();

      NodeList list = root.getElementsByTagName("book");

      for (int i = 0; i < list.getLength(); i++) {
        Book book = new Book();
        String title = root.getElementsByTagName("title").item(i).getFirstChild().getTextContent();
        String author = root.getElementsByTagName("author").item(i).getFirstChild().getTextContent();
        String id = list.item(i).getAttributes().item(0).getNodeValue();
        long isbn = Long.valueOf(list.item(i).getAttributes().item(i).getNodeValue());
        book.setTitle(title);
        book.setAuthor(author);
        book.setId(id);
        book.setIsbn(isbn);
        books.add(book);


      }
      return books;
    }
  }

