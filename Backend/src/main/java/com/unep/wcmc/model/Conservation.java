package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String specificActionsInProtectedAreas;

    private String actionPlans;

    private String researchInProgress;

    private String necessaryResearchForConservation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecificActionsInProtectedAreas() {
        return specificActionsInProtectedAreas;
    }

    public void setSpecificActionsInProtectedAreas(String specificActionsInProtectedAreas) {
        this.specificActionsInProtectedAreas = specificActionsInProtectedAreas;
    }

    public String getActionPlans() {
        return actionPlans;
    }

    public void setActionPlans(String actionPlans) {
        this.actionPlans = actionPlans;
    }

    public String getResearchInProgress() {
        return researchInProgress;
    }

    public void setResearchInProgress(String researchInProgress) {
        this.researchInProgress = researchInProgress;
    }

    public String getNecessaryResearchForConservation() {
        return necessaryResearchForConservation;
    }

    public void setNecessaryResearchForConservation(String necessaryResearchForConservation) {
        this.necessaryResearchForConservation = necessaryResearchForConservation;
    }
}
