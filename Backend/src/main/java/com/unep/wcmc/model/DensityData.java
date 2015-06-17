package com.unep.wcmc.model;

import javax.persistence.Entity;

@Entity
public final class DensityData extends TaxonomicEntity {

    private Integer subpopulationsNumber;

    private String subpopulationsTrend;

    private Integer subpopulationsDecline;

    private Float subpopulationsFluctuations;

    public Integer getSubpopulationsNumber() {
        return subpopulationsNumber;
    }

    public void setSubpopulationsNumber(Integer subpopulationsNumber) {
        this.subpopulationsNumber = subpopulationsNumber;
    }

    public String getSubpopulationsTrend() {
        return subpopulationsTrend;
    }

    public void setSubpopulationsTrend(String subpopulationsTrend) {
        this.subpopulationsTrend = subpopulationsTrend;
    }

    public Integer getSubpopulationsDecline() {
        return subpopulationsDecline;
    }

    public void setSubpopulationsDecline(Integer subpopulationsDecline) {
        this.subpopulationsDecline = subpopulationsDecline;
    }

    public Float getSubpopulationsFluctuations() {
        return subpopulationsFluctuations;
    }

    public void setSubpopulationsFluctuations(Float subpopulationsFluctuations) {
        this.subpopulationsFluctuations = subpopulationsFluctuations;
    }
}
