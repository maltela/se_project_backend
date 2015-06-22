package de.management.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		//2015-08-01T00:00:00+02:00
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        simpleDateFormat.setLenient(false);
        Date dateStart = null;
        Date dateEnd = null;
        //dateStart = simpleDateFormat.parse("01/08/2015");
        //dateEnd = simpleDateFormat.parse("01/08/2015");
		
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Calendar myCal1 = Calendar.getInstance();
		Calendar myCal2 = Calendar.getInstance();
		myCal1.set(2015,8, 1,00,00,00);
		myCal2.set(2015,8, 1,23,59,59);
		
		dateStart = myCal1.getTime();
		dateEnd = myCal2.getTime();
		simpleDateFormat.format(dateStart);
		simpleDateFormat.format(dateEnd);
	
		
		logger.info("Beispiel-Datenobjekte anlegen");
		User user1 = new User("User1","23432");	
		User user2 = new User("User2","23432");	
		User user3 = new User("User3","23432");	
		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		User userdb = em.find(User.class,1);
		logger.info("User: "+userdb.getName()+ " ID: "+userdb.getUserID());
		myCal1.set(2015,8, 1,00,00,00);
		myCal2.set(2015,8, 5,23,59,59);
		dateStart = myCal1.getTime();
		dateEnd = myCal2.getTime();
		Event event1 = new Event ("Erstsemster-Einführung","Einführungstage an der FH Münster für die Studiengänge BWL & WI",dateStart,dateEnd);
		Event event2 = new Event ("Majom-Event2","Intialisierungs-Veranstaltung",dateStart,dateEnd);
		Event event3 = new Event ("Majom-Event3","Intialisierungs-Veranstaltung",dateStart,dateEnd);
		logger.info("Event-Objekte persistieren");
		em.persist(event1);
		em.persist(event2);
		em.persist(event3);
		myCal1.set(2015,8, 1,8,30,00);
		myCal2.set(2015,8, 1,10,00,00);
		dateStart = myCal1.getTime();
		dateEnd = myCal2.getTime();
		Session session1 = new Session("Vortrag Dekan",dateStart,dateEnd,"FHZ - A004","48145","Leiter des Fachbereichs Wirtschaft");
		myCal1.set(2015,8, 1,10,00,00);
		myCal2.set(2015,8, 1,11,30,00);
		dateStart = myCal1.getTime();
		dateEnd = myCal2.getTime();
		Session session2 = new Session("Vortrag Studiengangsleitung",dateStart,dateEnd,"FHZ - A004","48145","Leitung des jeweiligen Studiengangs");
		myCal1.set(2015,8, 1,12,30,00);
		myCal2.set(2015,8, 1,13,00,00);
		dateStart = myCal1.getTime();
		dateEnd = myCal2.getTime();
		Session session3 = new Session("Vortrag Fachschaft",dateStart,dateEnd,"FHZ - B404","48145","Eure studentischen Vertreter/Ansprechpartner ");
		myCal1.set(2015,8, 2,8,30,00);
		myCal2.set(2015,8, 2,11,00,00);
		dateStart = myCal1.getTime();
		dateEnd = myCal2.getTime();
		Session session4 = new Session("Workshop ZSB",dateStart,dateEnd,"FHZ - A004","48145","Lernen lernen");
		myCal1.set(2015,8, 2,11,00,00);
		myCal2.set(2015,8, 2,11,30,00);
		dateStart = myCal1.getTime();
		dateEnd = myCal2.getTime();
		Session session5 = new Session("Vorstellung OFIS",dateStart,dateEnd,"FHZ - A004","48145","Ansprechpartner für Auslandssemster");
		
		
		
		
		logger.info("Session-Objekte persistieren");
		em.persist(session1);
		em.persist(session2);
		em.persist(session3);
		em.persist(session4);
		em.persist(session5);
		//Termine der Veranstaltung hinzufügen
		event1.addSessions(session1);
		event1.addSessions(session2);
		event1.addSessions(session3);
		event1.addSessions(session4);
		event1.addSessions(session5);
		em.persist(event1);
		logger.info("Veranstaltung:"+event1.getId()+". "+event1.getName()+" mit "+ event1.getSessions().size()+" Termin angelegt"+event1.getDateEnd());
		
	}
		
}





