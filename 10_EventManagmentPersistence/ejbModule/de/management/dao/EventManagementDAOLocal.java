package de.management.dao;

import java.util.List;

import javax.ejb.Local;

import de.management.entities.*;




public interface EventManagementDAOLocal {
	
	
	// Connection Test
	public boolean hasConnection();
		
	// Ausgabe Veranstaltungen 
	public List<String> getEvents();
	
	// Ausgabe Sessions anhand Event 
	public List<String> getSessions(Event event);
	
	
	//User Registrierung @Backend 
	public User createUser(String username,Event event,String Rolle);
	
	// Prüfung Geräte-ID = Username -> Eindeutige Identifizierung  
	
	//**** Admin-Funktionen ***
	
	// Veranstaltung erstellen
	// Veranstaltung ändern
	// Veranstaltung löschen
		
	// Termin erstellen
	// Termin ändern
	// Termin löschen
	
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
