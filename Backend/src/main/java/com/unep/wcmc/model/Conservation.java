package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Conservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private ExtinctionRisk extinctionRisk;

    @Embedded
    private Conventions conventions;

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
