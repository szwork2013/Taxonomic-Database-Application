package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Threats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String populationAffected;

    private String affectedArea;

    private String descriptionImpact;

    private String fishingScale;

    private String fishingGrounds;

    private String fishingPetrecho;

    private String fishingEffort;

    private String landingCatch;

    private String cpue;

    private String marketValue;

    private String fishingTrend;

    private String speciesResillience;

    private ThreatStatus threatStatus;
}
