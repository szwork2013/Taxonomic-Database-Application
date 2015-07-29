package com.unep.wcmc.repository.filter;

import com.unep.wcmc.model.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Carlos (jozecarlos.it@gmail.com)
 *
 */
public final class SpeciesSimpleSpecification {

    public static Specification<Species> filter(final SpeciesFilter filter) {
        return new Specification<Species>() {

            @Override
            public Predicate toPredicate(Root<Species> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                final List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(builder.equal(root.<Boolean>get("enabled"), true));

                final String searchQuery = "%" + filter.getQuery() + "%";
                final Path<Taxonomy> taxonomy = root.<Taxonomy>get("taxonomy");
                final Path<Hierarchy> hierarchy = taxonomy.<Hierarchy>get("hierarchy");
                final Path<Kingdom> kingdom = hierarchy.<Kingdom>get("kingdom");
                final Path<Phylum> phylum = hierarchy.<Phylum>get("phylum");
                final Path<HierarchyClass> hierarchyClass = hierarchy.<HierarchyClass>get("hierarchyClass");
                final Path<HierarchyOrder> order = hierarchy.<HierarchyOrder>get("order");
                final Path<Family> family = hierarchy.<Family>get("family");
                final Path<Genus> genus = hierarchy.<Genus>get("genus");

                predicates.add(builder.or(builder.like(
                                builder.lower(root.<String>get("commonName")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(root.<String>get("scientificName")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(hierarchy.<String>get("species")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(hierarchy.<String>get("subSpecies")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(kingdom.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(phylum.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(hierarchyClass.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(order.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(family.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"),
                        builder.like(builder.lower(genus.<String>get("name")), "%" + searchQuery.toLowerCase() + "%")
                ));

                return builder.and(predicates.toArray(new Predicate[predicates.size()]));

            }
        };
    }
}
