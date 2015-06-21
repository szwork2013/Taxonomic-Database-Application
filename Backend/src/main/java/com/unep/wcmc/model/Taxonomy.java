package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class Taxonomy implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Hierarchy hierarchy;

    @Column(name = "limitations_for_assessment")
    private Boolean limitationsForAssessment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Boolean getLimitationsForAssessment() {
        return limitationsForAssessment;
    }

    public void setLimitationsForAssessment(Boolean limitationsForAssessment) {
        this.limitationsForAssessment = limitationsForAssessment;
    }
}
