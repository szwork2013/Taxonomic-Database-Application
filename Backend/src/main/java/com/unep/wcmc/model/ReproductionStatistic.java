package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class ReproductionStatistic implements BaseEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "male")
	private String male;
	
	@Column(name = "female")
	private String female;
	
	@Column(name = "both")
	private String both;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "reference")
	private String reference;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
}
