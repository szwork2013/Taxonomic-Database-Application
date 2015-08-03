package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.io.Serializable;

@Embeddable
public class FeedingBehavior implements Serializable {

    @Column(name = "eating_habits")
    private String eatingHabits;

    @Column(name = "feeding_agregations")
    private String feedingAgregations;

    @Column(name = "eating_habits_other_comments")
    private String eatingHabitsOtherComments;

    @Column(name = "expert")
    @Enumerated(value = EnumType.ORDINAL)
    private ExpertType expertType;
    
    public String getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(String eatingHabits) {
        this.eatingHabits = eatingHabits;
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

	public ExpertType getExpertType() {
		return expertType;
	}

	public void setExpertType(ExpertType expertType) {
		this.expertType = expertType;
	}
}
