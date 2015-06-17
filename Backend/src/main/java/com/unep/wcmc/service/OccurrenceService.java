package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Occurrence;
import com.unep.wcmc.repository.OccurrenceRepository;

@Service
public final class OccurrenceService extends AbstractService<Occurrence, OccurrenceRepository> {
}
