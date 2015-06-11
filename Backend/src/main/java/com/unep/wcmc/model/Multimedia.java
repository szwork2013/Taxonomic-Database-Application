package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
