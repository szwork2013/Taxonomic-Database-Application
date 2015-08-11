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

    @Column(name = "subspecies")
    private String subspecies;
    
    @Column(name = "species_epiteth")
    private String speciesEpiteth;

    @Column(name = "author_year")
    private String authorYear;

    public Hierarchy() {
        super();
    }

    public Hierarchy(Kingdom kingdom, Phylum phylum, HierarchyClass hierarchyClass, HierarchyOrder order,
                     Family family, Genus genus, String subspecies) {
        this.init(kingdom, phylum, hierarchyClass, order, family, genus, subspecies, null);
    }

    public Hierarchy(Kingdom kingdom, Phylum phylum, HierarchyClass hierarchyClass, HierarchyOrder order,
                     Family family, Genus genus, String subspecies, String speciesEpiteth) {
        this.init(kingdom, phylum, hierarchyClass, order, family, genus, subspecies, speciesEpiteth);
    }

    public void init(Kingdom kingdom, Phylum phylum, HierarchyClass hierarchyClass, HierarchyOrder order,
                     Family family, Genus genus, String subspecies, String speciesEpiteth) {
        this.kingdom = kingdom;
        this.phylum = phylum;
        this.hierarchyClass = hierarchyClass;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.subspecies = subspecies;
        this.speciesEpiteth = speciesEpiteth;
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

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
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

    public String getAuthorYear() {
        return authorYear;
    }

    public void setAuthorYear(String authorYear) {
        this.authorYear = authorYear;
    }
}
