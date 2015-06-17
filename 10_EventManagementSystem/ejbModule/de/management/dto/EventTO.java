package de.management.dto;
/*
 * Veranstaltungs Objekt
 * @author Malte Lange  
 */
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.inject.Typed;
import javax.persistence.*;

import org.jboss.logging.Logger;

import de.management.dao.EventManagementDAO;
import de.management.entities.Session;
import de.management.entities.User;
import de.management.exceptions.ParamMissingException;
import de.management.interfaces.InterEvent;

public class EventTO implements Serializable {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer id;
	    private String name;
	    private Date dateEnd;
	    private Date dateStart;
	    private String description;
		private List<SessionTO> sessions = new ArrayList<SessionTO>(); 
		//private List<UserTO> users = new ArrayList<UserTO>(); 
			
	// Konstruktor  
		
		public EventTO () 
		{	
		}
		
		public EventTO (String Name,String Beschreibung,Date Anfang,Date Ende,List<SessionTO> sessions)
		{
			super();
			this.name=Name;
			this.description=Beschreibung;
			this.dateStart=Anfang;
			this.dateEnd=Ende;
			this.sessions=sessions;
		//	this.users=users;
			
		}

		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Date getDateEnd() {
			
		   return(dateEnd);
		    
		}
		
		public void setDateEnd(Date dateEnd) {
			this.dateEnd = dateEnd;
		}
		public Date getDateStart() {
			return (dateStart);
		}
		public void setDateStart(Date dateStart) {
			this.dateStart = dateStart;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

	
		public List<SessionTO> getSessions() {					
			return sessions;
		}
		

		public void addSessions(SessionTO session) {	
			sessions.add(session);
			
		}
		
		public Integer getEventID() {
			return id;
		}
		
		public void setID(Integer id) throws ParamMissingException {
			this.id = id; 
			
		}
		
		

		public void setSessions(List<SessionTO> dtoList) {
			this.sessions=dtoList;
			
		}

		
		



	}



