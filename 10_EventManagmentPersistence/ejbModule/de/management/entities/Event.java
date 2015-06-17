package de.management.entities;


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
import de.management.exceptions.ParamMissingException;
import de.management.interfaces.InterEvent;
@Entity
public class Event implements Serializable,InterEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Event.class);
	@Id @GeneratedValue
    private Integer id;
    private String name;
    private Date dateEnd;
    private Date dateStart;
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    
	private List<Session> sessions = new ArrayList<Session>(); 
	@ManyToMany(fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>(); 
		

	

// Konstruktor 
	 
	
	public Event () 
	{
		super();
		
	}
	public Event (String Name,String Beschreibung,Date Anfang,Date Ende)
	{
		
		this.name=Name;
		this.description=Beschreibung;
		this.dateStart=Anfang;
		this.dateEnd=Ende;
		
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

	@Override
	public List<Session> getSessions() {					
		logger.info("Return Sessions");
		return sessions;
	}
	
	@Override
	public void addSessions(Session session) {
		logger.info("Add Session");
		logger.info("Anzahl"+sessions.size());
		
		sessions.add(session);
		logger.info("Anzahl"+sessions.size());
		
		
	}
	
	@Override
	public Integer getEventID() {
	
		return id;
	}
	@Override
	public void setID(Integer id) throws ParamMissingException {
		this.id = id; 
		
	}
	@Override
	public void setSessions(ArrayList<Session> sessions) {
		// TODO Auto-generated method stub
		
	}
	



}
