package com.unep.wcmc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public final class TaxonomyGeneral extends TaxonomicEntity {

    @Column
    private String commonName;

    @ManyToOne
    @JoinColumn(name="taxonomy_id")
    private Taxonomy taxonomy;

    @ManyToOne
    @JoinColumn(name="cover_map_id")
    private Map coverMap;

    @ManyToOne
    @JoinColumn(name="cover_photo_id")
    private Image coverPhoto;

    @ManyToMany
    private List<Image> icons;

    @ManyToOne
    @JoinColumn(name="extinction_risk_id")
    private ExtinctionRisk extinctionRisk;

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Map getCoverMap() {
        return coverMap;
    }

    public void setCoverMap(Map coverMap) {
        this.coverMap = coverMap;
    }

    public Image getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Image coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public List<Image> getIcons() {
        return icons;
    }

    public void setIcons(List<Image> icons) {
        this.icons = icons;
    }

    public ExtinctionRisk getExtinctionRisk() {
        return extinctionRisk;
    }

    public void setExtinctionRisk(ExtinctionRisk extinctionRisk) {
        this.extinctionRisk = extinctionRisk;
    }
}
