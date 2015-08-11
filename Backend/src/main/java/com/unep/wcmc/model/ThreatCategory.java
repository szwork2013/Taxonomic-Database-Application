package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class ThreatCategory implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "custom")
    private Boolean custom;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "parent_id")
    private ThreatCategory threatCategoryParent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThreatCategory getParent() {
        return threatCategoryParent;
    }

    public void setParent(ThreatCategory parent) {
        this.threatCategoryParent = parent;
    }

    public Boolean isCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }
}
