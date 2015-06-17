package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Hierarchy {

    @Column
    private String kingdom;

    @ManyToOne
    @JoinColumn(name="phylum_id")
    private Phylum phylum;

    @ManyToOne
    @JoinColumn(name="class_id")
    private HierarchyClass hierarchyClass;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="family_id")
    private Family family;

    @ManyToOne
    @JoinColumn(name="specie_id")
    private Specie specie;

    @ManyToOne
    @JoinColumn(name="genus_id")
    private Genus genus;
}
