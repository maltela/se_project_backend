package de.management.dao;

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
	
	//TODO USE-CASES DEFINIEREN 
	
	// Connection Test
	public boolean hasConnection()
	{
		return(true);
	}
	// Ausgabe aller Events 
	public List<String> getEvents()
	{
		Query query = em.createQuery("Select name from Event");
		return  (List<String>) query.getResultList();
	}
	
	// Ausgabe Sessions eines Events 
	public List<String> getSessions(Event event)
	{
		return (List<String>) em.find(Session.class,event);
	}
	
	@Override
	public User createUser(String username, Event event, String rolle) {
		User user = new User();
		user.setName(username);
		user.setEvent(event);
		user.setRolle(rolle);
		em.persist(user);
		return user;
	}
	
	/*
	public Veranstaltung findCustomerByName(String userName){
		return em.find(Customer.class, userName);
	}
	
	public Account findAccountById(int id) {
		return em.find(Account.class, id);
	}
	
	public XbankSession findSessionById(int id) {
		return em.find(XbankSession.class, id);
	}
	
	public int createSession(Customer user) {
		XbankSession newSession = new XbankSession(user);
		em.persist(newSession);
		return newSession.getId();
	}

	public void closeSession(int id) {
		XbankSession session = em.find(XbankSession.class, id);
		em.remove(session);
	}
	*/
	
}
