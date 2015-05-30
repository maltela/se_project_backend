package de.management.entities;
import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity 
public class Session implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Integer Nr;
	private String Name;
	private Date UhrzeitStart;
	private Date UhrzeitEnde;
	private String Ort;
	private String Beschreibung;
	
	
	
	
// Konstruktor 
	
	public Session(String Name,Date UhrzeitStart,Date UhrzeitEnde,String Ort,String Beschreibung )
	{
		this.Name=Name;
		this.UhrzeitStart=UhrzeitStart;
		this.UhrzeitEnde=UhrzeitEnde;
//TODO		this.Ort=cast(Ort); - Beziehung zwischen Ort und Event herstellen 
		this.Beschreibung=Beschreibung;
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

	public Date getUhrzeitStart() {
		return UhrzeitStart;
	}

	public void setUhrzeitStart(Date uhrzeitStart) {
		UhrzeitStart = uhrzeitStart;
	}

	public Date getUhrzeitEnde() {
		return UhrzeitEnde;
	}

	public void setUhrzeitEnde(Date uhrzeitEnde) {
		UhrzeitEnde = uhrzeitEnde;
	}

	public String getOrt() {
		return Ort;
	}

	public void setOrt(String ort) {
		Ort = ort;
	}

	public String getBeschreibung() {
		return Beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
	
	
	
	
//	Getter / Setter Methoden 
	
}
