package com.unep.wcmc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TaxonomicEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected long id;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
