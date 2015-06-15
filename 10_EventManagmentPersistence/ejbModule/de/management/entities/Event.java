package de.management.entities;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.enterprise.inject.Typed;
import javax.persistence.*;

import de.management.exceptions.ParamMissingException;
import de.management.interfaces.InterEvent;
@Entity
public class Event implements Serializable,InterEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
    private Integer id;
    private String name;
    
    private Date dateEnd;
  
    private Date dateStart;
    private String description;
 
	
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Session> sessions = new ArrayList<Session>();
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<User> users = new HashSet<User>();
		
	

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
	public Integer getEventID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setID(Integer id) 	 {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Session> getSessions() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setSessions(ArrayList<Session> sessions) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addSessions(Session session) {
		// TODO Auto-generated method stub
		
	}
	



}
