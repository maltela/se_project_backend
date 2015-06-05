package de.management.dao;

import java.util.HashMap;
import java.util.List;

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
	public HashMap<Integer, String> getEvents()
	{
		Query query = em.createQuery("Select name from Event");
		return (HashMap<Integer, String>) query.getResultList();
	}
	
	// Ausgabe Sessions eines Events 
	@SuppressWarnings("unchecked")
	public List<String> getSessions(Event event)
	{
		return (List<String>) em.find(Session.class,event);
	}
	
	@Override
	public Integer createUser(String username, String deviceID) {
		User user = new User();
		user.setName(username);
		user.setDeviceID(deviceID);
		em.persist(user);
		if (em.contains(user))
		{
			return 200;
		}	
		else 
		{
			return 501;
		}
	}
	@Override
	public HashMap<Integer, String> getEvents(Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Event getEvent(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Session> getSessions(Integer eventID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Event joinEvent(Integer eventID, Integer userID) {
		// TODO Auto-generated method stub
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
