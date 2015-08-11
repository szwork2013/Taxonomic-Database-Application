package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Taxonomy implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Hierarchy hierarchy;

    @Column(name = "limitations_for_assessment")
    private Boolean limitationsForAssessment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "taxonomy_id")
    private List<CommonName> commonNames;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "taxonomy_id")
    private List<Synonym> synonyms;

    @Column(name = "notes")
    private String notes;

    @Column(name = "national_species_id")
    private String nationalSpeciesId;

    @Column(name = "cytogenetic_characteristics")
    private String cytogeneticCharacteristics;

    @Column(name = "morphological_diagnostic")
    private String morphologicalDiagnostic;

    @Column(name = "other_comments")
    private String otherComments;

    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Column(nullable = false)
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Boolean getLimitationsForAssessment() {
        return limitationsForAssessment;
    }

    public void setLimitationsForAssessment(Boolean limitationsForAssessment) {
        this.limitationsForAssessment = limitationsForAssessment;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<CommonName> getCommonNames() {
        return commonNames;
    }

    public void setCommonNames(List<CommonName> commonNames) {
        this.commonNames = commonNames;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNationalSpeciesId() {
        return nationalSpeciesId;
    }

    public void setNationalSpeciesId(String nationalSpeciesId) {
        this.nationalSpeciesId = nationalSpeciesId;
    }

    public String getCytogeneticCharacteristics() {
        return cytogeneticCharacteristics;
    }

    public void setCytogeneticCharacteristics(String cytogeneticCharacteristics) {
        this.cytogeneticCharacteristics = cytogeneticCharacteristics;
    }

    public String getMorphologicalDiagnostic() {
        return morphologicalDiagnostic;
    }

    public void setMorphologicalDiagnostic(String morphologicalDiagnostic) {
        this.morphologicalDiagnostic = morphologicalDiagnostic;
    }

    public String getOtherComments() {
        return otherComments;
    }

    public void setOtherComments(String otherComments) {
        this.otherComments = otherComments;
    }
}
