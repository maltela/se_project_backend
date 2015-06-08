package de.management.eventmanagement;


import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.*;

import org.jboss.logging.Logger;

import de.management.dao.EventManagementDAOLocal;



@WebService(serviceName= "EventManagement")
@Stateless
public class ManagementWebService {
	
	private static final Logger logger = Logger.getLogger(WebService.class);
	
	// Datenverarbeitung Bereitstellung 
	@EJB(beanName = "EventManagementDAO", beanInterface = de.management.dao.EventManagementDAOLocal.class)
	private EventManagementDAOLocal dao;
	
	
	// DataTransferObject 
	//@EJB
	//private DtoAssembler dtoAssembler;
	
	
	// Connection Test
	@WebMethod(operationName = "ConnectionTest")
	public Integer hasConnection() {
		logger.info ("Client-Connection");
		return 200;
	}
	
	// Benutzer einrichten 
	@WebMethod( operationName = "addUser")
	public Integer createUser(@WebParam(name = "username")String username,@WebParam(name = "deviceID")String deviceID) {
		Integer userID = dao.createUser(username, deviceID);
		
		return userID;
	}
	
	// Veranstaltungs-Übersicht 
	@WebMethod(operationName = "getEvents")
	public ArrayList<String> getEvents() {
		
		
		return null;
	}
	
	// Veranstaltungsinformationen
	
	@WebMethod(operationName ="getEvent")
	public HashMap<String,String> getEvent(@WebParam(name="eventID") Integer eventID){
		
		dao.getEvent(eventID);
		
		return null;
		
	}

}



