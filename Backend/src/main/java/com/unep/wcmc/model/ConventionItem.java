package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ConventionItem implements Serializable {

    private String name;

    private Integer year;

    private String observation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
