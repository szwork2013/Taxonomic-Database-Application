package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SpecificActionUC implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conservationUnit;

    private String specificAction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConservationUnit() {
        return conservationUnit;
    }

    public void setConservationUnit(String conservationUnit) {
        this.conservationUnit = conservationUnit;
    }

    public String getSpecificAction() {
        return specificAction;
    }

    public void setSpecificAction(String specificAction) {
        this.specificAction = specificAction;
    }
}
