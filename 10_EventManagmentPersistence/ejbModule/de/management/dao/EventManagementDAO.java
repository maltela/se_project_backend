package de.management.dao;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.management.entities.*;

@Stateless
public class EventManagementDAO implements EventManagementDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	// Ausgabe aller Events 
	@SuppressWarnings("unchecked")
	public ArrayList<String> getEvents()
	{
		Query query = em.createQuery("Select name from Event");
		return (ArrayList<String>) query.getResultList();
	}
	
	// Ausgabe Sessions eines Events 
	@SuppressWarnings("unchecked")
	public ArrayList<Session> getSessions(Event event)
	{
		Query query = em.createQuery("select e from Session e ");
		ArrayList<Session> list = (ArrayList<Session>) query.getResultList();
		return (list);
	}
	
	@Override
	public Integer createUser(String username, String deviceID) {
		User user = new User(username, deviceID);
		em.persist(user);
		if (em.contains(user))
		{
			return user.getUserID();
		}	
		else 
		{
			return 501;
		}
	}
	@Override
	public ArrayList<Event> getEvents(Integer userID) {
		Query query = em.createQuery("select e from Event e join e.Users u where e.ID = :param ");
		query.setParameter("param",userID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Event> list = (ArrayList<Event>) query.getResultList();
		return list;
	}
	@Override
	public Event getEvent(Integer id) {
		
		return null;
	}
	
	@Override
	public Integer createPush() {
		// TODO Auto-generated method stub
		return null;
	}
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
