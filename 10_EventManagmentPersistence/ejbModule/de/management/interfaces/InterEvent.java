package de.management.interfaces;

import java.util.ArrayList;
import java.util.Date;

import de.management.entities.Session;
import de.management.exceptions.ParamMissingException;

public interface InterEvent {
    //private Integer id;
    //private String name;
    //private Date dateEnd;
    //private Date dateStart;
    //private String description;
    //private ArrayList<Session> sessions;
    //private Integer userID;


    public Integer getEventID();

    public void setID(Integer id) throws ParamMissingException;

    public String getName();

    public void setName(String name) throws ParamMissingException;
    @Override
    public String toString();

    public Date getDateEnd();
    public void setDateEnd(Date endDate) throws ParamMissingException ;
    public Date getDateStart();

    public void setDateStart(Date startDate) throws ParamMissingException ;

    public String getDescription();

    public void setDescription(String description);
    public ArrayList<Session> getSessions();
    public void setSessions(ArrayList<Session> sessions);
    public void addSessions(Session session);
}