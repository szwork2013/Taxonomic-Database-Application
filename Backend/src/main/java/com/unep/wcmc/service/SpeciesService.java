package com.unep.wcmc.service;

import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.model.ExceptionOccurrence;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.ChangeLogRepository;
import com.unep.wcmc.repository.ExceptionOccurrenceRepository;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import com.unep.wcmc.repository.SpeciesRepository;
import com.unep.wcmc.repository.filter.SpeciesFilter;
import com.unep.wcmc.repository.filter.SpeciesSimpleSpecification;
import com.unep.wcmc.repository.filter.SpeciesSpecification;
import com.unep.wcmc.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.unep.wcmc.model.UserRole.RoleType.*;

@Service
public final class SpeciesService extends AbstractService<Species, SpeciesRepository> {

    @Autowired
    private ExtinctionRiskService extinctionRiskService;

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    @Autowired
    private ExceptionOccurrenceRepository exceptionRepo;

    @Autowired
    private MetadataService metadataService;

    @Autowired
    private ChangeLogRepository changeLogRepo;

    /**
     * Find Species by the common name
     * @param commonName
     * @return
     */
    public Species findByCommonName(String commonName) {
        return repo.findByName(commonName);
    }

    public List<Species> findByScientificName(String scientificName) {
        return repo.findByScientificName(scientificName);
    }

    public List<Species> findByScientificNameSimilaries(String scientificName) {
        return repo.findByScientificNameSoundex(scientificName);
    }

    public List<Species> findBySpeciesName(String species) {
        return repo.findByTaxonomyHierarchySpeciesEpiteth(species);
    }

    public List<Species> findBySpeciesNameSimilaries(String species) {
        return repo.findByNameSoundex(species);
    }

    public ExceptionOccurrence raiseSpeciesException(Species active, Species suggested,
                                                     IntegrationSource.Source source) {
        return raiseSpeciesException(active, suggested, ExceptionOccurrence.Severity.MINOR, source);
    }


    /**
     * Raise species data exception into the database
     *
     * @param active
     * @param suggested
     * @param severity
     * @param source
     * @return
     */
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

    /**
     * Save the species data into the database processing the extinction risk algorithm
     *
     * @param species
     * @return
     */
    public Species doSave(Species species) {
        extinctionRiskService.processExtinctionRiskCalculation(species);
        species.setLastModified(new Date());

        return super.save(species);
    }

    /**
     * Save the species data or the metadata into the database according with the logged user privileges.
     *
     * @param species
     * @return
     */
    @Override
    public Species save(Species species) {
        if (SecurityUtils.hasAnyRole(ADMIN, SUPERADMIN, EXPERT)) {
            if (species.getId() != null) {
                Species existing = super.get(species.getId());
                species.setThreats(existing.getThreats());
            }
            return doSave(species);

        } else if (SecurityUtils.hasRole(PUBLIC_USER)) {
            if (species.getId() != null) {
                List<ChangeLog> changeLogs = metadataService.processMetadata(species);
                changeLogRepo.save(changeLogs);
            }
        }
        return species;
    }

    public Page<Species> findByTerm(SpeciesFilter filter, Pageable pageable) {
        return repo.findAll(SpeciesSimpleSpecification.filter(filter), pageable);
    }

    public Page<Species> findByFilter(SpeciesFilter filter, Pageable pageable) {
		return repo.findAll(SpeciesSpecification.filter(filter), pageable);
    }
}