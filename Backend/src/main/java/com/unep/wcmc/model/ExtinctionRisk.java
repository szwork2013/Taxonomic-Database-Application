package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExtinctionRisk implements Serializable {

    private Boolean nationalEvaluationElegible;

    private String changeReasons;

    private String specificActionsInProtectedAreas;

    private String actionPlans;

    private String researchInProgress;

    private String necessaryResearchForConservation;

    @Column(name = "in_national_endangered_fauna")
    private Boolean inNationalEndangeredFauna;

    @Column(name = "presence_in_other_endangered_lists")
    private Boolean presenceInOtherEndangeredLists;

    public Boolean getNationalEvaluationElegible() {
        return nationalEvaluationElegible;
    }

    public void setNationalEvaluationElegible(Boolean nationalEvaluationElegible) {
        this.nationalEvaluationElegible = nationalEvaluationElegible;
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

    public Boolean getInNationalEndangeredFauna() {
        return inNationalEndangeredFauna;
    }

    public void setInNationalEndangeredFauna(Boolean inNationalEndangeredFauna) {
        this.inNationalEndangeredFauna = inNationalEndangeredFauna;
    }

    public Boolean getPresenceInOtherEndangeredLists() {
        return presenceInOtherEndangeredLists;
    }

    public void setPresenceInOtherEndangeredLists(Boolean presenceInOtherEndangeredLists) {
        this.presenceInOtherEndangeredLists = presenceInOtherEndangeredLists;
    }
}
