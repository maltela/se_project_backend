package de.management.dao;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.management.entities.User;

@Startup
@Singleton
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
		logger.info(userdb.getName());
		
	
	}
			
	
		
	}





