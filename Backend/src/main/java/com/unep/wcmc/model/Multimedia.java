package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class Multimedia extends TaxonomicEntity {

    @Column
    private String legend;
    @Column
    private String author;
    @Column
    private Date date;
    @Column
    private String site;
    @Column
    private byte[] file;
}
