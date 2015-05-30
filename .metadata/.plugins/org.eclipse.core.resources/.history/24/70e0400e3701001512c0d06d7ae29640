package de.management.eventmanagement;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.*;

import org.jboss.logging.Logger;

import de.management.dao.EventManagementDAOLocal;



@WebService
@Stateless
public class ManagementWebService {
	
	private static final Logger logger = Logger.getLogger(WebService.class);
	
	// Datenverarbeitung Bereitstellung 
	@EJB(beanName = "EventManagementDAO", beanInterface = de.management.dao.EventManagementDAOLocal.class)
	private EventManagementDAOLocal dao;
	
	
	// DataTransferObject 
	//@EJB
	//private DtoAssembler dtoAssembler;
	
	
	// Connection Test
	public Integer hasConnection() {
		logger.info ("Client-Connection");
		return 200;
	}

}
