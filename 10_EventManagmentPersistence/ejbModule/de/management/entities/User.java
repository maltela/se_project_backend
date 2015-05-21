package de.management.entities;
import javax.persistence.*;

@Entity 
public class User {
	
	@Id @GeneratedValue 
	private Integer Nr;
	private String Name;
	private String DeviseID;
	@OneToMany
	private Event  event;
	private Rolle rolle;
	
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
	

	public String getDeviseID() {
		return DeviseID;
	}

	public void setDeviseID(String deviseID) {
		DeviseID = deviseID;
	}

	public Rolle getRolle() {
		return rolle;
	}

	public void setRolle(Rolle rolle) {
		this.rolle = rolle;
	}

}
