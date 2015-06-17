package com.unep.wcmc.model;

import javax.persistence.Entity;

@Entity
public final class Conventions extends TaxonomicEntity {

    private String convention;

    private String conventionOtherRelevantData;

    private String benefitedFromActionPlan;

    private String otherActionsProtectSpecies;

    private String exSituManagement;

    public String getConvention() {
        return convention;
    }

    public void setConvention(String convention) {
        this.convention = convention;
    }

    public String getConventionOtherRelevantData() {
        return conventionOtherRelevantData;
    }

    public void setConventionOtherRelevantData(String conventionOtherRelevantData) {
        this.conventionOtherRelevantData = conventionOtherRelevantData;
    }

    public String getBenefitedFromActionPlan() {
        return benefitedFromActionPlan;
    }

    public void setBenefitedFromActionPlan(String benefitedFromActionPlan) {
        this.benefitedFromActionPlan = benefitedFromActionPlan;
    }

    public String getOtherActionsProtectSpecies() {
        return otherActionsProtectSpecies;
    }

    public void setOtherActionsProtectSpecies(String otherActionsProtectSpecies) {
        this.otherActionsProtectSpecies = otherActionsProtectSpecies;
    }

    public String getExSituManagement() {
        return exSituManagement;
    }

    public void setExSituManagement(String exSituManagement) {
        this.exSituManagement = exSituManagement;
    }
}
