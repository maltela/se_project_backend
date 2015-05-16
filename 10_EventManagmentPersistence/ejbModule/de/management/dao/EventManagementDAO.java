package de.management.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import de.management.entities.*;

@Stateless
public class EventManagementDAO implements EventManagementDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	//TODO USE-CASES DEFINIEREN 
	
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
