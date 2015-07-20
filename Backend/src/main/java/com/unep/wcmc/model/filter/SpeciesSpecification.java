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
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class SpeciesSpecification {

	public static Specification<Species> filter(final SpeciesFilter filter) {
		return new Specification<Species>() {
			
			/*
			 * (non-Javadoc)
			 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
			 */
			@Override
			public Predicate toPredicate(Root<Species> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				final List<Predicate> predicates = new ArrayList<Predicate>();
				final Path<DistributionArea> distributionArea = root.<DistributionArea>get("distributionArea");
				final Path<Conservation> conservationPath = root.<Conservation>get("conservation");
				final Path<NaturalHistory> naturalHistory = root.<NaturalHistory>get("naturalHistory");

				// HINT: Only searching for Species from ICMBio
				//final Path<IntegrationSource> integration = root.get("integrationSource");
			//	predicates.add(cb.equal(integration.<Long>get("id"), 1));

				predicates.add(searchByName(root, query, cb));
				
				if (!StringUtils.isEmpty(filter.getEndemicFromBrazil())) {

					predicates.add(cb.equal(distributionArea.get("endemicFromBrazil"), filter.getEndemicFromBrazil()));
				}
				if (!StringUtils.isEmpty(filter.getOccurrenceState())) {

					predicates.add(cb.equal(distributionArea.get("ocurrenceState"), filter.getOccurrenceState()));
				}
				if (!StringUtils.isEmpty(filter.getOccurrenceBiomes())) {

					predicates.add(cb.equal(distributionArea.get("ocurrenceBiomes"), filter.getOccurrenceBiomes()));
				}
				if (!StringUtils.isEmpty(filter.getOccurrenceProtectedAreas())) {

					predicates.add(cb.equal(distributionArea.get("ocurrenceProtectedAreas"), filter.getOccurrenceProtectedAreas()));
				}
				if (!StringUtils.isEmpty(filter.getExtinctionRiskCategory())) {

					final Predicate extinctionRiskCategory = cb.equal(root.<ExtinctionRiskCategory>get("extinctionRiskCategory"), filter.getExtinctionRiskCategoryEnum());
					predicates.add(extinctionRiskCategory);
				}
				if (!StringUtils.isEmpty(filter.getHabitat())) {

					final Path<Habitat> habitatPath = naturalHistory.<Habitat>get("habitat");
					predicates.add(cb.equal(habitatPath.<HabitatType>get("type").<Long>get("id"), filter.getHabitat()));
				}
				if (!StringUtils.isEmpty(filter.getActionPlan())) {

					predicates.add(cb.equal(conservationPath.<ConservationAction>get("conservationAction").<String>get("benefitedActionPlan"), filter.getActionPlan()));
				}

				if (!StringUtils.isEmpty(filter.getInNationalEndangeredFauna())) {

					predicates.add(cb.equal(conservationPath.<ExtinctionRisk>get("extinctionRisk").<Boolean>get("inNationalEndangeredFauna"), filter.getInNationalEndangeredFauna()));
				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			
			private Predicate searchByName(Root<Species> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				final Path<Taxonomy> taxonomy = root.<Taxonomy>get("taxonomy");
				final Path<Hierarchy> hierarchy = taxonomy.<Hierarchy>get("hierarchy");
				final Path<Kingdom> kingdom = hierarchy.<Kingdom>get("kingdom");
				final Path<Phylum> phylum = hierarchy.<Phylum>get("phylum");
				final Path<HierarchyClass> hierarchyClass = hierarchy.<HierarchyClass>get("hierarchyClass");
				final Path<HierarchyOrder> order = hierarchy.<HierarchyOrder>get("order");
				final Path<Family> family = hierarchy.<Family>get("family");
				final Path<Genus> genus = hierarchy.<Genus>get("genus");
				
				final String searchQuery = "%" + filter.getQuery().toLowerCase() + "%";
				final Predicate commonName = cb.like(cb.lower(root.<String>get("commonName")), searchQuery);
				final Predicate scientificName = cb.like(cb.lower(root.<String>get("scientificName")), searchQuery);
				final Predicate species = cb.like(cb.lower(hierarchy.<String>get("species")), searchQuery);
				final Predicate subSpecies = cb.like(cb.lower(hierarchy.<String>get("subSpecies")), searchQuery);
				final Predicate kingdomName = cb.like(cb.lower(kingdom.<String>get("name")), searchQuery);
				final Predicate phylumName = cb.like(cb.lower(phylum.<String>get("name")), searchQuery);
				final Predicate hierarchyClassName = cb.like(cb.lower(hierarchyClass.<String>get("name")), searchQuery);
				final Predicate orderName = cb.like(cb.lower(order.<String>get("name")), searchQuery);
				final Predicate familyName = cb.like(cb.lower(family.<String>get("name")), searchQuery);
				final Predicate genusName = cb.like(cb.lower(genus.<String>get("name")), searchQuery);
				return cb.or(commonName, scientificName, species, subSpecies, kingdomName, phylumName, hierarchyClassName, orderName, familyName, genusName);
			}
		};
	}
}
