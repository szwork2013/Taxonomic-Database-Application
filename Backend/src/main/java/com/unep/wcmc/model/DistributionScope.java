package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DistributionScope {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean occursBrazil;

    private boolean ocurranceProtectedAreas;

    private boolean occurenceBiomes;

    private boolean occurrenceRiverBasins;

    private int otherRelevantAreas;

}
