package com.unep.wcmc.integration.fauna;

import com.unep.wcmc.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@SuppressWarnings("all")
public class FaunaProcessor implements ItemProcessor<String[], Species> {

    protected static final Log logger = LogFactory.getLog(FaunaProcessor.class);

    @Override
    public Species process(String[] item) throws Exception {
        Taxonomy taxonomy = createTaxonomy(item);
        return createSpecies(item, taxonomy);
    }

    private Taxonomy createTaxonomy(String[] line) {
        Kingdom kingdom = new Kingdom(line[0].trim());
        Phylum phylum =  new Phylum(line[1].trim());
        HierarchyClass hierarchyClass = new HierarchyClass(line[2].trim());
        HierarchyOrder order = new HierarchyOrder(line[3].trim());
        Family family = new Family(line[4].trim());
        Genus genus = new Genus(line[5].trim());

        String subespecies = line[7].trim();
        String species = line[8].trim();

        Hierarchy hierarchy = new Hierarchy(kingdom, phylum, hierarchyClass, order, family,
                genus, subespecies);
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setHierarchy(hierarchy);
        return taxonomy;
    }

    private Species createSpecies(String[] line, Taxonomy taxonomy) {
        String scientificName = line[9].trim();
        String commonName = line[10].trim();

        Species specie = new Species();
        specie.setCommonName(commonName);
        specie.setScientificName(scientificName);
        specie.setTaxonomy(taxonomy);
        specie.setType(Species.SpeciesType.FAUNA);
        return specie;
    }

}
