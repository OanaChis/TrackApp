package com.TrackApp.TrackApp.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oana_ on 6/14/2017.
 */

@Entity
public class Project extends AbstractDomain{

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String typeOfProject;



    private double totalDuration;

    @OneToMany  (cascade = CascadeType.ALL, mappedBy = "project", orphanRemoval = true)
    private List<Session> sessions = new ArrayList<>();

    @ManyToOne
    private Customer customer;



   // to do, implement add , remove session in project , to check

    public void addSession(Session session) {
        session.setProject(this);
        sessions.add(session);
    }

    public void removeSession(Session session) {

        if (session.getDuration() == 0) {

        sessions.remove(session);

        }
    }


    // to do calculate total duration per project


    public void calculateTotalDuration(){

        if (getSessions().isEmpty()){
            totalDuration = 0.0;
        }

        if (!getSessions().isEmpty()){
            for (Session session: getSessions()) {
                totalDuration += session.getDuration();
            }
        }
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfProject() {
        return typeOfProject;
    }

    public void setTypeOfProject(String typeOfProject) {
        this.typeOfProject = typeOfProject;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}
