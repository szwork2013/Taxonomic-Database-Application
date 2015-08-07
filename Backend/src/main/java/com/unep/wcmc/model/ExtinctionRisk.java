package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExtinctionRisk implements Serializable {

    @Column(name = "national_evaluation_elegible")
    private Boolean nationalEvaluationElegible;

    @Column(name = "change_reasons")
    private String changeReasons;


    public Boolean getNationalEvaluationElegible() {
        return nationalEvaluationElegible;
    }

    public void setNationalEvaluationElegible(Boolean nationalEvaluationElegible) {
        this.nationalEvaluationElegible = nationalEvaluationElegible;
    }

    public String getChangeReasons() {
        return changeReasons;
    }

    public void setChangeReasons(String changeReasons) {
        this.changeReasons = changeReasons;
    }


}
