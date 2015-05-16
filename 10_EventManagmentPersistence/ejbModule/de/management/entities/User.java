package de.management.entities;
import javax.persistence.*;

@Entity 
public class User {
	
	@Id @GeneratedValue 
	private Integer Nr;
	private String Name;
	@OneToMany
	private Event  event;
	private String Rolle;
	
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
	
	

	public String getRolle() {
		return Rolle;
	}

	public void setRolle(String rolle) {
		Rolle = rolle;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
