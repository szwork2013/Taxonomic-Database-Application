package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class MatingSystem implements Serializable {

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "mating_system")
    private MatingSystemType type;

    @Column(name = "mating_system_other")
    private String other;

	public MatingSystemType getType() {
		return type;
	}

	public void setType(MatingSystemType type) {
		this.type = type;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
}
