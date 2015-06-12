package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class Image extends Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private byte[] coverImage;
}
