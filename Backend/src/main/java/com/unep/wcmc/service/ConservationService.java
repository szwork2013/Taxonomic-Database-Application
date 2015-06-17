package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Conservation;
import com.unep.wcmc.repository.ConservationRepository;

@Service
public final class ConservationService extends AbstractService<Conservation, ConservationRepository> {
}
