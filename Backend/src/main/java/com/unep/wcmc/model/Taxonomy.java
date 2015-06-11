package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class Taxonomy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private Hierarchy hierarchy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }
}
