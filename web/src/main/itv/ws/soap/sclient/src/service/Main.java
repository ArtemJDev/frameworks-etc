package main.itv.ws.soap.sclient.src.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080//Samples45_war_exploded/TempConverterImplService?wsdl");

        QName qName = new QName("http://service/", "TempConverterImplService");
        Service service = Service.create(url, qName);

        QName port = new QName("http://service/", "TempConverterImplPort");

        TempConverter tv = service.getPort(port, TempConverter.class);


        System.out.println(tv.c2f(100));
        System.out.println(tv.f2c(218));
    }


}
