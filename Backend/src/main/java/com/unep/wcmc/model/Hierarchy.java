package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class Hierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String kingdomName;

    @Column
    private Phylum phylum;

    @Column
    private String className;

    @Column
    private Order order;

    @Column
    private Family family;

    @Column
    private Genus genus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
