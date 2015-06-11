package de.management.interfaces;

import java.util.Date;

import de.management.exceptions.ParamMissingException;

public interface InterSession {
    //private Integer id;
    //private String name;
    //private Date dateStart;
    //private Date dateEnd;
    //private String location;
    //private String plz;
    //private String description;

    public Integer getSessionID();
    public void setId(Integer id) throws ParamMissingException;
    public String getName();
    public void setName(String name)throws ParamMissingException;
    @Override
    public String toString();
    public Date getDateStart();
    public void setDateStart(Date dateStart)throws ParamMissingException;
    public Date getDateEnd();
    public void setDateEnd(Date dateEnd)throws ParamMissingException;
    public String getLocation();
    public void setLocation(String location) throws ParamMissingException;

    public String getDescription();
    public void setDescription(String description);
    public String getPlz();
    public void setPlz(String plz);
}
