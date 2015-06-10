package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DensityData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer subpopulationsNumber;

    private String subpopulationsTrend;

    private Integer subpopulationsDecline;

    private Float subpopulationsFluctuations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
