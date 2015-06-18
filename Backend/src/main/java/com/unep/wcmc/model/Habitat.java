package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Habitat implements Serializable {

    private String description;

    private Boolean restrictedToPrimaryHabitats;

    private String tolerantToHabitatModification;

    private String variationInHabitatUse;

    private Boolean continuingDeclineInHabitatQuality;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getVariationInHabitatUse() {
        return variationInHabitatUse;
    }

    public void setVariationInHabitatUse(String variationInHabitatUse) {
        this.variationInHabitatUse = variationInHabitatUse;
    }

    public Boolean getContinuingDeclineInHabitatQuality() {
        return continuingDeclineInHabitatQuality;
    }

    public void setContinuingDeclineInHabitatQuality(Boolean continuingDeclineInHabitatQuality) {
        this.continuingDeclineInHabitatQuality = continuingDeclineInHabitatQuality;
    }
}
