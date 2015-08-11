package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class NationalActionPlan implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    private String responsible;

    @Column(name = "implementation_level")
    private String implementationLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getImplementationLevel() {
        return implementationLevel;
    }

    public void setImplementationLevel(String implementationLevel) {
        this.implementationLevel = implementationLevel;
    }
}
