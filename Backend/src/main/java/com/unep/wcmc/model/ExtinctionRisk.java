package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExtinctionRisk implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "national_evaluation_elegible")
    private Boolean nationalEvaluationElegible;

    @Column(name = "change_reasons")
    private String changeReasons;

    @ElementCollection
    @CollectionTable(name = "national_assessments", joinColumns = @JoinColumn(name = "extinction_risk_id"))
    private List<ExtinctionRiskAssessment> nationalAssessments;

    @ElementCollection
    @CollectionTable(name = "global_conservation_assessments", joinColumns = @JoinColumn(name = "extinction_risk_id"))
    private List<ExtinctionRiskAssessment> globalConservationAssessments;

    @ElementCollection
    @CollectionTable(name = "other_lists_assessments", joinColumns = @JoinColumn(name = "extinction_risk_id"))
    private List<ExtinctionRiskAssessment> otherListsAssessments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
