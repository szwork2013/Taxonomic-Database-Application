package com.unep.wcmc.service;

import com.unep.wcmc.model.ExceptionOccurrence;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.ExceptionOccurrenceRepository;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import com.unep.wcmc.repository.SpeciesRepository;
import com.unep.wcmc.repository.filter.SpeciesFilter;
import com.unep.wcmc.repository.filter.SpeciesSimpleSpecification;
import com.unep.wcmc.repository.filter.SpeciesSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public final class SpeciesService extends AbstractService<Species, SpeciesRepository> {

    @Autowired
    private ExtinctionRiskService extinctionRiskService;

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    @Autowired
    private ExceptionOccurrenceRepository exceptionRepo;

    public Species findByCommonName(String commonName) {
        return repo.findByCommonName(commonName);
    }

    public List<Species> findByScientificName(String scientificName) {
        return repo.findByScientificName(scientificName);
    }

    public List<Species> findByScientificNameSimilaries(String scientificName) {
        return repo.findByScientificNameSoundex(scientificName);
    }

    public List<Species> findBySpeciesName(String species) {
        return new ArrayList<>();
        //return repo.findByTaxonomyHierarchySpecies(species);
    }

    public List<Species> findBySpeciesNameSimilaries(String species) {
        return new ArrayList<>();
        //return repo.findByTaxonomySpeciesSoundex(species);
    }

    public ExceptionOccurrence raiseSpeciesException(Species active, Species suggested,
                                                     IntegrationSource.Source source) {
        return raiseSpeciesException(active, suggested, ExceptionOccurrence.Severity.MINOR, source);
    }


    public ExceptionOccurrence raiseSpeciesException(Species active, Species suggested,
                                                     ExceptionOccurrence.Severity severity,
                                                     IntegrationSource.Source source) {
        ExceptionOccurrence exception = new ExceptionOccurrence();
        exception.setActive(active);
        exception.setSuggested(suggested);
        exception.setCreatedAt(new Date());
        exception.setStatus(ExceptionOccurrence.Status.UNRESOLVED);
        exception.setSeverity(severity);
        exception.setTitle(suggested.getScientificName());
        exception.setUpdatedAt(new Date());
        exception.setIntegrationSource(integrationRepo.findBySource(source));
        return exceptionRepo.save(exception);
    }

    @Override
    public Species save(Species specie) {
        extinctionRiskService.processExtinctionRiskCalculation(specie);
        specie.setLastModified(new Date());
        return super.save(specie);
    }

    public Page<Species> findByTerm(SpeciesFilter filter, Pageable pageable) {
        return repo.findAll(SpeciesSimpleSpecification.filter(filter), pageable);
    }

    public Page<Species> findByFilter(SpeciesFilter filter, Pageable pageable) {
		return repo.findAll(SpeciesSpecification.filter(filter), pageable);
    }
}