package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Specie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "scientific_name")
    private String scientificName;

    @Enumerated(value = EnumType.ORDINAL)
    private ExtinctionRiskCategory extinctionRiskCategory;

    @OneToOne
    private Taxonomy taxonomy;

    @OneToOne
    private DistributionArea distributionArea;

    @OneToOne
    private NaturalHistory naturalHistory;

    @OneToOne
    private Conservation conservation;

    @OneToOne
    private Threat threats;

    @OneToOne
    private Image coverPhoto;

    @OneToOne
    private Map coverMap;

    @OneToMany
    private List<Multimedia> medias;

    // Getters and setters
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

    public ExtinctionRiskCategory getExtinctionRiskCategory() {
        return extinctionRiskCategory;
    }

    public void setExtinctionRiskCategory(ExtinctionRiskCategory extinctionRiskCategory) {
        this.extinctionRiskCategory = extinctionRiskCategory;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public DistributionArea getDistributionArea() {
        return distributionArea;
    }

    public void setDistributionArea(DistributionArea distributionArea) {
        this.distributionArea = distributionArea;
    }

    public NaturalHistory getNaturalHistory() {
        return naturalHistory;
    }

    public void setNaturalHistory(NaturalHistory naturalHistory) {
        this.naturalHistory = naturalHistory;
    }

    public Conservation getConservation() {
        return conservation;
    }

    public void setConservation(Conservation conservation) {
        this.conservation = conservation;
    }

    public Threat getThreats() {
        return threats;
    }

    public void setThreats(Threat threats) {
        this.threats = threats;
    }

    public Image getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Image coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Map getCoverMap() {
        return coverMap;
    }

    public void setCoverMap(Map coverMap) {
        this.coverMap = coverMap;
    }

    public List<Multimedia> getMedias() {
        return medias;
    }

    public void setMedias(List<Multimedia> medias) {
        this.medias = medias;
    }

}
