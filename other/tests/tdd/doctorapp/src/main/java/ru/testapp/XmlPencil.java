package ru.testapp;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlPencil implements Pencil {

    private final String fileName;

    public XmlPencil(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(Hospital hospital) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class, Thing.class, Injection.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(hospital, new File(fileName));
        } catch (JAXBException e) {
            throw  new RuntimeException(e);
        }

    }
}
