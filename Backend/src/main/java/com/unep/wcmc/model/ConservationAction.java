package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class ConservationAction implements Serializable {

    @Column(name = "benefited_from_action_plan")
    private Boolean benefitedActionPlan;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conservation_action_id")
    private List<ConventionItem> benefitedActionPlanList;

    @Column(name = "recommented_conservation_actions")
    private Boolean recommendedConservationActions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recommended_conservation_id")
    private List<ConservationActionItem> recommendedConservationActionsList;

    @Column(name = "other_ongoing_actions")
    private Boolean otherOngoingActions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ongoing_conservation_id")
    private List<ConservationActionItem> otherOngoingActionsList;

    @Column(name = "ex_situ_management")
    private Boolean exSituManagement;

    @Column(name = "ex_situ_management_desc")
    private String exSituManagementDesc;


    public Boolean getBenefitedActionPlan() {
        return benefitedActionPlan;
    }

    public void setBenefitedActionPlan(Boolean benefitedActionPlan) {
        this.benefitedActionPlan = benefitedActionPlan;
    }

    public List<ConventionItem> getBenefitedActionPlanList() {
        return benefitedActionPlanList;
    }

    public void setBenefitedActionPlanList(List<ConventionItem> benefitedActionPlanList) {
        this.benefitedActionPlanList = benefitedActionPlanList;
    }

    public Boolean getRecommendedConservationActions() {
        return recommendedConservationActions;
    }

    public void setRecommendedConservationActions(Boolean recommendedConservationActions) {
        this.recommendedConservationActions = recommendedConservationActions;
    }

    public List<ConservationActionItem> getRecommendedConservationActionsList() {
        return recommendedConservationActionsList;
    }

    public void setRecommendedConservationActionsList(List<ConservationActionItem> recommendedConservationActionsList) {
        this.recommendedConservationActionsList = recommendedConservationActionsList;
    }

    public Boolean getOtherOngoingActions() {
        return otherOngoingActions;
    }

    public void setOtherOngoingActions(Boolean otherOngoingActions) {
        this.otherOngoingActions = otherOngoingActions;
    }

    public List<ConservationActionItem> getOtherOngoingActionsList() {
        return otherOngoingActionsList;
    }

    public void setOtherOngoingActionsList(List<ConservationActionItem> otherOngoingActionsList) {
        this.otherOngoingActionsList = otherOngoingActionsList;
    }

    public Boolean getExSituManagement() {
        return exSituManagement;
    }

    public void setExSituManagement(Boolean exSituManagement) {
        this.exSituManagement = exSituManagement;
    }

    public String getExSituManagementDesc() {
        return exSituManagementDesc;
    }

    public void setExSituManagementDesc(String exSituManagementDesc) {
        this.exSituManagementDesc = exSituManagementDesc;
    }
}