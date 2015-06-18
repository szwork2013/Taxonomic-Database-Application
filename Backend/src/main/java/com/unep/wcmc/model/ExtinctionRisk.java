package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExtinctionRisk implements Serializable {

    private Boolean nationalEvaluationElegible;

    private String previousNationalAssessment;

    private String changeReasons;

    private String specificActionsInProtectedAreas;

    private String actionPlans;

    private String researchInProgress;

    private String necessaryResearchForConservation;

    public Boolean getNationalEvaluationElegible() {
        return nationalEvaluationElegible;
    }

    public void setNationalEvaluationElegible(Boolean nationalEvaluationElegible) {
        this.nationalEvaluationElegible = nationalEvaluationElegible;
    }

    public String getPreviousNationalAssessment() {
        return previousNationalAssessment;
    }

    public void setPreviousNationalAssessment(String previousNationalAssessment) {
        this.previousNationalAssessment = previousNationalAssessment;
    }

    public String getChangeReasons() {
        return changeReasons;
    }

    public void setChangeReasons(String changeReasons) {
        this.changeReasons = changeReasons;
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
