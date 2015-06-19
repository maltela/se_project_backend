package de.management.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
//import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;
import de.management.entities.User;
import de.management.entities.Event;
import de.management.entities.Session;


@Startup
@Singleton
/** Beispieldaten Beladung / Objekte verfizieren 
 * 	@author Malte Lange 
 * */
public class DataBuilder {
	private static final Logger logger = Logger.getLogger(DataBuilder.class);
	

	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	private String Event;

	@PostConstruct
	private void init() throws ParseException {
		
		
		
		// Date bereitstellen für Objekt Erstellung
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        Date date = null;
		date = simpleDateFormat.parse("01/08/2015");
		
		
		logger.info("Beispiel-Datenobjekte anlegen");
		User user1 = new User("User1","23432");	
		User user2 = new User("User2","23432");	
		User user3 = new User("User3","23432");	
		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		User userdb = em.find(User.class,1);
		logger.info("User: "+userdb.getName()+ " ID: "+userdb.getUserID());
		Event event1 = new Event ("Majom-Event1","Intialisierungs-Veranstaltung",date,date);
		Event event2 = new Event ("Majom-Event2","Intialisierungs-Veranstaltung",date,date);
		Event event3 = new Event ("Majom-Event3","Intialisierungs-Veranstaltung",date,date);
		logger.info("Event-Objekte persistieren");
		em.persist(event1);
		em.persist(event2);
		em.persist(event3);
		Session session1 = new Session("Session1",date,date,"FHZ","Test","PLZ");
		Session session2 = new Session("Session2",date,date,"FHZ","Test","PLZ");
		Session session3 = new Session("Session3",date,date,"FHZ","Test","PLZ");
		logger.info("Session-Objekte persistieren");
		em.persist(session1);
		em.persist(session2);
		em.persist(session3);
		//Termine der Veranstaltung hinzufügen
		event1.addSessions(session1);
		event1.addSessions(session2);
		event1.addSessions(session3);
		em.persist(event1);
		logger.info("Veranstaltung"+event1.getName()+" mit "+ event1.getSessions().size()+" Termin angelegt");
		
	}
		
}





