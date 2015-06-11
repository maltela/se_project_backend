package de.management.dao;

import java.util.ArrayList;






import java.util.List;

import de.management.entities.*;

import javax.ejb.Local;

@Local
/**
 * Interface zur Persistierung 
 * @author Malte Lange 
 *
 */
public interface EventManagementDAOLocal {
	
	
	
	// Ausgabe Veranstaltungsübersicht  
	public List<Event> getEventOverview();
	// Ausgabe Veranstaltungsinformation 
	public Event getEvent(Integer id);		 
	// Benutzer Registrierung @Backend  
	public Integer createUser(String username,String DeviseID);
	// Push-Nachricht erstellen  
	public Integer createPush(String msg);
	
	//
	//*********** Admin-Anwedungsfälle***************** 
	//
	
	// Veranstaltung erstellen
	public Integer createEvent(Event event,Integer UserID);
	// Termin erstellen
	public Integer createSession(Session session,Integer UserID);
	// Veranstatlung ändern
	public Integer updateEvent(Event event,Integer userID);
	// Termin ändern 
	public Integer updateSession(Session session, Integer userID);
	// Veranstaltung löschen
	public Integer dropEvent(Integer eventID, Integer userID);
	// Termin löschen
	public Integer dropSession(Integer sessionID,Integer userID);
	
}
