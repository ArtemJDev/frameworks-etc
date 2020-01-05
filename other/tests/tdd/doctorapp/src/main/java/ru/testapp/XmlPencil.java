package ru.testapp;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlPencil implements Pencil {

    private final String fileName;

    public XmlPencil(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(Hospital hospital) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class, Note.class, Injection.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(hospital, new File(fileName));
        } catch (JAXBException e) {
            throw  new RuntimeException(e);
        }
    }

    public void read(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class, Note.class, Injection.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Hospital hospital = (Hospital) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            throw  new RuntimeException(e);

        }
    }
}





