package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Species implements BaseEntity {

    public enum SpeciesType { FAUNA, FLORA }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "scientific_name")
    private String scientificName;

    @Enumerated(value = EnumType.ORDINAL)
    private ExtinctionRiskCategory extinctionRiskCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taxonomy_id")
    private Taxonomy taxonomy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "distribution_id")
    private DistributionArea distributionArea;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "natural_history_id")
    private NaturalHistory naturalHistory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conservation_id")
    private Conservation conservation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "threat_id")
    private Threat threat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_photo_id")
    private Image coverPhoto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_map_id")
    private Map coverMap;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "integration_source")
    private IntegrationSource integrationSource;

    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Enumerated(EnumType.ORDINAL)
    private SpeciesType type;

    @Column(nullable = false)
    private boolean enabled;

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

    public IntegrationSource getIntegrationSource() {
        return integrationSource;
    }

    public void setIntegrationSource(IntegrationSource integrationSource) {
        this.integrationSource = integrationSource;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public SpeciesType getType() {
        return type;
    }

    public void setType(SpeciesType type) {
        this.type = type;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
