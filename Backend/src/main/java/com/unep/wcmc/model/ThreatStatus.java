package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ThreatStatus implements Serializable {

    @ManyToOne
    @JoinColumn(name = "threat_category_id")
    private ThreatCategory category;

    @Column(name = "uf_state")
    private String ufState;

    @Column(name = "municipality")
    private String municipality;

    @Column(name = "local")
    private String local;

    @Column(name = "period")
    private Long period;

    @Column(name = "time")
    private Long time;

    @Column(name = "trend")
    private String trend;

    public String getUfState() {
        return ufState;
    }

    public void setUfState(String ufState) {
        this.ufState = ufState;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public ThreatCategory getCategory() {
        return category;
    }

    public void setCategory(ThreatCategory category) {
        this.category = category;
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
