package com.unep.wcmc.model.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.unep.wcmc.model.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 *
 * @author Jose Carlos (jozecarlos.it@gmail.com)
 *
 */
public final class SpeciesSimpleSpecification {

    public static Specification<Species> filter(final SpeciesFilter filter) {
        return new Specification<Species>() {

            /*
             * (non-Javadoc)
             * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
             */
            @Override
            public Predicate toPredicate(Root<Species> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                final List<Predicate> predicates = new ArrayList<Predicate>();
                final Path<IntegrationSource> integration = root.get("integrationSource");
                predicates.add(builder.equal(integration.<Long>get("id"), 1));

                final String searchQuery = "%" + filter.getQuery() + "%";
                final Path<Taxonomy> taxonomy = root.<Taxonomy>get("taxonomy");
                final Path<Hierarchy> hierarchy = taxonomy.<Hierarchy>get("hierarchy");
                final Path<Kingdom> kingdom = hierarchy.<Kingdom>get("kingdom");
                final Path<Phylum> phylum = hierarchy.<Phylum>get("phylum");
                final Path<HierarchyClass> hierarchyClass = hierarchy.<HierarchyClass>get("hierarchyClass");
                final Path<HierarchyOrder> order = hierarchy.<HierarchyOrder>get("order");
                final Path<Family> family = hierarchy.<Family>get("family");
                final Path<Genus> genus = hierarchy.<Genus>get("genus");

                predicates.add(builder.or(
                                                        builder.like(
                                                                builder.lower(root.<String>get("commonName")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(root.<String>get("scientificName")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(hierarchy.<String>get("species")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(hierarchy.<String>get("subSpecies")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(kingdom.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(phylum.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(hierarchyClass.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(order.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(family.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"
                                                        ),
                                                        builder.like(
                                                                builder.lower(genus.<String>get("name")), "%" + searchQuery.toLowerCase() + "%"
                                                        )
                                                  ));

                return builder.and(predicates.toArray(new Predicate[predicates.size()]));

            }
        };
    }
}
