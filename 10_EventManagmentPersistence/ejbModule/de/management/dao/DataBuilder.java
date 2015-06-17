package de.management.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import de.management.entities.Event;
import de.management.entities.User;

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
	private void init() {
		User user1 = new User("USer1","23432");	
		em.persist(user1);
		logger.info("User angelegt:");
		User userdb = em.find(User.class,1);
		logger.info(userdb.getName()+ " "+userdb.getUserID());
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
         simpleDateFormat.setLenient(false);
         Date date = null;
		try {
			date = simpleDateFormat.parse("01/08/2015");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		de.management.entities.Event event1 = new de.management.entities.Event ("Majom-Event1","Intialisierungs-Veranstaltung",date,date);
		de.management.entities.Event event2 = new de.management.entities.Event ("Majom-Event2","Intialisierungs-Veranstaltung",date,date);
		de.management.entities.Event event3 = new de.management.entities.Event ("Majom-Event3","Intialisierungs-Veranstaltung",date,date);
		em.persist(event1);
		em.persist(event2);
		em.persist(event3);
		de.management.entities.Session session1 = new de.management.entities.Session("Session1",date,date,"FHZ","Test");
		em.persist(session1);
		logger.info(session1.getName());
		logger.info("Ausgabe Event: "+event1.getName());
		event1.addSessions(session1);
		em.persist(event1);
		logger.info(event1.getName());
		logger.info(event1.getSessions().size());
		logger.info(event1.getSessions().get(0).getName());
		
		Query querytest = em.createQuery("Select e from Event e where e.name ='Majom-Event1'");
		de.management.entities.Event e = (de.management.entities.Event)querytest.getSingleResult();
		logger.info(e.getName()+" "+ e.getEventID());
		
		Query query3 = em.createQuery("select e from Event e ");
		
		@SuppressWarnings("unchecked")
		ArrayList<Event> list = (ArrayList<Event>) query3.getResultList();
		logger.info(list.get(0)+","+list.get(1)+","+list.get(2));
		
		
	}
			
	
		
	}





