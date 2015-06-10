package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeedingBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String trophicLevel;

    private String eatingHabits;

    private String expertSpecialist;

    private String feedingAgregations;

    private String eatingHabitsOtherComments;

}
