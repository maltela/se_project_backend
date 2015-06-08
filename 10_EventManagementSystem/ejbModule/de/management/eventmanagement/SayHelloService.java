package de.management.eventmanagement;

import javax.jws.*;

@WebService(serviceName = "SayHelloService")
public class SayHelloService {
 
    /** This is a sample web service operation */
    @WebMethod(operationName = "hello")
    public String sayHello(@WebParam(name = "name") String txt) {
        return "Erfolgreich angemeldet : " + txt + " !";
    }
}