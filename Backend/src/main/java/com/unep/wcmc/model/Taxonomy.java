package com.unep.wcmc.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public final class Taxonomy extends TaxonomicEntity {

    @Embedded
    private Hierarchy hierarchy;

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }
}
