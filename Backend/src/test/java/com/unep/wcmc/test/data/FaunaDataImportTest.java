package com.unep.wcmc.test.data;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FaunaDataImportTest {

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
    private GenusRepository genusRepository;

    @Autowired
    private TaxonomyRepository taxonomyRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private DistributionAreaRepository distributionAreaRepository;

    @Autowired
    private SpeciesRepository specieRepository;

    @Test
    @Ignore // Ignoring this test case to not be executed all the time
    public void testImportTaxonomicICMBioSpeciesFromCSV() throws Exception {
        // CSV fields
        //Reino,Filo,Classe,Ordem,Familia,Genero,Epiteto Especifico,Subespecie,species,Nome cientifico,Nome Comum

        CSVReader reader = new CSVReader(new FileReader("src/test/resources/Taxonomic_ICMBio_brazilian_species.csv"));
        String[] line = reader.readNext();
        while (line != null) {

            Taxonomy taxonomy = createTaxonomy(line);
            Assert.assertNotNull(taxonomy);
            Assert.assertNotNull(taxonomy.getId());

            Species specie = createSpecies(line, taxonomy);
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
        Genus genus = getGenus(line[5].trim());

        String subespecies = line[7].trim();
        String species = line[8].trim();

        Hierarchy hierarchy = new Hierarchy(kingdom, phylum, hierarchyClass, order, family,
                genus, species, subespecies);
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setHierarchy(hierarchy);
        return taxonomyRepository.save(taxonomy);
    }

    private Species createSpecies(String[] line, Taxonomy taxonomy) {
        String scientificName = line[9].trim();
        String commonName = line[10].trim();

        Species specie = new Species();
        //specie.setCommonName(commonName);
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

    private Genus getGenus(String name) {
        Genus gender = genusRepository.findByName(name);
        if (gender == null) {
            gender = new Genus(name);
            gender = genusRepository.save(gender);
        }
        return gender;
    }

    @Test
    //@Ignore // ignoring this test case to not be executed all the time
    public void testImportOccurencesICMBioSpeciesFromCSV() throws Exception {
        // CSV fields
        //kingdom,phylum,class,order,family,genus,specificEpithet,infraspecificEpithet,species,scientificName,taxonRank,group,
        //decimalLatitude,decimalLongitude,geodeticDatum,continent,country,stateProvince,municipality,locality,basisOfRecord,
        // occurrenceRemarks,establishmentMeans,eventDate,habitat,locationRemarks,occurrenceStatus,georeferenceSources,compilador,references

        CSVReader reader = new CSVReader(new FileReader("src/main/resources/data/Occurences_ICMBio_brazilian_species.csv"));
        String[] line = reader.readNext();
        while (line != null) {
            List<Species> list = specieRepository.findByNameSoundex(line[8].trim());
            if (list != null && !list.isEmpty()) {
                createOccurence(line, list.get(0));
            }
            line = reader.readNext();
        }
    }

    private Occurrence createOccurence(String[] line, Species species) {
        DistributionArea distributionArea;
        if (species.getDistributionArea() != null) {
            distributionArea = species.getDistributionArea();
        } else {
            distributionArea = new DistributionArea();
            species.setDistributionArea(distributionArea);
        }

        State state = stateRepository.findByCode(line[17].trim());
        Country country = countryRepository.findByName("Brazil");
        Occurrence occurrence = new Occurrence(line[12].trim(), line[13].trim(), line[19].trim(), state);
        occurrence.setCreatedAt(new Date());
        occurrence.setCountry(country);
        occurrence.setMunicipality(line[19].trim());
        occurrence.setCompiler(line[28].trim());
        occurrence.setReference(line[29].trim());

        List<Occurrence> occurrences = distributionArea.getOccurrences();
        if (occurrences == null) {
            occurrences = new ArrayList<>();
            distributionArea.setOccurrences(occurrences);
        }
        occurrences.add(occurrence);
        specieRepository.save(species);
        return occurrence;
    }

}
