package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class ThreatStatus implements Serializable {

    @Enumerated(value = EnumType.ORDINAL)
    private ThreatCategory category;

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
