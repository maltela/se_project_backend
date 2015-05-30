package de.management.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity 
public class User {
	
	@Id @GeneratedValue 
	private Integer Nr;
	private String Name;
	private String DeviceID;
	
	@ManyToMany
	private Set<Event> events = new HashSet<Event>();
	@OneToMany
	private Set<Rolle> rollen = new HashSet<Rolle>();
	
	public User()
	
	
	{
		// DB generiert eindeutige Nr.
	}

	public Integer getNr() {
		return Nr;
	}

	public void setNr(Integer nr) {
		Nr = nr;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	

	public String getDeviceID() {
		return DeviceID;
	}

	public void setDeviceID(String deviceID) {
		DeviceID = deviceID;
	}

	

}
