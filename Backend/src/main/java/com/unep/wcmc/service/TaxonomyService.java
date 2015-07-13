package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.repository.TaxonomyRepository;

@Service
public class TaxonomyService extends AbstractService<Taxonomy, TaxonomyRepository> {

    public Taxonomy findOrSave(Taxonomy taxonomy) {
        taxonomy = new Taxonomy(); //repo.findBy...(name);
        if (taxonomy == null) {
            //taxonomy = new Taxonomy(name);
            taxonomy = repo.save(taxonomy);
        }
        return taxonomy;
    }
}
