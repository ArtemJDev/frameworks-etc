package main.xmlpack.DOM_create;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Main {

  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setIgnoringElementContentWhitespace(true);

    DocumentBuilder db = dbf.newDocumentBuilder();

    Document document = db.newDocument(); //не парсе , просто создается новый документ
//                db.parse("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\DOM\\books.xml");

    Element root = document.createElement("books");

    Element book = document.createElement("book");
    Element title = document.createElement("title");
    Element author = document.createElement("author");

    book.setAttribute("id", "04");
    book.setAttribute("isbn", "333555");
    title.setTextContent("Lukomore");
    author.setTextContent("Alexandr Pushkin");

    book.appendChild(title);
    book.appendChild(author);

    root.appendChild(book);
    document.appendChild(root);

    DOMSource source = new DOMSource(document);
    String outputURL = "C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\DOM_create\\books_edit.xml";

    StreamResult result = new StreamResult(new FileOutputStream(outputURL));

    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.transform(source, result);

  }

}
