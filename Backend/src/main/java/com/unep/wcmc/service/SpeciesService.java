package com.unep.wcmc.service;

import java.util.ArrayList;
import java.util.List;

import com.unep.wcmc.model.filter.SpeciesSimpleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Hierarchy;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.model.dto.SpeciesSearchDTO;
import com.unep.wcmc.model.filter.SpeciesFilter;
import com.unep.wcmc.model.filter.SpeciesSpecification;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import com.unep.wcmc.repository.SpeciesRepository;

@Service
public final class SpeciesService extends AbstractService<Species, SpeciesRepository> {

    @Autowired
    private ExtinctionRiskService extinctionRiskService;

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    public Species findByCommonName(String commonName) {
        return repo.findByCommonName(commonName);
    }

    public Species findOrSave(Species species) {
        if (species != null) {
            Species existing = repo.findByScientificName(species.getScientificName());
            if (existing == null) {
                if (species.getIntegrationSource() != null) {
                    IntegrationSource integration =
                            integrationRepo.findBySource(species.getIntegrationSource().getSource());
                    species.setIntegrationSource(integration);
                }
                species = repo.save(species);
            } else {
                species = existing;
            }
        }
        return species;
    }

    @Override
    public Species save(Species specie) {
        extinctionRiskService.processExtinctionRiskCalculation(specie);
        return super.save(specie);
    }

    public List<SpeciesSearchDTO> findToDropdown(SpeciesFilter filter, Pageable pageable) {
    	String query = filter.getQuery();
    	List<SpeciesSearchDTO> result = new ArrayList<>();
        Page<Species> speciesList = repo.findAll(SpeciesSimpleSpecification.filter(filter), pageable);
        for (Species species : speciesList) {
        	Taxonomy taxonomy = species.getTaxonomy();
            SpeciesSearchDTO dto = new SpeciesSearchDTO();
            dto.setId(species.getId());
            dto.setCommonName(species.getCommonName());
            dto.setScientificName(species.getScientificName());
            if (!species.getScientificName().contains(query) && !species.getCommonName().contains(query)) {
                if (taxonomy != null && taxonomy.getHierarchy() != null) {
                    Hierarchy hierarchy = taxonomy.getHierarchy();
                    if ((hierarchy.getKingdom() != null) &&
                            (hierarchy.getKingdom().getName().contains(query))) {
                        dto.setKingdomName(hierarchy.getKingdom().getName());
                    } else if ((hierarchy.getPhylum() != null) &&
                            (hierarchy.getPhylum().getName().contains(query))) {
                        dto.setPhylumName(hierarchy.getPhylum().getName());
                    } else if ((hierarchy.getHierarchyClass() != null) &&
                            (hierarchy.getHierarchyClass().getName().contains(query))) {
                        dto.setHierarchyClassName(hierarchy.getHierarchyClass().getName());
                    } else if ((hierarchy.getOrder() != null) &&
                            (hierarchy.getOrder().getName().contains(query))) {
                        dto.setHierarchyOrderName(hierarchy.getOrder().getName());
                    } else if ((hierarchy.getFamily() != null) &&
                            (hierarchy.getFamily().getName().contains(query))) {
                        dto.setFamilyName(hierarchy.getFamily().getName());
                    } else if ((hierarchy.getGenus() != null) &&
                            (hierarchy.getGenus().getName().contains(query))) {
                        dto.setGenusName(hierarchy.getGenus().getName());
                    } else if ((hierarchy.getSpecies() != null) &&
                            (hierarchy.getSpecies().contains(query))) {
                        dto.setSpeciesName(hierarchy.getSpecies());
                    } else if ((hierarchy.getSubSpecies() != null) &&
                            (hierarchy.getSubSpecies().contains(query))) {
                        dto.setSpeciesName(hierarchy.getSubSpecies());
                    }
                }
            }
            result.add(dto);
        }
        return result;
    }
    

    public Page<Species> findAll(SpeciesFilter filter, Pageable pageable) {
		return repo.findAll(SpeciesSpecification.filter(filter), pageable);
    }
}