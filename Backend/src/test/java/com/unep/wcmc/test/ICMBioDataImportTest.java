package com.unep.wcmc.test;

import au.com.bytecode.opencsv.CSVReader;
import com.unep.wcmc.Application;
import com.unep.wcmc.model.*;
import com.unep.wcmc.repository.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileReader;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ICMBioDataImportTest {

    @Autowired
    private KingdomRepository kingdomRepository;

    @Autowired
    private HierarchyClassRepository classRepository;

    @Autowired
    private PhylumRepository phylumRepository;

    @Autowired
    private HierarchyOrderRepository orderRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private TaxonomyRepository taxonomyRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistributionAreaRepository distributionAreaRepository;

    @Autowired
    private SpecieRepository specieRepository;

    @Test
    public void testImportOccurencesICMBioSpeciesFromCSV() throws Exception {
        // CSV fields
        //kingdom,phylum,class,order,family,genus,specificEpithet,infraspecificEpithet,species,scientificName,taxonRank,group,
        //decimalLatitude,decimalLongitude,geodeticDatum,continent,country,stateProvince,municipality,locality,basisOfRecord,
        // occurrenceRemarks,establishmentMeans,eventDate,habitat,locationRemarks,occurrenceStatus,georeferenceSources,compilador,references

        CSVReader reader = new CSVReader(new FileReader("src/test/resources/Occurences_ICMBio_brazilian_species.csv"));
        String[] line = reader.readNext();
        while (line != null) {
            List<Taxonomy> list = taxonomyRepository.findByHierarchySpeciesSoundex(line[8].trim());
            Assert.assertNotNull(list);
            Assert.assertFalse(list.isEmpty());
            createOccurence(line, list.get(0));
            line = reader.readNext();
        }
    }

    private Occurrence createOccurence(String[] line, Taxonomy taxonomy) {
        DistributionArea distributionArea = taxonomy.getSpecie().getDistributionArea();
        if (distributionArea == null) {
            distributionArea = new DistributionArea();
        }
        State state = stateRepository.findByCode(line[17].trim());
        Map map = new Map(line[19].trim(), null, line[29].trim(), null, null, null, false);
        Occurrence occurrence = new Occurrence(line[12].trim(), line[13].trim(), line[19].trim(), state, map);
        distributionArea.getOccurrences().add(occurrence);
        distributionAreaRepository.save(distributionArea);
        return occurrence;
    }

    @Test
    public void testImportTaxonomicICMBioSpeciesFromCSV() throws Exception {
        // CSV fields
        //Reino,Filo,Classe,Ordem,Familia,Genero,Epiteto Especifico,Subespecie,species,Nome cientifico,Nome Comum

        CSVReader reader = new CSVReader(new FileReader("src/test/resources/Taxonomic_ICMBio_brazilian_species.csv"));
        String[] line = reader.readNext();
        while (line != null) {

            Taxonomy taxonomy = createTaxonomy(line);
            Assert.assertNotNull(taxonomy);
            Assert.assertNotNull(taxonomy.getId());

            Specie specie = createSpecie(line, taxonomy);
            Assert.assertNotNull(specie);
            Assert.assertNotNull(specie.getId());

            line = reader.readNext();
        }
    }

    private Taxonomy createTaxonomy(String[] line) {
        Kingdom kingdom = getKingdom(line[0].trim());
        Phylum phylum = getPhylum(line[1].trim());
        HierarchyClass hierarchyClass = getHierarchyClass(line[2].trim());
        HierarchyOrder order = getHierarchyOrder(line[3].trim());
        Family family = getFamily(line[4].trim());
        Gender gender = getGender(line[5].trim());

        String subespecies = line[7].trim();
        String species = line[8].trim();

        Hierarchy hierarchy = new Hierarchy(kingdom, phylum, hierarchyClass, order, family,
                gender, species, subespecies);
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setHierarchy(hierarchy);
        return taxonomyRepository.save(taxonomy);
    }

    private Specie createSpecie(String[] line, Taxonomy taxonomy) {
        String scientificName = line[9].trim();
        String commonName = line[10].trim();

        Specie specie = new Specie();
        specie.setCommonName(commonName);
        specie.setScientificName(scientificName);
        specie.setTaxonomy(taxonomy);
        return specieRepository.save(specie);
    }

    private Kingdom getKingdom(String name) {
        Kingdom kingdom = kingdomRepository.findByName(name);
        if (kingdom == null) {
            kingdom = new Kingdom(name);
            kingdom = kingdomRepository.save(kingdom);
        }
        return kingdom;
    }

    private Phylum getPhylum(String name) {
        Phylum phylum = phylumRepository.findByName(name);
        if (phylum == null) {
            phylum = new Phylum(name);
            phylum = phylumRepository.save(phylum);
        }
        return phylum;
    }

    private HierarchyClass getHierarchyClass(String name) {
        HierarchyClass hierarchyClass = classRepository.findByName(name);
        if (hierarchyClass == null) {
            hierarchyClass = new HierarchyClass(name);
            hierarchyClass = classRepository.save(hierarchyClass);
        }
        return hierarchyClass;
    }

    private HierarchyOrder getHierarchyOrder(String name) {
        HierarchyOrder hierarchyOrder = orderRepository.findByName(name);
        if (hierarchyOrder == null) {
            hierarchyOrder = new HierarchyOrder(name);
            hierarchyOrder = orderRepository.save(hierarchyOrder);
        }
        return hierarchyOrder;
    }

    private Family getFamily(String name) {
        Family family = familyRepository.findByName(name);
        if (family == null) {
            family = new Family(name);
            family = familyRepository.save(family);
        }
        return family;
    }

    private Gender getGender(String name) {
        Gender gender = genderRepository.findByName(name);
        if (gender == null) {
            gender = new Gender(name);
            gender = genderRepository.save(gender);
        }
        return gender;
    }

}
