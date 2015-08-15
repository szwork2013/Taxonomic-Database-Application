package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Habitat implements BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "habitat_habitat_types",
            joinColumns = @JoinColumn(name = "habitat_id"),
            inverseJoinColumns = @JoinColumn(name = "habitat_type_id"))
    private List<HabitatType> types;

    @Column(name = "restricted_to_primary_habitats")
    private Boolean restrictedToPrimaryHabitats;

    @Column(name = "specialist_in_habitat_or_microhabitat")
    private Boolean specialistInHabitOrMicrohabitat;

    @Column(name = "specialist_in_habitat_or_microhabitat_desc")
    private String specialistInHabitOrMicrohabitatDesc;

    @Column(name = "variation_in_habitat_use")
    private Boolean variationInHabitatUse;

    @Column(name = "variation_in_habitat_use_desc")
    private String variationInHabitatUseDesc;

    @Column(name = "seasonal_variation_in_habitat_use")
    private Boolean seasonalVariationInHabitatUse;

    @Column(name = "seasonal_variation_in_habitat_use_desc")
    private String seasonalVariationInHabitatUseDesc;

    @Column(name = "difference_in_habitat_use")
    private Boolean differenceInHabitatUse;

    @Column(name = "difference_in_habitat_use_desc")
    private String differenceInHabitatUseDesc;

    @Column(name = "cont_decline_habitat_quality")
    private Boolean continuingDeclineInHabitatQuality;

    @Column(name = "tolerant_to_habitat_mod")
    private String tolerantToHabitatModification;

    @Column(name = "justitication")
    private String justification;

    @Column(name = "other_observations")
    private String otherObservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HabitatType> getTypes() {
        return types;
    }

    public void setTypes(List<HabitatType> types) {
        this.types = types;
    }

    public Boolean getRestrictedToPrimaryHabitats() {
        return restrictedToPrimaryHabitats;
    }

    public void setRestrictedToPrimaryHabitats(Boolean restrictedToPrimaryHabitats) {
        this.restrictedToPrimaryHabitats = restrictedToPrimaryHabitats;
    }

    public String getTolerantToHabitatModification() {
        return tolerantToHabitatModification;
    }

    public void setTolerantToHabitatModification(String tolerantToHabitatModification) {
        this.tolerantToHabitatModification = tolerantToHabitatModification;
    }

    public Boolean getVariationInHabitatUse() {
        return variationInHabitatUse;
    }

    public void setVariationInHabitatUse(Boolean variationInHabitatUse) {
        this.variationInHabitatUse = variationInHabitatUse;
    }

    public Boolean getContinuingDeclineInHabitatQuality() {
        return continuingDeclineInHabitatQuality;
    }

    public void setContinuingDeclineInHabitatQuality(Boolean continuingDeclineInHabitatQuality) {
        this.continuingDeclineInHabitatQuality = continuingDeclineInHabitatQuality;
    }

	public Boolean getSpecialistInHabitOrMicrohabitat() {
		return specialistInHabitOrMicrohabitat;
	}

	public void setSpecialistInHabitOrMicrohabitat(Boolean specialistInHabitOrMicrohabitat) {
		this.specialistInHabitOrMicrohabitat = specialistInHabitOrMicrohabitat;
	}

    public String getSpecialistInHabitOrMicrohabitatDesc() {
        return specialistInHabitOrMicrohabitatDesc;
    }

    public void setSpecialistInHabitOrMicrohabitatDesc(String specialistInHabitOrMicrohabitatDesc) {
        this.specialistInHabitOrMicrohabitatDesc = specialistInHabitOrMicrohabitatDesc;
    }

    public String getVariationInHabitatUseDesc() {
        return variationInHabitatUseDesc;
    }

    public void setVariationInHabitatUseDesc(String variationInHabitatUseDesc) {
        this.variationInHabitatUseDesc = variationInHabitatUseDesc;
    }

    public Boolean getSeasonalVariationInHabitatUse() {
        return seasonalVariationInHabitatUse;
    }

    public void setSeasonalVariationInHabitatUse(Boolean seasonalVariationInHabitatUse) {
        this.seasonalVariationInHabitatUse = seasonalVariationInHabitatUse;
    }

    public String getSeasonalVariationInHabitatUseDesc() {
        return seasonalVariationInHabitatUseDesc;
    }

    public void setSeasonalVariationInHabitatUseDesc(String seasonalVariationInHabitatUseDesc) {
        this.seasonalVariationInHabitatUseDesc = seasonalVariationInHabitatUseDesc;
    }

    public Boolean getDifferenceInHabitatUse() {
        return differenceInHabitatUse;
    }

    public void setDifferenceInHabitatUse(Boolean differenceInHabitatUse) {
        this.differenceInHabitatUse = differenceInHabitatUse;
    }

    public String getDifferenceInHabitatUseDesc() {
        return differenceInHabitatUseDesc;
    }

    public void setDifferenceInHabitatUseDesc(String differenceInHabitatUseDesc) {
        this.differenceInHabitatUseDesc = differenceInHabitatUseDesc;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getOtherObservations() {
        return otherObservations;
    }

    public void setOtherObservations(String otherObservations) {
        this.otherObservations = otherObservations;
    }
}
