package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public final class Family extends TaxonomicEntity {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
