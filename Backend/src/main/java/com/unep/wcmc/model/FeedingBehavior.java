package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class FeedingBehavior implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EatingHabits eatingHabits;

    @Column(name = "expert")
    @Enumerated(value = EnumType.ORDINAL)
    private ExpertType expertType;

    @Column(name = "expertDescription")
    private String expertDescription;

    @Column(name = "feeding_agregations")
    private Boolean feedingAgregations;

    @Column(name = "feeding_agregations_desc")
    private String feedingAgregationsDesc;

    @Column(name = "eating_habits_other_comments")
    private String eatingHabitsOtherComments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EatingHabits getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(EatingHabits eatingHabits) {
        this.eatingHabits = eatingHabits;
    }

    public Boolean getFeedingAgregations() {
        return feedingAgregations;
    }

    public void setFeedingAgregations(Boolean feedingAgregations) {
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

    public String getExpertDescription() {
        return expertDescription;
    }

    public void setExpertDescription(String expertDescription) {
        this.expertDescription = expertDescription;
    }

    public String getFeedingAgregationsDesc() {
        return feedingAgregationsDesc;
    }

    public void setFeedingAgregationsDesc(String feedingAgregationsDesc) {
        this.feedingAgregationsDesc = feedingAgregationsDesc;
    }
}