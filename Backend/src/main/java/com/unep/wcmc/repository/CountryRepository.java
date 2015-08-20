package com.unep.wcmc.repository;

import com.unep.wcmc.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByName(String name);

}
