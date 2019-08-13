package main.xmlpack.marshaling_unmarshaling;




import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import main.xmlpack.marshaling_unmarshaling.country.CountryType;
import main.xmlpack.marshaling_unmarshaling.country.ObjectFactory;

public class MainMarshlling {

    public static void main(String[] args) throws JAXBException {
        ObjectFactory factory = new ObjectFactory();
        CountryType countryType = factory.createCountryType();
        countryType.setName("Germany");
        countryType.setCapital("Berlin");
        countryType.setCountryCode("De");
        countryType.setDescription("Detchland is ... ");
//
        JAXBContext context = JAXBContext.newInstance(CountryType.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.marshal(countryType, new File("out.xml"));
    }
}
