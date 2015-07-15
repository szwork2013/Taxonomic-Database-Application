package com.unep.wcmc.model.dto;


import java.io.Serializable;

public class SpeciesSearchDTO implements Serializable {

    // Species fields
    private Long id;
    private String commonName;
    private String scientificName;
    private String hierarchyClassName;
    private String kingdomName;
    private String phylumName;
    private String hierarchyOrderName;
    private String familyName;
    private String orderName;
    private String genusName;
    private String speciesName;
    private String subSpeciesName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getHierarchyClassName() {
        return hierarchyClassName;
    }

    public void setHierarchyClassName(String hierarchyClassName) {
        this.hierarchyClassName = hierarchyClassName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

	public String getKingdomName() {
		return kingdomName;
	}

	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}

	public String getPhylumName() {
		return phylumName;
	}

	public void setPhylumName(String phylumName) {
		this.phylumName = phylumName;
	}

	public String getHierarchyOrderName() {
		return hierarchyOrderName;
	}

	public void setHierarchyOrderName(String hierarchyOrderName) {
		this.hierarchyOrderName = hierarchyOrderName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getGenusName() {
		return genusName;
	}

	public void setGenusName(String genusName) {
		this.genusName = genusName;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getSubSpeciesName() {
		return subSpeciesName;
	}

	public void setSubSpeciesName(String subSpeciesName) {
		this.subSpeciesName = subSpeciesName;
	}
}
