package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FeedingBehavior implements Serializable {

    @Column(name = "trophic_level")
    private String trophicLevel;

    @Column(name = "eating_habits")
    private String eatingHabits;

    @Column(name = "expert_specialist")
    private String expertSpecialist;

    @Column(name = "feeding_agregations")
    private String feedingAgregations;

    @Column(name = "eating_habits_other_comments")
    private String eatingHabitsOtherComments;

    public String getTrophicLevel() {
        return trophicLevel;
    }

    public void setTrophicLevel(String trophicLevel) {
        this.trophicLevel = trophicLevel;
    }

    public String getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(String eatingHabits) {
        this.eatingHabits = eatingHabits;
    }

    public String getExpertSpecialist() {
        return expertSpecialist;
    }

    public void setExpertSpecialist(String expertSpecialist) {
        this.expertSpecialist = expertSpecialist;
    }

    public String getFeedingAgregations() {
        return feedingAgregations;
    }

    public void setFeedingAgregations(String feedingAgregations) {
        this.feedingAgregations = feedingAgregations;
    }

    public String getEatingHabitsOtherComments() {
        return eatingHabitsOtherComments;
    }

    public void setEatingHabitsOtherComments(String eatingHabitsOtherComments) {
        this.eatingHabitsOtherComments = eatingHabitsOtherComments;
    }
}
