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

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "taxonomy_id")
    private Taxonomy taxonomy;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "distribution_id")
    private DistributionArea distributionArea;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "natural_history_id")
    private NaturalHistory naturalHistory;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "conservation_id")
    private Conservation conservation;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "threat_id")
    private Threat threat;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cover_photo_id")
    private Image coverPhoto;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cover_map_id")
    private Map coverMap;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "specie_id")
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

    public Threat getThreat() {
        return threat;
    }

    public void setThreat(Threat threat) {
        this.threat = threat;
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
