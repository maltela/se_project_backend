package de.management.entities;
import javax.persistence.*;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;

@Entity 
public class Event implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Integer Nr;
	private String Name;
	private Date Datum;
	private Timestamp UhrzeitStart;
	private Timestamp UhrzeitEnde;
	@OneToOne
	private Ort Ort;
	private String Beschreibung;
	
	
	
// Konstruktor 
	
	public Event(String Name,Date Datum,Timestamp UhrzeitStart,Timestamp UhrzeitEnde,String Ort,String Beschreibung )
	{
		this.Name=Name;
		this.Datum=Datum;
		this.UhrzeitStart=UhrzeitStart;
		this.UhrzeitEnde=UhrzeitEnde;
//TODO		this.Ort=cast(Ort); - Beziehung zwischen Ort und Event herstellen 
		this.Beschreibung=Beschreibung;
	}
	
	
	
	
//	Getter / Setter Methoden 
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
	public Date getDatum() {
		return Datum;
	}
	public void setDatum(Date datum) {
		Datum = datum;
	}
	public Timestamp getUhrzeitStart() {
		return UhrzeitStart;
	}
	public void setUhrzeit_Start(Timestamp uhrzeitStart) {
		UhrzeitStart = uhrzeitStart;
	}
	public Timestamp getUhrzeitEnde() {
		return UhrzeitEnde;
	}
	public void setUhrzeitEnde(Timestamp uhrzeitEnde) {
		UhrzeitEnde = uhrzeitEnde;
	}
	public Ort getOrt() {
		return Ort;
	}
	public void setOrt(Ort ort) {
		Ort = ort;
	}
	public String getBeschreibung() {
		return Beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
	

}
