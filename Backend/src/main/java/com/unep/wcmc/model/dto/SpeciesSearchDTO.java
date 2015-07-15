package com.unep.wcmc.model.dto;


import java.io.Serializable;

public class SpeciesSearchDTO implements Serializable {

    // Species fields
    private Long id;
    private String commonName = "null";
    private String scientificName = "null";

    // Class fields
    private String hierarchyClassName = "null";

    // Family fields
    private String familyName = "null";

    // etc...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getHierarchyClassName() {
        return hierarchyClassName;
    }

    public void setHierarchyClassName(String hierarchyClassName) {
        this.hierarchyClassName = hierarchyClassName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
