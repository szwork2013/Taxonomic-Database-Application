package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Taxonomy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String scientificName;
    private Integer speciesId;
    private Integer speciesPlusId;
    private Hierarchy hierarchy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Integer speciesId) {
        this.speciesId = speciesId;
    }

    public Integer getSpeciesPlusId() {
        return speciesPlusId;
    }

    public void setSpeciesPlusId(Integer speciesPlusId) {
        this.speciesPlusId = speciesPlusId;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }
}
