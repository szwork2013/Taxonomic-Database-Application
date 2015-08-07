package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EatingHabits implements Serializable {

    @ManyToOne
    @JoinColumn(name = "eating_habits_id")
    private EatingHabitsType type;

    @Column(name = "eating_habits_other")
    private String other;

    public EatingHabitsType getType() {
        return type;
    }

    public void setType(EatingHabitsType type) {
        this.type = type;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
