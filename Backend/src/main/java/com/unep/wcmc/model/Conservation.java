package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class Conservation implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private ExtinctionRisk extinctionRisk;

    @Embedded
    private Conventions conventions;

    @Embedded
    private ConservationAction conservationAction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExtinctionRisk getExtinctionRisk() {
        return extinctionRisk;
    }

    public void setExtinctionRisk(ExtinctionRisk extinctionRisk) {
        this.extinctionRisk = extinctionRisk;
    }

    public Conventions getConventions() {
        return conventions;
    }

    public void setConventions(Conventions conventions) {
        this.conventions = conventions;
    }

}