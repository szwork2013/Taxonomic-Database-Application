package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Species implements BaseEntity {

    public enum SpeciesType { FAUNA, FLORA }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "historiography_natural")
    private String historiographyNatural;

    @Column(name = "conservation_state")
    private String conservationState;

    @Column(name = "curiosities")
    private String curiosities;

    @Column(name = "extinction_risk_category")
    @Enumerated(value = EnumType.ORDINAL)
    private ExtinctionRiskCategory extinctionRiskCategory;

    @ElementCollection
    @CollectionTable(name = "extinction_risk_criteria", joinColumns = @JoinColumn(name = "species_id"))
    @Enumerated(value = EnumType.STRING)
    @Column(name = "criteria")
    private Set<ExtinctionRiskCriteria> extinctionRiskCriterias;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "specie_threat", joinColumns = {
            @JoinColumn(name = "specie_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "threat_id",
                    nullable = false, updatable = false) })
    private Set<Threat> threats;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_photo_id")
    private Image coverPhoto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_map_id")
    private Map coverMap;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getHistoriographyNatural() {
        return historiographyNatural;
    }

    public void setHistoriographyNatural(String historiographyNatural) {
        this.historiographyNatural = historiographyNatural;
    }

    public String getConservationState() {
        return conservationState;
    }

    public void setConservationState(String conservationState) {
        this.conservationState = conservationState;
    }

    public String getCuriosities() {
        return curiosities;
    }

    public void setCuriosities(String curiosities) {
        this.curiosities = curiosities;
    }

    public ExtinctionRiskCategory getExtinctionRiskCategory() {
        return extinctionRiskCategory;
    }

    public void setExtinctionRiskCategory(ExtinctionRiskCategory extinctionRiskCategory) {
        this.extinctionRiskCategory = extinctionRiskCategory;
    }

    public Set<ExtinctionRiskCriteria> getExtinctionRiskCriterias() {
        return extinctionRiskCriterias;
    }

    public void setExtinctionRiskCriterias(Set<ExtinctionRiskCriteria> extinctionRiskCriterias) {
        this.extinctionRiskCriterias = extinctionRiskCriterias;
    }

    public void addExtinctionRiskCriteria(ExtinctionRiskCriteria extinctionRiskCriteria) {
        if (extinctionRiskCriterias == null) {
            extinctionRiskCriterias = new HashSet<>();
        }
        extinctionRiskCriterias.add(extinctionRiskCriteria);
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

    public Set<Threat> getThreats() {
        return threats == null ? new HashSet<Threat>() : threats;
    }

    public void setThreats(Set<Threat> threats) {
        this.threats = threats;
    }

    public void addThreat(Threat threat){
        getThreats().add(threat);
    }

    public void removeThreat(Threat threat){
        getThreats().remove(threat);
    }
}
