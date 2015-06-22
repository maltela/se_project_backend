package de.management.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import org.jboss.logging.Logger;




/**
 * ---------------------
 * Benutzer-Objekt
 * ---------------------
 * Bereitstellung von Benutzer-Informationen 
 * @author Malte Lange 
 */

@Entity 
public class User implements Serializable {
	private static final Logger logger = Logger.getLogger(User.class);
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue 
	private Integer id;
	private String name;
	private String deviceID;
	
    @ManyToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	private	Collection<Event> events = new HashSet<Event>();
	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	private Collection<Rolle> rollen = new HashSet<Rolle>();
	
	
	public User()
	{
		super();
	}
	public User(String Name,String DeviceID )
	{
		logger.info("User wird angelegt");	
		this.name=Name;
		this.deviceID=DeviceID;
		
	}

	public Integer getUserID() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String Name) {
		name = Name;
	}
	

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String DeviceID) {
		deviceID = DeviceID;
	}

	

}
