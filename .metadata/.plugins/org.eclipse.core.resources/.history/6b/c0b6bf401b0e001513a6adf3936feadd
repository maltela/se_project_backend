package de.management.dao;

import java.util.ArrayList;





import de.management.entities.*;

import javax.ejb.Local;

@Local
public interface EventManagementDAOLocal {
	
	
	
	// Ausgabe Veranstaltungsübersicht  -> Wunschzettel : HashMap (ID+Name) 
	public ArrayList<String> getEvents();
	public ArrayList<Event> getEvents(Integer userID);
	// Ausgabe Veranstaltungsinformation 
	public Event getEvent(Integer id);		 
	//User Registrierung @Backend  Return User-ID 
	public Integer createUser(String username,String DeviseID);
	
	
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
