package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Country;
import com.unep.wcmc.repository.CountryRepository;

@Service
public final class CountryService extends AbstractService<Country, CountryRepository> {
}
