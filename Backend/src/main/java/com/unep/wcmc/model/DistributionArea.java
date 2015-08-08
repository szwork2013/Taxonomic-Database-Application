package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DistributionArea implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "occurs_in_brasil")
    private Boolean ocurrsBrazil;

    @Column(name = "native_in_brazil")
    private Boolean nativeBrazil;

    @Column(name = "endemic_from_brasil")
    private Boolean endemicFromBrazil;

    @Column(name = "national_distribution")
    private String nationalDistribution;

    @Column(name = "only_from_few_localities")
    private Boolean onlyFromFewLocalities;

    @Column(name = "the_region_is_well_sampled")
    private Boolean regionIsWellSampled;

    @Column(name = "global_distribution")
    private String globalDistribution;

    @ManyToMany
    @JoinTable(name = "occurrence_states",
        joinColumns = @JoinColumn(name = "distribution_area_id"),
        inverseJoinColumns = @JoinColumn(name = "state_id"))
    private List<State> occurrenceStates;

    @ManyToMany
    @JoinTable(name = "occurrence_biomes",
        joinColumns = @JoinColumn(name = "distribution_area_id"),
        inverseJoinColumns = @JoinColumn(name = "biome_id"))
    private List<Biome> occurrenceBiomes;

    @ManyToMany
    @JoinTable(name = "occurrence_protected_areas",
        joinColumns = @JoinColumn(name = "distribution_area_id"),
        inverseJoinColumns = @JoinColumn(name = "protected_area_id"))
    private List<ProtectedArea> occurrenceProtectedAreas;

    @ManyToMany
    @JoinTable(name = "occurrence_river_basins",
        joinColumns = @JoinColumn(name = "distribution_area_id"),
        inverseJoinColumns = @JoinColumn(name = "river_basin_id"))
    private List<RiverBasin> occurrenceRiverBasins;

    @Column(name = "other_relevant_areas")
    private String otherRelevantAreas;

    @Embedded
    private ExtentOccurrence extentOccurrence;

    @Embedded
    private AreaOccupancy areaOccupancy;

    @Column(name = "justification_of_trends")
    private String justificationTrends;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "distribution_area_id")
    private List<Occurrence> occurrences;

    public DistributionArea() {
        super();
        this.occurrences = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOcurrsBrazil() {
        return ocurrsBrazil;
    }

    public void setOcurrsBrazil(Boolean ocurrsBrazil) {
        this.ocurrsBrazil = ocurrsBrazil;
    }

    public Boolean getNativeBrazil() {
        return nativeBrazil;
    }

    public void setNativeBrazil(Boolean nativeBrazil) {
        this.nativeBrazil = nativeBrazil;
    }

    public Boolean getEndemicFromBrazil() {
        return endemicFromBrazil;
    }

    public void setEndemicFromBrazil(Boolean endemicFromBrazil) {
        this.endemicFromBrazil = endemicFromBrazil;
    }

    public String getNationalDistribution() {
        return nationalDistribution;
    }

    public void setNationalDistribution(String nationalDistribution) {
        this.nationalDistribution = nationalDistribution;
    }

    public Boolean getOnlyFromFewLocalities() {
        return onlyFromFewLocalities;
    }

    public void setOnlyFromFewLocalities(Boolean onlyFromFewLocalities) {
        this.onlyFromFewLocalities = onlyFromFewLocalities;
    }

    public Boolean getRegionIsWellSampled() {
        return regionIsWellSampled;
    }

    public void setRegionIsWellSampled(Boolean regionIsWellSampled) {
        this.regionIsWellSampled = regionIsWellSampled;
    }

    public String getGlobalDistribution() {
        return globalDistribution;
    }

    public void setGlobalDistribution(String globalDistribution) {
        this.globalDistribution = globalDistribution;
    }

    public List<State> getOccurrenceStates() {
        return occurrenceStates;
    }

    public void setOccurrenceStates(List<State> occurrenceStates) {
        this.occurrenceStates = occurrenceStates;
    }

    public List<Biome> getOccurrenceBiomes() {
        return occurrenceBiomes;
    }

    public void setOccurrenceBiomes(List<Biome> occurrenceBiomes) {
        this.occurrenceBiomes = occurrenceBiomes;
    }

    public List<ProtectedArea> getOccurrenceProtectedAreas() {
        return occurrenceProtectedAreas;
    }

    public void setOccurrenceProtectedAreas(List<ProtectedArea> occurrenceProtectedAreas) {
        this.occurrenceProtectedAreas = occurrenceProtectedAreas;
    }

    public List<RiverBasin> getOccurrenceRiverBasins() {
        return occurrenceRiverBasins;
    }

    public void setOccurrenceRiverBasins(List<RiverBasin> occurrenceRiverBasins) {
        this.occurrenceRiverBasins = occurrenceRiverBasins;
    }

    public String getOtherRelevantAreas() {
        return otherRelevantAreas;
    }

    public void setOtherRelevantAreas(String otherRelevantAreas) {
        this.otherRelevantAreas = otherRelevantAreas;
    }

    public ExtentOccurrence getExtentOccurrence() {
        return extentOccurrence;
    }

    public void setExtentOccurrence(ExtentOccurrence extentOccurrence) {
        this.extentOccurrence = extentOccurrence;
    }

    public AreaOccupancy getAreaOccupancy() {
        return areaOccupancy;
    }

    public void setAreaOccupancy(AreaOccupancy areaOccupancy) {
        this.areaOccupancy = areaOccupancy;
    }

    public List<Occurrence> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(List<Occurrence> occurrences) {
        this.occurrences = occurrences;
    }

    public String getJustificationTrends() {
        return justificationTrends;
    }

    public void setJustificationTrends(String justificationTrends) {
        this.justificationTrends = justificationTrends;
    }
}
