

package de.management.eventmanagement;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.*;

import de.management.dao.EventManagementDAOLocal;
import de.management.entities.Event;




/** Web-Service Schnittstellen
 * 	@author Malte Lange
 *  
 *  */
@WebService(serviceName= "EventManagement")
@Stateless
public class ManagementWebService {
	
	
	
	/** DAO Datenverarbeitung Bereitstellung */ 
	@EJB(beanName = "EventManagementDAO", beanInterface = de.management.dao.EventManagementDAOLocal.class)
	private EventManagementDAOLocal dao;
	
	
	// DataTransferObject 
	//@EJB
	//private DtoAssembler dtoAssembler;
	
	
	
	/** 1. Schnittstelle - Connection Test -
	 *  @author Malte Lange
	 *  */
	@WebMethod(operationName = "ConnectionTest")
	public Integer hasConnection() {
		return 200;
	}
	
	/** 2. Schnittstelle - Benutzer einrichten 
	 * @author Malte Lange
	 * */ 
	@WebMethod( operationName = "addUser")
	public Integer createUser(@WebParam(name = "username")String username,@WebParam(name = "deviceID")String deviceID) {
		Integer userID = dao.createUser(username, deviceID);
		return userID;
	}
	
	/** 3. Schnittstelle - Veranstaltungs-Übersicht bereitstellen
	 * @author Malte Lange
	 */ 
	@WebMethod(operationName = "getEvents")
	public List<Event> getEventOverview() {
		List<Event> data = dao.getEventOverview();
		
		return(data);	
	
	}
	
	/** 4. Schnittestelle - Alle Informationen einer Veranstaltung bereitstellen
	 *  @author Malte Lange
	 */
	
	@WebMethod(operationName ="getEvent")
	public Event getEvent(@WebParam(name="eventID") Integer eventID){
		
		return (dao.getEvent(eventID));
		
	}
	/**
	 * 5. Schnittstelle - Push Nachrichten versenden
	 * @author Malte Lange 
	 * @param msg
	 * @return
	 */
	@WebMethod(operationName="sendPush")
	public Integer sendPush(@WebParam(name="msg")String msg)
	{
		return 200;
	}
	
	

}

