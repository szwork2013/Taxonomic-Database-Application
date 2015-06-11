package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class Hierarchy {

    @Column
    private String kingdom;

    @Column
    private Phylum phylum;

    @Column
    private HierarchyClass hierarchyClass;

    @Column
    private Order order;

    @Column
    private Family family;

    @Column
    private Specie specie;

    @Column
    private Genus genus;
}
