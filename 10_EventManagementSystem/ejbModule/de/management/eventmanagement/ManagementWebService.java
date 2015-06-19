

package de.management.eventmanagement;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.*;

import de.management.dao.EventManagementDAOLocal;
import de.management.dto.EventTO;
import de.management.entities.Event;
import de.management.entities.Session;
import de.management.exceptions.ParamMissingException;
import de.management.push.sendMessage;
import de.management.util.DtoAssembler;




/** Web-Service Schnittstellen
 * 	@author Malte Lange
 *  @author Jonathan Peters 
 *  */
@WebService(serviceName= "EventManagement")
@Stateless
public class ManagementWebService {
	
	
	
	/** DAO Datenverarbeitung Bereitstellung */ 
	@EJB(beanName = "EventManagementDAO", beanInterface = de.management.dao.EventManagementDAOLocal.class)
	private EventManagementDAOLocal dao;
	
		
	
	/** DataTransferObject */ 
	@EJB
	private DtoAssembler dtoAssembler;
	
	
	
	/** 1. Schnittstelle - Connection Test -
	 *  @author Malte Lange
	 *  */
	@WebMethod(operationName = "ConnectionTest")
	public Integer hasConnection() {
		return 200;
	}
	
	/** 2. Schnittstelle - Benutzer einrichten 
	 * @author Malte Lange
	 * @param username,deviceID
	 * */ 
	@WebMethod( operationName = "addUser")
	public Integer createUser(@WebParam(name = "username")String username,@WebParam(name = "deviceID")String deviceID) throws ParamMissingException{
		Integer userID = dao.createUser(username, deviceID);
		return userID;
	}
	
	/** 3. Schnittstelle - Veranstaltungs-Übersicht bereitstellen
	 * @author Malte Lange
	 * @return List<Event>
	 */ 
	@WebMethod(operationName = "getEvents")
	public List<Event> getEventOverview() {
		List<Event> data = dao.getEventOverview();
		
		return(data);	
	
	}
	
	/** 
	 * 4. Schnittestelle - Alle Informationen einer Veranstaltung bereitstellen
	 * @author Malte Lange
	 * @throws ParamMissingException 
	 * @param eventID
	 */
	
	@WebMethod(operationName ="getEvent")
	public EventTO getEvent(@WebParam(name="eventID") Integer eventID) throws ParamMissingException{
		
				EventTO eventResponse = new EventTO();
		
				
				eventResponse.setName(dao.getEvent(eventID).getName());
				eventResponse.setDateStart(dao.getEvent(eventID).getDateStart());
				eventResponse.setDateEnd(dao.getEvent(eventID).getDateEnd());
				eventResponse.setID(dao.getEvent(eventID).getId());
				eventResponse.setDescription(dao.getEvent(eventID).getDescription());
				List<Session> sessionList = dao.getEvent(eventID).getSessions();
				eventResponse.setSessions(dtoAssembler.makeDTO(sessionList));
		return (eventResponse);
			
				
	}
	
	/**
	 * 5. Schnittstelle - Push Nachrichten versenden
	 * @author Malte Lange 
	 * @param msg
	 * @return
	 */
	
	@WebMethod(operationName="sendPushMessage")
	public Integer sendPush(@WebParam(name="msg")String msg) throws ParamMissingException
	{

		   sendMessage.action(msg);
		
	return 200;
	}

	/*
	 * 7. Schhnittstelle - Veranstaltung erstellen
	 * @author Jonathan Peters 
	 */
	@WebMethod(operationName ="createEvent")
	public Integer createEvent(@WebParam(name="event") Event event){
		
		return (dao.createEvent(event));
		
	}
	
	/*
	 * 8. Schnittstelle - Veranstaltung aktualisieren
	 * @author Jonathan Peters
	 */
	@WebMethod(operationName ="updateEvent")
	public Integer updateEvent(@WebParam(name="event") Event event){
		
		return (dao.updateEvent(event));
		
	}
	
	/*
	 * 9. Schnittstelle - Veranstaltung loeschen
	 * @author Jonathan Peters
	 */
	@WebMethod(operationName ="dropEvent")
	public Integer dropEvent(@WebParam(name="eventId") Integer eventId, @WebParam(name="userId") Integer userId){
		
		return (dao.dropEvent(eventId, userId));
		
	}
	
	/*
	 * 10. Schnittstelle - Termin erstellen
	 * @author Jonathan Peters
	 */
	@WebMethod(operationName ="createSession")
	public Integer createSession(@WebParam(name="session") Session session, @WebParam(name="eventId") Integer eventId, @WebParam(name="userId") Integer userId){ 
		
		return (dao.createSession(session, eventId, userId));
		
	}
	
	/*
	 * 11. Schnittstelle - Termin loeschen
	 * @author Jonathan Peters
	 */
	@WebMethod(operationName ="dropSession")
	public Integer createSession(@WebParam(name="sessionId") Integer sessionId, @WebParam(name="eventId") Integer eventId, @WebParam(name="userId") Integer userId){ 
		
		return (dao.dropSession(sessionId, eventId, userId));
		
	}
}
	
	



