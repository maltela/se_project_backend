package de.management.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import de.management.entities.*;

@Stateless
/** 
 * Persistierung-Methoden 
 * @author Malte Lange 
 *
 */
public class EventManagementDAO implements EventManagementDAOLocal {
	private static final Logger logger = Logger.getLogger(EventManagementDAO.class);
	
	@PersistenceContext
	private EntityManager em;
	
	/** 
	 * 1. Benutzer anlegen 
	 * @author Malte Lange 
	 */
	@Override
	public Integer createUser(String username, String deviceID) {
		User user = new User(username, deviceID);
		em.persist(user);
		logger.info("User"+username+" anlegen");
		
		if (em.contains(user))
		{
			return user.getUserID();
		}	
		else 
		{
			return 501;
		}
	}
	/**
	 * 2. Übersicht aller verfügbaren Events 
	 * @author  Malte Lange 
	 */
	@Override
	
	public List<Event> getEventOverview() {
		logger.info("Ausgabe der Event-Übersicht");
		Query query = em.createQuery("select e from Event e ");
		@SuppressWarnings("unchecked")
		List<Event> list = (List<Event>) query.getResultList();
		Event test = list.get(2);
		test.getName();
		logger.info(test.getName()+" "+test.getDescription());
	//	Event[] dataArray = new Event[list.size()];
	//	list.toArray(dataArray);
		return list;
	}
	
	/** 
	 * 3. Informationen einer Veranstaltung 
	 * @author Malte Lange 
	 */
	
	@Override
	public Event getEvent(Integer id) {
		logger.info ("Get Event ");
		return (em.find(Event.class,id));
		
	}
	
	/**
	 *  4. Push-Nachricht erstellen
	 *  @author Malte Lange 
	 */
	@Override
	public Integer createPush(String msg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/************************
	 * Adminstration Funktionen
	 */
	@Override
	public Integer createEvent(Event event, Integer UserID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer createSession(Session session, Integer UserID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer updateEvent(Event event, Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer updateSession(Session session, Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer dropEvent(Integer eventID, Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer dropSession(Integer sessionID, Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}


	
		
}
