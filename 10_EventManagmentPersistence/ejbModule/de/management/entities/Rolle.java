package de.management.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * --------------
 * Rollen-Objekt
 * --------------
 * Zur Verwaltung/Differenzierung von Benutzern und Veranstaltern werden Rollen definiert  
 * @author Malte Lange 
 */

@Entity
public class Rolle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer ID;
	private String  Name;
	
	
	public Rolle (){
		super();
	}
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
