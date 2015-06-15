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
	
	
	/************************
    * Administration Funktionen
    * @author Jonathan Peters
    */
	
	/** 
	 * 4. Veranstaltung erstellen
	 * @author Jonathan Peters
	 */
	
	   @Override
	   public Integer createEvent(Event event) { //UserID im Event
	           logger.info ("Create Event");
	           em.persist(event);
	           return 200;
	   }
	
	   /** 
		 * 5. Veranstaltung ändern
		 * @author Jonathan Peters
		 */  
	 
	   @Override
	   public Integer updateEvent(Event event) { //Nur Event
	           logger.info ("Update Event");
	           Event tempEvent = this.getEvent(event.getId());
	           if(event.getId() == this.getEvent(event.getId()).getId()){
	                   tempEvent.setId(event.getId());
	                   tempEvent.setName(event.getName());
	                   tempEvent.setDescription(event.getDescription());
	                   tempEvent.setDateStart(event.getDateStart());
	                   tempEvent.setDateEnd(event.getDateEnd());
	                   em.remove(event);
	                   em.persist(tempEvent);                 
	                   return 200;
	           }
	           else{
	                   return 000; //Falsche Rechte
	           }
	   }
	   
	   /** 
		 * 6. Veranstaltung löschen
		 * @author Jonathan Peters
		 */
	   @Override
	   public Integer dropEvent(Integer eventId, Integer userId) { //EventID + UserID
	           logger.info ("Drop Event");
	           Event event = this.getEvent(eventId);
	           if(event.getId() == userId){                       
	                   em.remove(event);
	                   return 200;
	           }
	           else{
	                   return 000; //Falsche Rechte
	           }
	   }
	   
	   /** 
		 * 7. Termin erstellen
		 * @author Jonathan Peters
		 */
	   @Override
	   public Integer createSession(Session session, Integer eventId, Integer userId) { //session + EventID + UserID
	           logger.info ("Create Session");
	           if(userId == this.getEvent(eventId).getId()){
	                   Event tempEvent = this.getEvent(eventId);
	                   tempEvent.addSessions(session);
	                   em.remove(this.getEvent(eventId));
	                   em.persist(tempEvent);
	                   return 200;
	           }
	           else{
	                   return 000; //Falsche Rechte
	           }
	   }
	   
	   /** 
		 * 8. Termin ändern
		 * @author Jonathan Peters
		 */
	   @Override
		public Integer updateSession(Session session, Integer userID) {
			// TODO Auto-generated method stub
			return null;
		}
	   
	   /** 
		 * 9. Termin löschen
		 * @author Jonathan Peters
		 */
	   @Override
	   public Integer dropSession(Integer sessionId, Integer eventId, Integer userId) { //SessionID + EventID
	           logger.info("Drop Session");
	           if(userId == this.getEvent(eventId).getId()){
	                   Event tempEvent = this.getEvent(eventId);
	                   ArrayList<Session> sessions = tempEvent.getSessions();
	                   for(Session s : sessions){
	                           if(s.getSessionID() == sessionId){
	                                   sessions.remove(sessions.indexOf(s));
	                           }
	                   }
	                   em.remove(this.getEvent(eventId));
	                   em.persist(tempEvent);
	                   return 200;
	           }
	           else{
	                   return 000; //Falsche Rechte
	           }
	   }
	
	
	
		
}
