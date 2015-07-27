package com.unep.wcmc.service;

import com.unep.wcmc.model.ExceptionOccurrence;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.ExceptionOccurrenceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class ExceptionOccurrenceService extends AbstractService<ExceptionOccurrence, ExceptionOccurrenceRepository> {

    public Page<ExceptionOccurrence> findByFilter(String filter, Pageable pageable) {
        return repo.findByTitleContaining(filter, pageable);
    }

    public List<Object[]> findExceptionsSummary(Species.SpeciesType type) {
        return repo.findExceptionsSummary(type);
    }

}
