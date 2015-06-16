

package de.management.eventmanagement;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.jws.*;

import org.jboss.aerogear.unifiedpush.DefaultPushSender;
import org.jboss.aerogear.unifiedpush.PushSender;
import org.jboss.aerogear.unifiedpush.message.UnifiedMessage;

import de.management.dao.EventManagementDAOLocal;
import de.management.entities.Event;
import de.management.push.*;




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
	
	/** Push Bereitstellen 
	 * 
	 */
	
	
	
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
		PushSender defaultPushSender = DefaultPushSender.withRootServerURL("https://seprojektpush-fhmuenster.rhcloud.com/ag-push")
	            .pushApplicationId("a5f8dc54-85db-4557-9df7-a0d5fbd1ffa0")
	            .masterSecret("79f2c3bf-edf9-43ff-a8d6-453fcc004c31")
	            .build();
		
		
		
		 UnifiedMessage message = UnifiedMessage.withCriteria()
	             .aliases("john", "maria")
	             .message()
	               .alert("Messagae:"+msg)
	               .sound("default")
	               .badge("1") // iOS specific
	               .userData("some_key", "some_value") // optional attributes specific to your app
	               .userData("title", "Cool Title") // optional cordova Android specific attribute (default is appName)
	             .build();
		 
		
		 
		 defaultPushSender.send(message);
	
		return 200;
	}
	
	/** Webservices fehlen noch */
	
	

}

