package de.management.entities;
import javax.persistence.*;


@Entity 
public class Ort {
	
	@Id
	private Integer Koordinate;
	private String Straße;
	private String Stadt;
	private String Land;
	private String Bezeichnung;
	private String URL;
	
	
// Konstruktor 
	
	public Ort (String Bezeichnung,String Straße,String Stadt,String Land,Integer Koordinate,String URL)
	{
		this.Bezeichnung=Bezeichnung;
		this.Straße=Straße;
		this.Stadt=Stadt;
		this.Land=Land;
		this.Koordinate=Koordinate;
		this.setURL(URL);
		
	}
	
	
	
// Getter / Setter Methoden
	
	public Integer getKoordinate() {
		return Koordinate;
	}
	public void setKoordinate(Integer koordinate) {
		Koordinate = koordinate;
	}
	public String getStraße() {
		return Straße;
	}
	public void setStraße(String straße) {
		Straße = straße;
	}
	public String getStadt() {
		return Stadt;
	}
	public void setStadt(String stadt) {
		Stadt = stadt;
	}
	public String getLand() {
		return Land;
	}
	public void setLand(String land) {
		Land = land;
	}
	public String getBezeichnung() {
		return Bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		Bezeichnung = bezeichnung;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	

}
