package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class Hierarchy implements Serializable {

    @Column(name = "kingdom")
    private String kingdom;

    @ManyToOne
    @JoinColumn(name = "phylum_id")
    private Phylum phylum;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private HierarchyClass hierarchyClass;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @Column(name = "species")
    private String species;

    @Column(name = "subspecies")
    private String subSpecies;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public Phylum getPhylum() {
        return phylum;
    }

    public void setPhylum(Phylum phylum) {
        this.phylum = phylum;
    }

    public HierarchyClass getHierarchyClass() {
        return hierarchyClass;
    }

    public void setHierarchyClass(HierarchyClass hierarchyClass) {
        this.hierarchyClass = hierarchyClass;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSubSpecies() {
        return subSpecies;
    }

    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
