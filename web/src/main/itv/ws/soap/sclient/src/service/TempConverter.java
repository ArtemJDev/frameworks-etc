package main.itv.ws.soap.sclient.src.service;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface TempConverter {

    @WebMethod
    double c2f(double degrees);

    @WebMethod
    double f2c(double degrees);

}
