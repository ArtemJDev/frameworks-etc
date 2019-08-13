package main.xmlpack.X_Path;



import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        XPathExpression expression = path.compile("//employee/firstname | //employee[age > 40]/lastname");

        File xml = new File("C:\\projects\\frameworks_etc\\web\\src\\main\\xmlpack\\X_Path\\employees.xml");

        InputSource source = new InputSource(new FileInputStream(xml));

        Object result = expression.evaluate(source, XPathConstants.NODESET);

        NodeList list = (NodeList) result;

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.print("Node name: " + node.getNodeName());
            System.out.print(" Node value: " + node.getFirstChild().getNodeValue());
            System.out.print("\n");

            if (node.getNodeName().equals("email")) {
                System.out.print("\n");
            }
        }
    }
}
