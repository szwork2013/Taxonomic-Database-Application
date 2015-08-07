package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PopulationReduction implements Serializable {

	@Column(name = "reduction")
    private Boolean reduction;

    @Column(name = "years")
    private Integer years;

    @Column(name = "percentage")
    private Integer percentage;

	public Boolean getReduction() {
		return reduction;
	}

	public void setReduction(Boolean reduction) {
		this.reduction = reduction;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
}
