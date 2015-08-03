package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class Hierarchy implements Serializable {

    @ManyToOne
    @JoinColumn(name = "kingdom_id")
    private Kingdom kingdom;

    @ManyToOne
    @JoinColumn(name = "phylum_id")
    private Phylum phylum;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private HierarchyClass hierarchyClass;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private HierarchyOrder order;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @ManyToOne
    @JoinColumn(name = "genus_id")
    private Genus genus;

    @Column(name = "species")
    private String species;

    @Column(name = "subspecies")
    private String subSpecies;
    
    @Column(name = "species_epiteth")
    private String speciesEpiteth;

    public Hierarchy() {
        super();
    }

    public Hierarchy(Kingdom kingdom, Phylum phylum, HierarchyClass hierarchyClass, HierarchyOrder order,
                     Family family, Genus genus, String species, String subSpecies) {
        this.init(kingdom, phylum, hierarchyClass, order, family, genus, species, subSpecies);
    }

    public void init(Kingdom kingdom, Phylum phylum, HierarchyClass hierarchyClass, HierarchyOrder order,
                     Family family, Genus genus, String species, String subSpecies) {
        this.kingdom = kingdom;
        this.phylum = phylum;
        this.hierarchyClass = hierarchyClass;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.subSpecies = subSpecies;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
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

    public HierarchyOrder getOrder() {
        return order;
    }

    public void setOrder(HierarchyOrder order) {
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

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }

	public String getSpeciesEpiteth() {
		return speciesEpiteth;
	}

	public void setSpeciesEpiteth(String speciesEpiteth) {
		this.speciesEpiteth = speciesEpiteth;
	}
}
