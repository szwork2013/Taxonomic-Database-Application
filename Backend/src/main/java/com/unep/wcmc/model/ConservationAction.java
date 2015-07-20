package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ConservationAction implements Serializable {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ConservationActionType type;

    //@Column(name = "benefited_from_action_plan")
    private String benefitedActionPlan;

    public ConservationActionType getType() {
        return type;
    }

    public void setType(ConservationActionType type) {
        this.type = type;
    }

    public String getBenefitedActionPlan() {
        return benefitedActionPlan;
    }

    public void setBenefitedActionPlan(String benefitedActionPlan) {
        this.benefitedActionPlan = benefitedActionPlan;
    }
}