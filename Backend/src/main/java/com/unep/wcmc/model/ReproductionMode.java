package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ReproductionMode implements Serializable {

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "reproduction_mode")
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
