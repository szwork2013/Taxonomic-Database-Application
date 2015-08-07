package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public final class ReproductionMode implements Serializable {
	
	@Column(name = "reproduction_mode_id")
	@Enumerated(value = EnumType.ORDINAL)
    private ReproductionModeType type;

    @Column(name = "reproduction_mode_other")
    private String other;

	public ReproductionModeType getType() {
		return type;
	}

	public void setType(ReproductionModeType type) {
		this.type = type;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
}
