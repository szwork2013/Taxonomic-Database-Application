package com.unep.wcmc.model;

import javax.persistence.Entity;

@Entity
public final class DistributionScope extends TaxonomicEntity {

    private boolean occursBrazil;

    private boolean ocurranceProtectedAreas;

    private boolean occurenceBiomes;

    private boolean occurrenceRiverBasins;

    private int otherRelevantAreas;

}
