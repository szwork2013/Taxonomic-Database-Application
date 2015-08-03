package com.unep.wcmc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public final class MatingSystem implements Serializable {
	
	@Column(name = "system")
	@Enumerated(value = EnumType.ORDINAL)
    private MatingSystemType system;

    @Column(name = "mating_description")
    private String matingDescription;

	public MatingSystemType getSystem() {
		return system;
	}

	public void setSystem(MatingSystemType system) {
		this.system = system;
	}

	public String getMatingDescription() {
		return matingDescription;
	}

	public void setMatingDescription(String matingDescription) {
		this.matingDescription = matingDescription;
	}
}
