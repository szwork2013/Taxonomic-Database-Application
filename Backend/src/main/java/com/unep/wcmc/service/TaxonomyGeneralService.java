package com.unep.wcmc.service;


import com.unep.wcmc.model.TaxonomyGeneral;
import com.unep.wcmc.repository.TaxonomyGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxonomyGeneralService implements BaseService<TaxonomyGeneral> {

    @Autowired
    TaxonomyGeneralRepository general;

    @Override
    public TaxonomyGeneral save(TaxonomyGeneral entity) {

        return general.save(entity);
    }

    @Override
    public Iterable<TaxonomyGeneral> list() {

        return (List<TaxonomyGeneral>) general.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        general.delete(id);

        return true;
    }

    @Override
    public TaxonomyGeneral get(Long id) {

        return general.findOne(id);
    }
}
