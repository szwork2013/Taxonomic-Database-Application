package com.unep.wcmc.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Conservation implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ExtinctionRisk extinctionRisk;

    @Embedded
    private Conventions conventions;

    @Embedded
    private ConservationAction conservationAction;

    @OneToMany(mappedBy = "conservationId", fetch = FetchType.EAGER)
    private List<Research> ongoingResearchs;    
    
    @OneToMany(mappedBy = "conservationId", fetch = FetchType.EAGER)
    private List<Research> researchs;    
    
    @OneToMany(mappedBy = "conservationId", fetch = FetchType.EAGER)
    private List<Colaborator> colaborators;
    
    @Column(name = "necessary_research_for_conservation_of_species")
    private String necessaryResearchForConservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExtinctionRisk getExtinctionRisk() {
        return extinctionRisk;
    }

    public void setExtinctionRisk(ExtinctionRisk extinctionRisk) {
        this.extinctionRisk = extinctionRisk;
    }

    public Conventions getConventions() {
        return conventions;
    }

    public void setConventions(Conventions conventions) {
        this.conventions = conventions;
    }

	public List<Colaborator> getColaborators() {
		return colaborators;
	}

	public void setColaborators(List<Colaborator> colaborators) {
		this.colaborators = colaborators;
	}

	public String getNecessaryResearchForConservation() {
		return necessaryResearchForConservation;
	}

	public void setNecessaryResearchForConservation(
			String necessaryResearchForConservation) {
		this.necessaryResearchForConservation = necessaryResearchForConservation;
	}

	public List<Research> getOngoingResearchs() {
		return ongoingResearchs;
	}

	public void setOngoingResearchs(List<Research> ongoingResearchs) {
		this.ongoingResearchs = ongoingResearchs;
	}

	public List<Research> getResearchs() {
		return researchs;
	}

	public void setResearchs(List<Research> researchs) {
		this.researchs = researchs;
	}
}