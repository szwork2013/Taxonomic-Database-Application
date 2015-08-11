package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Research implements Serializable {

    private String project;

    private String responsibleResearcher;

    private String institution;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getResponsibleResearcher() {
        return responsibleResearcher;
    }

    public void setResponsibleResearcher(String responsibleResearcher) {
        this.responsibleResearcher = responsibleResearcher;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
