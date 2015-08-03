package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public final class ReproductionMode implements Serializable {
	
	@Column(name = "type")
	@Enumerated(value = EnumType.ORDINAL)
    private ReproductionModeType type;

    @Column(name = "mode_description")
    private String modeDescription;

	public ReproductionModeType getType() {
		return type;
	}

	public void setType(ReproductionModeType type) {
		this.type = type;
	}

	public String getModeDescription() {
		return modeDescription;
	}

	public void setModeDescription(String modeDescription) {
		this.modeDescription = modeDescription;
	}
}
