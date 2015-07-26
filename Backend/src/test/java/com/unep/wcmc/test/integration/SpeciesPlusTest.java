package com.unep.wcmc.test.integration;

import com.unep.wcmc.Application;
import com.unep.wcmc.service.SpeciesPlusService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@SuppressWarnings("all")
public class SpeciesPlusTest {

    @Autowired
    private SpeciesPlusService speciesPlusService;

    @Test
    public void testNextTaxonPage() {
        Map<String, Object> taxonResults = speciesPlusService.nextTaxonPage();
        Assert.assertNotNull(taxonResults);
        Assert.assertFalse(taxonResults.isEmpty());
    }

    @Test
    public void testGetTaxonConcepts() {
        Map<String, Object> taxonResults = speciesPlusService.getTaxonConcepts(1, 10);
        Assert.assertNotNull(taxonResults);
        Assert.assertFalse(taxonResults.isEmpty());
    }

    @Test
    public void testGetTaxonDistributions() {
        Map<String, Object> taxonResults = speciesPlusService.getTaxonConcepts(1, 10);
        Assert.assertNotNull(taxonResults);
        Assert.assertFalse(taxonResults.isEmpty());

        List<Map<String, Object>> taxonConcepts = (List<Map<String, Object>>)
                taxonResults.get("taxon_concepts");

        for (Map<String, Object> taxon : taxonConcepts) {
            String id = String.valueOf(taxon.get("id"));
            List<Object> distributionResults =
                    speciesPlusService.getTaxonDistributions(Long.parseLong(id));
            Assert.assertNotNull(distributionResults);
            Assert.assertFalse(distributionResults.isEmpty());
        }
    }

    @Test
    public void testGetTaxonCitiesLegislation() {
        Map<String, Object> taxonResults = speciesPlusService.getTaxonConcepts(1, 10);
        Assert.assertNotNull(taxonResults);
        Assert.assertFalse(taxonResults.isEmpty());

        List<Map<String, Object>> taxonConcepts = (List<Map<String, Object>>)
                taxonResults.get("taxon_concepts");

        for (Map<String, Object> taxon : taxonConcepts) {
            String id = String.valueOf(taxon.get("id"));
            Map<String, Object> citiesResults =
                    speciesPlusService.getTaxonCitiesLegislation(Long.parseLong(id));
            Assert.assertNotNull(citiesResults);
            Assert.assertFalse(citiesResults.isEmpty());
        }
    }

    @Test
    public void testGetTaxonReferences() {
        Map<String, Object> taxonResults = speciesPlusService.getTaxonConcepts(1, 10);
        Assert.assertNotNull(taxonResults);
        Assert.assertFalse(taxonResults.isEmpty());

        List<Map<String, Object>> taxonConcepts = (List<Map<String, Object>>)
                taxonResults.get("taxon_concepts");

        for (Map<String, Object> taxon : taxonConcepts) {
            String id = String.valueOf(taxon.get("id"));
            List<Object> referencesResults =
                    speciesPlusService.getTaxonReferences(Long.parseLong(id));
            Assert.assertNotNull(referencesResults);
            Assert.assertFalse(referencesResults.isEmpty());
        }
    }

}