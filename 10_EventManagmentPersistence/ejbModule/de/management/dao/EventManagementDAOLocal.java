package de.management.dao;

import java.util.HashMap;
import java.util.List;





import de.management.entities.*;



import javax.ejb.Local;

@Local
public interface EventManagementDAOLocal {
	
	
	
	// Ausgabe Veranstaltungsübersicht  -> Wunschzettel : HashMap (ID+Name) 
	public HashMap<Integer,String> getEvents();
	public HashMap<Integer,String> getEvents(Integer userID);
	// Ausgabe Veranstaltungsinformation 
	public List<Event> getEvent(Integer id);		 
	// Ausgabe Sessions anhand Event 
	public List<Session> getSessions(Integer eventID);
	//User Registrierung @Backend  Return User-ID 
	public Integer createUser(String username,String DeviseID);
	
	// Veranstaltung beitreten 
	public Event joinEvent(Integer eventID,Integer userID);

	//
	//*********** Admin-Anwedungsfälle***************** 
	//
	
	// Push-Nachricht erstellen  
	public Integer createPush();
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
