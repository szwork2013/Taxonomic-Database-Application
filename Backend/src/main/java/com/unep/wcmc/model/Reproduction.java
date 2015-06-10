package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reproduction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int maximumSize;

}
