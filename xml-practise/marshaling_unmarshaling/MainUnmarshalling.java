package main.xmlpack.marshaling_unmarshaling;




import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import main.xmlpack.marshaling_unmarshaling.country.CountryType;


public class MainUnmarshalling {

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CountryType.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        CountryType countryTypes =(CountryType) unmarshaller.unmarshal(new File("out.xml"));


            System.out.println(countryTypes.getName() + " " + countryTypes.getCapital()
                    + " " + countryTypes.getCountryCode() + " " + countryTypes.getDescription());



    }

}
