
import java.sql.Connection;


public interface IDAOFactory {

    CarDAO getCarDAO();

    ClientDAO getClientDAO();


}
