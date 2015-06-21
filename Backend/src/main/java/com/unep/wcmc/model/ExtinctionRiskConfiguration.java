package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class ExtinctionRiskConfiguration implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExtinctionRiskCategory category;

    @Column(name = "A1_perc_population_decline")
    private Double percPopulationDecline;

    @Column(name = "A2_perc_population_decline")
    private Double percePopulationDecline2;

    @Column(name = "B1_extent_of_occurrence")
    private Long occurrenceExtent;

    @Column(name = "B2_area_of_ocuppancy")
    private Long occupancyArea;

    @Column(name = "B2a_number_of_locations")
    private Integer numberLocations;

    @Column(name = "C_number_of_mature_individuals")
    private Long numberMatureIndividuals;

    @Column(name = "C2a_number_of_mature_individuals_in_sub")
    private Long numberMatureIndividualsInSub;

    @Column(name = "C2a_perc_mature_individuals_one_sub")
    private Integer percMatureIndividualsOneSub;

    @Column(name = "D_number_of_mature_individuals")
    private Long numberMatureIndividuals2;

    @Column(name = "E_prob_extinction_in_the_wild")
    private Double probExtinctionInWild;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ExtinctionRiskCategory getCategory() {
        return category;
    }

    public void setCategory(ExtinctionRiskCategory category) {
        this.category = category;
    }

    public Double getPercPopulationDecline() {
        return percPopulationDecline;
    }

    public void setPercPopulationDecline(Double percPopulationDecline) {
        this.percPopulationDecline = percPopulationDecline;
    }

    public Double getPercePopulationDecline2() {
        return percePopulationDecline2;
    }

    public void setPercePopulationDecline2(Double percePopulationDecline2) {
        this.percePopulationDecline2 = percePopulationDecline2;
    }

    public Long getOccurrenceExtent() {
        return occurrenceExtent;
    }

    public void setOccurrenceExtent(Long occurrenceExtent) {
        this.occurrenceExtent = occurrenceExtent;
    }

    public Long getOccupancyArea() {
        return occupancyArea;
    }

    public void setOccupancyArea(Long occupancyArea) {
        this.occupancyArea = occupancyArea;
    }

    public Integer getNumberLocations() {
        return numberLocations;
    }

    public void setNumberLocations(Integer numberLocations) {
        this.numberLocations = numberLocations;
    }

    public Long getNumberMatureIndividuals() {
        return numberMatureIndividuals;
    }

    public void setNumberMatureIndividuals(Long numberMatureIndividuals) {
        this.numberMatureIndividuals = numberMatureIndividuals;
    }

    public Long getNumberMatureIndividualsInSub() {
        return numberMatureIndividualsInSub;
    }

    public void setNumberMatureIndividualsInSub(Long numberMatureIndividualsInSub) {
        this.numberMatureIndividualsInSub = numberMatureIndividualsInSub;
    }

    public Integer getPercMatureIndividualsOneSub() {
        return percMatureIndividualsOneSub;
    }

    public void setPercMatureIndividualsOneSub(Integer percMatureIndividualsOneSub) {
        this.percMatureIndividualsOneSub = percMatureIndividualsOneSub;
    }

    public Long getNumberMatureIndividuals2() {
        return numberMatureIndividuals2;
    }

    public void setNumberMatureIndividuals2(Long numberMatureIndividuals2) {
        this.numberMatureIndividuals2 = numberMatureIndividuals2;
    }

    public Double getProbExtinctionInWild() {
        return probExtinctionInWild;
    }

    public void setProbExtinctionInWild(Double probExtinctionInWild) {
        this.probExtinctionInWild = probExtinctionInWild;
    }
}
