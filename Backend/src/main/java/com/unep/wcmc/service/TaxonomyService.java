package com.unep.wcmc.service;

import com.unep.wcmc.model.Hierarchy;
import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.repository.TaxonomyRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaxonomyService extends AbstractService<Taxonomy, TaxonomyRepository> {

    public Taxonomy findOrSave(Taxonomy taxonomy) {
        if (taxonomy != null) {
            List<Taxonomy> taxonomyList = findByHierarchy(taxonomy);
            if (taxonomyList != null && !taxonomyList.isEmpty()) {
                taxonomy = taxonomyList.get(0);
            } else {
                taxonomy.setEnabled(true);
                taxonomy.setLastModified(new Date());
                taxonomy = repo.save(taxonomy);
            }
        }
        return taxonomy;
    }

    public List<Taxonomy> findByHierarchy(Taxonomy taxonomy) {
        Hierarchy hierarchy = taxonomy.getHierarchy();
        // get the hierarchy specific values
        String kingdom = "null";
        if (hierarchy.getKingdom() != null) {
            kingdom = hierarchy.getKingdom().getName();
        }
        String phylum = "null";
        if (hierarchy.getPhylum() != null) {
            phylum = hierarchy.getPhylum().getName();
        }
        String hierarchyClass = "null";
        if (hierarchy.getHierarchyClass() != null) {
            hierarchyClass = hierarchy.getHierarchyClass().getName();
        }
        String order = "null";
        if (hierarchy.getOrder() != null) {
            order = hierarchy.getOrder().getName();
        }
        String family = "null";
        if (hierarchy.getFamily() != null) {
            family = hierarchy.getFamily().getName();
        }
        String genus = "null";
        if (hierarchy.getGenus() != null) {
            genus = hierarchy.getGenus().getName();
        }
        return repo.findByHierarchyValues(kingdom, phylum, hierarchyClass, order, family, genus);
    }

}