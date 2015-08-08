package com.unep.wcmc.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Reproduction implements BaseEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maximun_size_id")
    private ReproductionStatistic maximumSize;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_at_first_maturity_id")
    private ReproductionStatistic sizeAtFirstMaturity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_at_birth_id")
    private ReproductionStatistic sizeAtBirth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "age_at_first_maturity_id")
    private ReproductionStatistic ageAtFirstMaturity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reproductive_senescence_id")
    private ReproductionStatistic reproductiveSenescence;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "longevity_id")
    private ReproductionStatistic longevity;
	
    @Column(name = "hermaphrodite")
    private Boolean hermaphrodite;
    
    @Column(name = "reversal")
    private Boolean reversal;

	@Embedded
	private ReproductionMode reproductionMode;

	@Embedded
	private MatingSystem matingSystem;
    
    @Column(name = "parental_care")
    private Boolean parentalCare;

    @Column(name = "annual_fecundity")
    private Boolean annualFecundity;
    
    @Column(name = "average_size_of_litter")
    private Double averageSizeOfLitter;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "reproduction_id")
	private List<ReproductiveAggregation> aggregations;

	@Column(name = "generation_length")
    private String generationLength;

    @Column(name = "method_of_estimate_generation_length")
    private String methodOfEstimateGenerationLength;

    @Column(name = "other_observations_on_reproduction")
    private String otherObsOnReproduction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReproductionStatistic getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(ReproductionStatistic maximumSize) {
        this.maximumSize = maximumSize;
    }

	public ReproductionStatistic getSizeAtFirstMaturity() {
		return sizeAtFirstMaturity;
	}

	public void setSizeAtFirstMaturity(ReproductionStatistic sizeAtFirstMaturity) {
		this.sizeAtFirstMaturity = sizeAtFirstMaturity;
	}

	public ReproductionStatistic getSizeAtBirth() {
		return sizeAtBirth;
	}

	public void setSizeAtBirth(ReproductionStatistic sizeAtBirth) {
		this.sizeAtBirth = sizeAtBirth;
	}

	public ReproductionStatistic getAgeAtFirstMaturity() {
		return ageAtFirstMaturity;
	}

	public void setAgeAtFirstMaturity(ReproductionStatistic ageAtFirstMaturity) {
		this.ageAtFirstMaturity = ageAtFirstMaturity;
	}

	public ReproductionStatistic getReproductiveSenescence() {
		return reproductiveSenescence;
	}

	public void setReproductiveSenescence(
			ReproductionStatistic reproductiveSenescence) {
		this.reproductiveSenescence = reproductiveSenescence;
	}

	public ReproductionStatistic getLongevity() {
		return longevity;
	}

	public void setLongevity(ReproductionStatistic longevity) {
		this.longevity = longevity;
	}

	public Boolean getHermaphrodite() {
		return hermaphrodite;
	}

	public void setHermaphrodite(Boolean hermaphrodite) {
		this.hermaphrodite = hermaphrodite;
	}

	public Boolean getReversal() {
		return reversal;
	}

	public void setReversal(Boolean reversal) {
		this.reversal = reversal;
	}

	public Boolean getParentalCare() {
		return parentalCare;
	}

	public void setParentalCare(Boolean parentalCare) {
		this.parentalCare = parentalCare;
	}

	public Boolean getAnnualFecundity() {
		return annualFecundity;
	}

	public void setAnnualFecundity(Boolean annualFecundity) {
		this.annualFecundity = annualFecundity;
	}

	public Double getAverageSizeOfLitter() {
		return averageSizeOfLitter;
	}

	public void setAverageSizeOfLitter(Double averageSizeOfLitter) {
		this.averageSizeOfLitter = averageSizeOfLitter;
	}

	public String getGenerationLength() {
		return generationLength;
	}

	public void setGenerationLength(String generationLength) {
		this.generationLength = generationLength;
	}

	public String getMethodOfEstimateGenerationLength() {
		return methodOfEstimateGenerationLength;
	}

	public void setMethodOfEstimateGenerationLength(
			String methodOfEstimateGenerationLength) {
		this.methodOfEstimateGenerationLength = methodOfEstimateGenerationLength;
	}

	public String getOtherObsOnReproduction() {
		return otherObsOnReproduction;
	}

	public void setOtherObsOnReproduction(String otherObsOnReproduction) {
		this.otherObsOnReproduction = otherObsOnReproduction;
	}

	public List<ReproductiveAggregation> getAggregations() {
		return aggregations;
	}

	public void setAggregations(List<ReproductiveAggregation> aggregations) {
		this.aggregations = aggregations;
	}

	public ReproductionMode getReproductionMode() {
		return reproductionMode;
	}

	public void setReproductionMode(ReproductionMode reproductionMode) {
		this.reproductionMode = reproductionMode;
	}

	public MatingSystem getMatingSystem() {
		return matingSystem;
	}

	public void setMatingSystem(MatingSystem matingSystem) {
		this.matingSystem = matingSystem;
	}

}
