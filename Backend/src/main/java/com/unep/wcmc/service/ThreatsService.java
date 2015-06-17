package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Threats;
import com.unep.wcmc.repository.ThreatsRepository;

@Service
public final class ThreatsService extends AbstractService<Threats, ThreatsRepository> {
}
