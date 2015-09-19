package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ConventionItem implements Serializable {

    private String name;

    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
