package main.xmlpack.DOM_object_01;

import main.xmlpack.DOM_object_01.entity.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookHelper {

  private Document document;

  public BookHelper() throws IOException, SAXException, ParserConfigurationException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setIgnoringElementContentWhitespace(true);

    DocumentBuilder db = dbf.newDocumentBuilder();

    document = db.parse("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\DOM_object_01\\books.xml");
  }
  public List<Book> getAll() {
    List<Book> books = new ArrayList<>();

    Element root = document.getDocumentElement();

    NodeList list = root.getElementsByTagName("book");

    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      Book book = new Book();
      String title = root.getElementsByTagName("title").item(i).getFirstChild().getTextContent();
      String author = root.getElementsByTagName("author").item(i).getFirstChild().getTextContent();
      String id = node.getAttributes().item(0).getNodeValue();
      long isdn = Long.valueOf(node.getAttributes().item(1).getNodeValue());
      book.setTitle(title);
      book.setAuthor(author);
      book.setId(id);
      book.setIsdn(isdn);
      books.add(book);
    }

    return books;
  }

  public void addBook(Book newBook) throws FileNotFoundException, TransformerException {
    Element root = document.getDocumentElement();

    Element book = document.createElement("book");
    Element title = document.createElement("title");
    Element author = document.createElement("author");

    book.setAttribute("id", newBook.getId());
    book.setAttribute("isbn", String.valueOf( newBook.getIsdn() ) );
    title.setTextContent(newBook.getTitle());
    author.setTextContent(newBook.getAuthor());

    book.appendChild(title);
    book.appendChild(author);

    root.appendChild(book);

    DOMSource source = new DOMSource(document);
    String outputURL = "C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\DOM_object_01\\booksCreate.xml";

    StreamResult result = new StreamResult(new FileOutputStream(outputURL));

    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.transform(source, result);
  }

}


