package de.management.dto;

import javax.persistence.*;

import de.management.exceptions.ParamMissingException;
import de.management.interfaces.InterSession;

import java.io.Serializable;
import java.util.Date;

public class SessionTO implements Serializable,InterSession{
		
		/**
		 * Termin-Objekt
		 * @author Malte Lange 
		 */
		private static final long serialVersionUID = 1L;
		
		
		private Integer id;
		private String name;
		private Date dateStart;
		private Date dateEnd;
		private String location;
		private String plz;
		private String description;
		
		
		
	// Konstruktor 
		
		public SessionTO()
		{
		
		}
		
		public SessionTO(Integer ID,String Name,Date UhrzeitStart,Date UhrzeitEnde,String Ort,String PLZ,String Beschreibung )
		{
			super();
			this.id=ID;
			this.name=Name;
			this.dateStart=UhrzeitStart;
			this.dateEnd=UhrzeitEnde;
			this.location=Ort;
			this.plz=PLZ;
			this.description=Beschreibung;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setDateStart(Date dateStart) {
			this.dateStart = dateStart;
		}

		public void setDateEnd(Date dateEnd) {
			this.dateEnd = dateEnd;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public void setPlz(String plz) {
			this.plz = plz;
		}

		public void setDescription(String description) {
			this.description = description;
		}


		public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public Date getDateStart() {
			return dateStart;
		}

		public Date getDateEnd() {
			return dateEnd;
		}

		public String getLocation() {
			return location;
		}

		public String getPlz() {
			return plz;
		}

		public String getDescription() {
			return description;
		}

		@Override
		public Integer getSessionID() {
			// TODO Auto-generated method stub
			return null;
		}


		



}
