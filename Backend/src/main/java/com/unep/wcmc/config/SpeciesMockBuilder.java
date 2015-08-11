package com.unep.wcmc.config;

import com.unep.wcmc.model.*;
import com.unep.wcmc.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Scope("singleton")
public class SpeciesMockBuilder {

    @Autowired
    private SpeciesService specieService;

    public Species createSpecies() {
        Species specie = specieService.findByCommonName("Sagui-de-tufos-brancos");
        if (specie == null) {
            specie = new Species();
            specie.setName("Sagui-de-tufos-brancos");
            specie.setScientificName("Callithrix jacchus");
            specie.setConservation(createConservation());
            specie.setCoverMap(createMap());
            specie.setDistributionArea(createDistributionArea());
            specie.setExtinctionRiskCategory(ExtinctionRiskCategory.CRITICALLY_ENDANGERED);
            specie.setNaturalHistory(createNaturalHistory());
            specie.setTaxonomy(createTaxonomy());
            //specie.setThreat(createThreat());
            specie.setCoverPhoto(null);
            specie = specieService.save(specie);
        }
        return specie;
    }

    private Conservation createConservation() {
        final Conservation conservation = new Conservation();
        final ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        final Conventions conventions = new Conventions();
        //extinctionRisk.setActionPlans("ActionPlans");
        extinctionRisk.setChangeReasons("ChangeReasons");
        //extinctionRisk.setInNationalEndangeredFauna(true);
        extinctionRisk.setNationalEvaluationElegible(true);
        //extinctionRisk.setNecessaryResearchForConservation("NecessaryResearchForConservation");
        //extinctionRisk.setResearchInProgress("ResearchInProgress");
        //extinctionRisk.setSpecificActionsInProtectedAreas("SpecificActionsInProtectedAreas");
        //conventions.setBenefitedFromActionPlan("BenefitedFromActionPlan");
        //conventions.setConvention("Convention");
        //conventions.setConventionOtherRelevantData("ConventionOtherRelevantData");
        //conventions.setExSituManagement("ExSituManagement");
        //conventions.setOtherActionsProtectSpecies("OtherActionsProtectSpecies");
        conservation.setExtinctionRisk(extinctionRisk);
        conservation.setConventions(conventions);
        return conservation;
    }

    private Map createMap() {
        final Map map = new Map();
        map.setAuhtor("Author");
        map.setCaption("Caption");
        map.setDate(new Date());
        map.setDescription("Description");
        map.setIsCover(true);
        map.setProjection("Projection");
        map.setType("Type");
        return map;
    }

    private DistributionArea createDistributionArea() {
        final DistributionArea distributionArea = new DistributionArea();
        final Occurrence occurrences = new Occurrence();
        final State state = new State();
        final Country country = new Country();
        country.setName("Brazil");
        state.setCode("1");
        state.setName("CE");
        state.setCountry(country);
        occurrences.setLatitude("-3.731861600000000000");
        occurrences.setLongitude("-38.526670400000000000");
        occurrences.setProjection("Projection");
        //occurrences.setState(state);
        //occurrences.setMap(createMap());
        distributionArea.setEndemicFromBrazil(true);
        //distributionArea.setExtendOccurrence(100D);
        //distributionArea.setFramentationLevel(DefinitionLevel.HIGH);
        distributionArea.setGlobalDistribution("GlobalDistribution");
        distributionArea.setNationalDistribution("NationalDistribution");
        distributionArea.setNativeBrazil(true);
        //distributionArea.setOccupancyArea(100D);
        distributionArea.setOccurrences(Arrays.asList(occurrences));
        //distributionArea.setOcurrenceState("OcurrenceState");
        distributionArea.setOcurrsBrazil(true);
        distributionArea.setOnlyFromFewLocalities(true);
        distributionArea.setRegionIsWellSampled(true);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.EXPANDING);
        return distributionArea;
    }

    private NaturalHistory createNaturalHistory() {
        final NaturalHistory naturalHistory = new NaturalHistory();
        final FeedingBehavior feedingBehavior = new FeedingBehavior();
        final Habitat habitat = new Habitat();
        final Interactions interactions = new Interactions();
        final PopulationDynamics populationDynamics = new PopulationDynamics();
        final Reproduction reproduction = new Reproduction();
        final HabitatType habitatType = new HabitatType();
        final DensityData densityData = new DensityData();
        final PopulationTrend populationTrend = new PopulationTrend();
        habitatType.setId(1L);
        //feedingBehavior.setEatingHabitsType("EatingHabits");
        feedingBehavior.setEatingHabitsOtherComments("EatingHabitsOtherComments");
        //feedingBehavior.setFeedingAgregations("FeedingAgregations");
        habitat.setContinuingDeclineInHabitatQuality(true);
        //habitat.setDescription("Description");
        habitat.setRestrictedToPrimaryHabitats(true);
        habitat.setTolerantToHabitatModification("true");
        habitat.setType(habitatType);
        //habitat.setVariationInHabitatUse("VariationInHabitatUse");
        densityData.setExtremeFlutuationInSubpopulationsNumber(true);
        densityData.setSubPopulationsNumber(100L);
        densityData.setSubPopulationsNumberTrend(TrendOccurence.DECLINING);
        populationTrend.setBrazilExtinctionProbability(100D);
        populationTrend.setDeclineReversibleAndCeased(true);
        populationTrend.setPopDeclineJustification("PopDeclineJustification");
        //populationTrend.setPopulationDeclinedBasedOn("PopulationDeclinedBasedOn");
        populationDynamics.setCaptiveBreedingProgram(true);
        populationDynamics.setDeclinePeriodPercent(100D);
        populationDynamics.setDensityData(densityData);
        populationDynamics.setExtremeFlutuationInMatureIndividualsNumber(true);
        populationDynamics.setImatureIndividualsSubpopulationPercent(100D);
        populationDynamics.setMatureIndividualsNumber(100L);
        populationDynamics.setMatureIndividualsNumberTrend(TrendOccurence.EXPANDING);
        populationDynamics.setMatureIndividualsSubpopulationMaxNumber(100L);
        populationDynamics.setPopulationSeverelyFragmented(true);
        populationDynamics.setPopulationTrend(populationTrend);
        naturalHistory.setFeedingBehavior(feedingBehavior);
        naturalHistory.setHabitat(habitat);
        //naturalHistory.setInteractions(interactions);
        naturalHistory.setPopulationDynamics(populationDynamics);
        naturalHistory.setReproduction(reproduction);
        return naturalHistory;
    }

    private Taxonomy createTaxonomy() {
        final Taxonomy taxonomy = new Taxonomy();
        taxonomy.setId(1L);
        return taxonomy;
    }

    private Threat createThreat() {
        final Threat threat = new Threat();
        final FishingThreat fishingThreat = new FishingThreat();
        final ThreatStatus threatStatus = new ThreatStatus();
        final ThreatCategory category = new ThreatCategory();
        fishingThreat.setCpue("cpue");
        fishingThreat.setFishingEffort("FishingEffort");
        fishingThreat.setFishingGrounds("FishingGrounds");
        fishingThreat.setFishingPetrecho("FishingPetrecho");
        fishingThreat.setFishingScale("FishingScale");
        fishingThreat.setFishingTrend("FishingTrend");
        fishingThreat.setLandingCatch("LandingCatch");
        fishingThreat.setMarketValue("MarketValue");
        category.setId(1L);
        threatStatus.setCategory(category);
        threatStatus.setLocal("Local");
        threatStatus.setMunicipality("Municipality");
        threatStatus.setPeriod(1000L);
        threatStatus.setTime(1000L);
        threatStatus.setTrend("Trend");
        threat.setAffectedArea(100D);
        threat.setDeclineInNumberLocations(true);
        threat.setDescription("Description");
        threat.setDescriptionImpact("DescriptionImpact");
        threat.setExtremeFlutuationLocation(true);
        threat.setFishingThreat(fishingThreat);
        threat.setFutureThreatExistence(true);
        threat.setGeographicallyDistinctAreasNumber(100L);
        threat.setPopulationAffected(100000D);
        threat.setThreatStatus(threatStatus);
        return threat;
    }
}
