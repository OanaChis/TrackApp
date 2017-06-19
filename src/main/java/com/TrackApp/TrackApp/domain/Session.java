package com.TrackApp.TrackApp.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by oana_ on 6/14/2017.
 */

@Entity
public class Session extends AbstractDomain {


    private double duration;


    @ManyToOne
    private Project project;


    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
