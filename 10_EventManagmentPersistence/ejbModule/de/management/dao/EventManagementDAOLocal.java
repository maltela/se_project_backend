package de.management.dao;

import java.util.HashMap;
import java.util.List;

//import javax.ejb.Local;


import de.management.entities.*;




public interface EventManagementDAOLocal {
	
	
	// Connection Test
	public Integer hasConnection();
		
	// Ausgabe Veranstaltungsübersicht  -> Wunschzettel : HashMap (ID+Name) 
	public HashMap<Integer,String> getEvents();
	public HashMap<Integer,String> getEvents(Integer userID);
	
	// Ausgabe Veranstaltungsinformation 
	public Event getEvent(Integer id);
			 
	// Ausgabe Sessions anhand Event 
	public List<Session> getSessions(Integer eventID);
	//User Registrierung @Backend  Return User-ID 
	public Integer createUser(String username,String DeviseID);
	
	// Veranstaltung beitreten 
	public Integer joinEvent();
	//*********** Admin-Anwedungsfälle***************** 
	
	// Push-Nachricht erstellen  
	public boolean createPush();
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
	//******************************
	// Push-Nachricht erstellen
	
	
	
	//USE_CASE XBANK
	/*
	public Customer findCustomerByName(String userName);
	
	public Account findAccountById(int id);
	
	public XbankSession findSessionById(int id);
	
	public int createSession(Customer user);

	public void closeSession(int id);
		*/

}
