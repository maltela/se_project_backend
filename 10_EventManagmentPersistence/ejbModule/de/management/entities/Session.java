package de.management.entities;
import javax.persistence.*;

import de.management.exceptions.ParamMissingException;
import de.management.interfaces.InterSession;

import java.io.Serializable;
import java.util.Date;




/**
 * ----------------
 * Termin-Objekt
 * ----------------
* Zur Verwaltung von Terminen einer Veranstaltung 
* @author Malte Lange 
 */

@Entity 
public class Session implements Serializable,InterSession {
	

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Integer id;
	private String name;
	private Date dateStart;
	private Date dateEnd;
	private String location;
	private String plz;
	private String description;
	
	
	
	/*
	 *  Konstruktor 
	 */
	
	public Session()
	{
		super();
	}
	
	public Session(String Name,Date UhrzeitStart,Date UhrzeitEnde,String Location,String PLZ,String Beschreibung )
	{
		this.name=Name;
		this.dateStart=UhrzeitStart;
		this.dateEnd=UhrzeitEnde;
		this.location=Location;
		this.plz=PLZ;
		this.description=Beschreibung;
				
	}




	@Override
	public Integer getSessionID() {
		
		return id;
	}

	@Override
	public void setId(Integer id) throws ParamMissingException {
		this.id=id;
		
	}
	@Override
	public String getName() {
		
		return name;
	}
	@Override
	public void setName(String name) throws ParamMissingException {
		this.name=name;
		
	}
	@Override
	public Date getDateStart() {
		
		return dateStart;
	}
	@Override
	public void setDateStart(Date dateStart) throws ParamMissingException {
		this.dateStart=dateStart;
		
	}
	@Override
	public Date getDateEnd() {
		
		return dateEnd;
	}
	@Override
	public void setDateEnd(Date dateEnd) throws ParamMissingException {
	   this.dateEnd = dateEnd;
		
	}
	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	@Override
	public void setLocation(String location) throws ParamMissingException {
		this.location = location;
		
	}
	@Override
	public String getDescription() {
		
		return description;
	}
	@Override
	public void setDescription(String description) throws ParamMissingException{
		this.description=description;
		
	}
	@Override
	public String getPlz() {
		
		return plz;
	}
	@Override
	public void setPlz(String plz) throws ParamMissingException {
		this.plz=plz;
		
	}
	
}
