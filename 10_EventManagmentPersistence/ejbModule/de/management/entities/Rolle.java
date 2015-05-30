package de.management.entities;


import javax.persistence.*;

@Entity
public class Rolle {
	@Id
	@GeneratedValue
	private Integer ID;
	private String  Name;
	
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}


	
	
	

}
