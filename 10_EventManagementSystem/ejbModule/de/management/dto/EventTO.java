package de.management.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import de.management.exceptions.ParamMissingException;


	/**
	 *  --------------------------
	 *  Veranstaltungs-Objekt-SOAP
	 *  --------------------------
	 *  @author Malte Lange  
	 */


public class EventTO implements Serializable {

	private static final long serialVersionUID = 1L;
		private Integer id;
	    private String name;
	    private Date dateEnd;
	    private Date dateStart;
	    private String description;
		private List<SessionTO> sessions = new ArrayList<SessionTO>(); 
	
			
	// Konstruktor  
		
		public EventTO () 
		{	
		}
		
		public EventTO (String Name,String Beschreibung,Date Anfang,Date Ende,List<SessionTO> sessions)
		{
			super();
			this.name=Name;
			this.description=Beschreibung;
			this.dateStart=Anfang;
			this.dateEnd=Ende;
			this.sessions=sessions;
		
			
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Date getDateEnd() {
			
		   return(dateEnd);	    
		}
		
		public void setDateEnd(Date dateEnd) {
			this.dateEnd = dateEnd;
		}
		public Date getDateStart() {
			return (dateStart);
		}
		public void setDateStart(Date dateStart) {
			this.dateStart = dateStart;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
		public List<SessionTO> getSessions() {					
			return sessions;
		}
		
		public void addSessions(SessionTO session) {	
			sessions.add(session);
			
		}
		
		public Integer getEventID() {
			return id;
		}
		
		public void setID(Integer id) throws ParamMissingException {
			this.id = id; 
			
		}	

		public void setSessions(List<SessionTO> dtoList) {
			this.sessions=dtoList;
			
		}

	
}



