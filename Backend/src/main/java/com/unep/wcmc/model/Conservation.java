package com.unep.wcmc.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Conservation implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ExtinctionRisk extinctionRisk;

    @Embedded
    private Conventions conventions;

    @Embedded
    private ConservationAction conservationAction;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conservation_id")
    private List<SpecificActionUC> specificActionUCs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conservation_id")
    private List<NationalActionPlan> nationalActionPlans;

    @ElementCollection
    @CollectionTable(name = "conservation_ongoing_research")
    private List<Research> ongoingResearches;

    @ElementCollection
    @CollectionTable(name = "conservation_researcher")
    private List<Researcher> researchers;

    @ElementCollection
    @CollectionTable(name = "conservation_colaborator")
    private List<Researcher> colaborators;

    @Column(name = "necessary_research_for_conservation_of_species")
    private String necessaryResearchForConservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExtinctionRisk getExtinctionRisk() {
        return extinctionRisk;
    }

    public void setExtinctionRisk(ExtinctionRisk extinctionRisk) {
        this.extinctionRisk = extinctionRisk;
    }

    public Conventions getConventions() {
        return conventions;
    }

    public void setConventions(Conventions conventions) {
        this.conventions = conventions;
    }

    public ConservationAction getConservationAction() {
        return conservationAction;
    }

    public void setConservationAction(ConservationAction conservationAction) {
        this.conservationAction = conservationAction;
    }

    public List<SpecificActionUC> getSpecificActionUCs() {
        return specificActionUCs;
    }

    public void setSpecificActionUCs(List<SpecificActionUC> specificActionUCs) {
        this.specificActionUCs = specificActionUCs;
    }

    public List<NationalActionPlan> getNationalActionPlans() {
        return nationalActionPlans;
    }

    public void setNationalActionPlans(List<NationalActionPlan> nationalActionPlans) {
        this.nationalActionPlans = nationalActionPlans;
    }

    public List<Research> getOngoingResearches() {
        return ongoingResearches;
    }

    public void setOngoingResearches(List<Research> ongoingResearches) {
        this.ongoingResearches = ongoingResearches;
    }

    public List<Researcher> getResearchers() {
        return researchers;
    }

    public void setResearchers(List<Researcher> researchers) {
        this.researchers = researchers;
    }

    public List<Researcher> getColaborators() {
        return colaborators;
    }

    public void setColaborators(List<Researcher> colaborators) {
        this.colaborators = colaborators;
    }

    public String getNecessaryResearchForConservation() {
        return necessaryResearchForConservation;
    }

    public void setNecessaryResearchForConservation(String necessaryResearchForConservation) {
        this.necessaryResearchForConservation = necessaryResearchForConservation;
    }
}