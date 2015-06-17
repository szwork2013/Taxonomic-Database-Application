package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public final class ThreatStatus extends TaxonomicEntity {

    @Column
    private String description;
    @Column
    private String municipality;
    @Column
    private String threat;
    @Column
    private String local;
    @Column
    private Long period;
    @Column
    private Long time;
    @Column
    private String trend;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getThreat() {
        return threat;
    }

    public void setThreat(String threat) {
        this.threat = threat;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }
}
