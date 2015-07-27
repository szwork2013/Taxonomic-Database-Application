package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Taxonomy implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Hierarchy hierarchy;

    @Column(name = "limitations_for_assessment")
    private Boolean limitationsForAssessment;

    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Column(nullable = false)
    private boolean enabled;

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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
