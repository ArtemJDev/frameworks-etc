package main.xmlpack.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Catalog catal = new Catalog();
        catal.add(new Book("Author1", "Title1", 40.55, new Date()));
        catal.add(new Book("Author2", "Title2", 30, new Date()));

        try {
            // Создаем файл
            File file = new File("D:\\Andrew\\CB\\Java EE \\002_JAXP_and_JAXB\\002_Samples" +
                    "\\src\\com\\webservices\\ex_012_JAXB\\output.xml");
            // Вызываем статический метод JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            // Возвращает объект класса Marshaller, для того чтобы трансформировать объект
            Marshaller mar = jaxbContext.createMarshaller();

            // Читабельное форматирование
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записываем в файл, marshal(из памяти, в файл)
            mar.marshal(catal, file);
            mar.marshal(catal, System.out);

            // Считываем из файла
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            catal = (Catalog) unmar.unmarshal(file);
            System.out.println(catal);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}