package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class ExtinctionRisk implements Serializable {

    @Column(name = "national_evaluation_elegible")
    private Boolean nationalEvaluationElegible;

    @Column(name = "change_reasons")
    private String changeReasons;

    @ElementCollection
    @CollectionTable(name = "conservation_assessment_national", joinColumns = @JoinColumn(name = "conservation_id"))
    private List<ExtinctionRiskAssessment> nationalAssessments;

    @ElementCollection
    @CollectionTable(name = "conservation_assessment_global", joinColumns = @JoinColumn(name = "conservation_id"))
    private List<ExtinctionRiskAssessment> globalConservationAssessments;

    @ElementCollection
    @CollectionTable(name = "conservation_assessment_other", joinColumns = @JoinColumn(name = "conservation_id"))
    private List<ExtinctionRiskAssessment> otherListsAssessments;

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

    public List<ExtinctionRiskAssessment> getNationalAssessments() {
        return nationalAssessments;
    }

    public void setNationalAssessments(List<ExtinctionRiskAssessment> nationalAssessments) {
        this.nationalAssessments = nationalAssessments;
    }

    public List<ExtinctionRiskAssessment> getGlobalConservationAssessments() {
        return globalConservationAssessments;
    }

    public void setGlobalConservationAssessments(List<ExtinctionRiskAssessment> globalConservationAssessments) {
        this.globalConservationAssessments = globalConservationAssessments;
    }

    public List<ExtinctionRiskAssessment> getOtherListsAssessments() {
        return otherListsAssessments;
    }

    public void setOtherListsAssessments(List<ExtinctionRiskAssessment> otherListsAssessments) {
        this.otherListsAssessments = otherListsAssessments;
    }
}
