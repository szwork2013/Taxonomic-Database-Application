package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PopulationSize implements Serializable {

    @Column(name = "local")
    private String local;

    @Column(name = "abundance")
    private Integer abundance;

    @Column(name = "unit")
    private String unit;

    @Column(name = "reference")
    private String reference;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getAbundance() {
        return abundance;
    }

    public void setAbundance(Integer abundance) {
        this.abundance = abundance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
