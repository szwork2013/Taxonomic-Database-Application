package com.unep.wcmc.service;

import com.unep.wcmc.model.dto.SpeciesSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.filter.SpeciesFilter;
import com.unep.wcmc.model.filter.SpeciesSpecification;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import com.unep.wcmc.repository.SpeciesRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        List<SpeciesSearchDTO> result = new ArrayList<>();
        Page<Species> speciesList = repo.findAll(SpeciesSpecification.filter(filter), pageable);
        Iterator<Species> it = speciesList.iterator();
        while (it.hasNext()) {
            Species species = it.next();
            SpeciesSearchDTO dto = new SpeciesSearchDTO();
            dto.setId(species.getId());
            if (species.getCommonName().contains(filter.getQuery())) {
                dto.setCommonName(species.getCommonName());
            } else if (species.getScientificName().contains(filter.getQuery())) {
                dto.setScientificName(species.getScientificName());
            }
            result.add(dto);
        }
        return result;
    }

    public Page<Species> findAll(SpeciesFilter filter, Pageable pageable) {
		return repo.findAll(SpeciesSpecification.filter(filter), pageable);
    }
}