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
	// Ausgabe Veranstaltungsinformation 
	public Event getEvent();
	// Ausgabe Sessions anhand Event 
	public List<Session> getSessions(Event event);
	//User Registrierung @Backend 
	public Integer createUser(String username,Event event,Rolle Rolle,String DeviseID);
	;
	// Veranstaltung beitreten 
	public Integer joinEvent();
	// Admin 
	
	// Push-Nachricht erstellen  
	public boolean createPush();
	// Veranstaltung erstellen
	public Integer createEvent();
	// Termin erstellen
	public Integer createSession();
	// Veranstatlung ändern
	public Integer updateEvent();
	// Termin ändern 
	public Integer updateSession();
	// Veranstaltung löschen
	public Integer dropEvent();
	// Termin löschen
	public Integer dropSession();
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
