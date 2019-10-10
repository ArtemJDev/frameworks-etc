package rest.crud.service;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.crud.dao.EmployeeDao;
import rest.crud.model.Employee;

@Path("/employees")
public class EmplService {

  @GET
  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  public List<Employee> getEmplotyes_XML() {
    return EmployeeDao.getAllEmployees();
  }

  @GET
  @Path("/{empNum}")
  @Produces(MediaType.APPLICATION_XML)
  public Employee getEmplotyee(@PathParam("empNum") String empNo) {
    return EmployeeDao.getEmployee(empNo);
  }

  @POST
  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  public Employee addEmployee(Employee employee) {
    return EmployeeDao.addEmployee(employee);
  }

  @PUT
  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  public Employee updateEmplotyee(Employee employee) {
    return EmployeeDao.updateEmployee(employee);
  }

  @DELETE
  @Path("/{empNo}")
  @Produces(MediaType.APPLICATION_XML)
  public void deleteEmplotyee(@PathParam("empNo") String  empNo) {
     EmployeeDao.deleteEmployee(empNo);
  }

}
