package de.management.entities;
import javax.persistence.*;

import de.management.exceptions.ParamMissingException;
import de.management.interfaces.InterSession;

import java.io.Serializable;
import java.sql.Date;

@Entity 
public class Session implements Serializable,InterSession {
	
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



	public Integer getNr() {return Nr;}
	public void setNr(Integer nr) {	Nr = nr;}
	public String getName() {		return Name;}	
	public void setName(String name) {		Name = name;	}
	public Date getUhrzeitStart() {		return UhrzeitStart;	}
	public void setUhrzeitStart(Date uhrzeitStart) {	UhrzeitStart = uhrzeitStart;	}
	public Date getUhrzeitEnde() {		return UhrzeitEnde;	}
	public void setUhrzeitEnde(Date uhrzeitEnde) {		UhrzeitEnde = uhrzeitEnde;	}
	public String getOrt() {		return Ort;	}
	public void setOrt(String ort) {		Ort = ort;	}
	public String getBeschreibung() {		return Beschreibung;	}
	public void setBeschreibung(String beschreibung) {		Beschreibung = beschreibung;	}

	@Override
	public Integer getSessionID() {		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Integer id) throws ParamMissingException {
		// TODO Auto-generated method stub		
	}

	@Override
	public java.util.Date getDateStart() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDateStart(java.util.Date dateStart)
			throws ParamMissingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public java.util.Date getDateEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDateEnd(java.util.Date dateEnd) throws ParamMissingException {
		// TODO Auto-generated method stub		
	}

	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocation(String location) throws ParamMissingException {
		// TODO Auto-generated method stub		
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub	
	}
	@Override
	public String getPlz() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setPlz(String plz) {
		// TODO Auto-generated method stub	
	}
	
//	Getter / Setter Methoden 
	
}
