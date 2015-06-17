package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.repository.TaxonomyRepository;

@Service
public class TaxonomyService extends AbstractService<Taxonomy, TaxonomyRepository> {
}
