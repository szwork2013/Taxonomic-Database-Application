package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Researcher implements Serializable {

    private String name;

    private String institution;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
}

