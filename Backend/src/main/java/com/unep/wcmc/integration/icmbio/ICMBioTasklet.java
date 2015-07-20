package com.unep.wcmc.integration.icmbio;

import au.com.bytecode.opencsv.CSVReader;
import com.unep.wcmc.model.*;
import com.unep.wcmc.repository.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class ICMBioTasklet implements Tasklet {

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
    private SpeciesRepository specieRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // CSV fields
        //Reino,Filo,Classe,Ordem,Familia,Genero,Epiteto Especifico,Subespecie,species,Nome cientifico,Nome Comum

        CSVReader reader = new CSVReader(new FileReader("src/test/resources/Taxonomic_ICMBio_brazilian_species.csv"));
        String[] line = reader.readNext();
        while (line != null) {
            Taxonomy taxonomy = createTaxonomy(line);
            createSpecies(line, taxonomy);

            line = reader.readNext();
        }

        return RepeatStatus.FINISHED;
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

    private Genus getGenus(String name) {
        Genus gender = genusRepository.findByName(name);
        if (gender == null) {
            gender = new Genus(name);
            gender = genusRepository.save(gender);
        }
        return gender;
    }

}