package com.unep.wcmc.repository.filter;

import com.unep.wcmc.model.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class SpeciesSpecification {

	public static Specification<Species> filter(final SpeciesFilter filter) {
		return new Specification<Species>() {

			@Override
			public Predicate toPredicate(Root<Species> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				final List<Predicate> predicates = new ArrayList<Predicate>();
				final Path<DistributionArea> distributionArea = root.<DistributionArea>get("distributionArea");
				final Path<Conservation> conservationPath = root.<Conservation>get("conservation");
				final Path<NaturalHistory> naturalHistory = root.<NaturalHistory>get("naturalHistory");
				final Path<Threat> threat = root.<Threat>get("threat");

				predicates.add(cb.equal(root.<Boolean>get("enabled"), true));
				predicates.add(searchByName(root, query, cb));
				
				if (!isEmpty(filter.getEndemicFromBrazil())) {
					predicates.add(cb.equal(distributionArea.get("endemicFromBrazil"), filter.getEndemicFromBrazil()));
				}
				if (!isEmpty(filter.getOccurrenceState())) {
					predicates.add(cb.equal(distributionArea.get("ocurrenceState"), filter.getOccurrenceState()));
				}
				if (!isEmpty(filter.getOccurrenceBiomes())) {
					predicates.add(cb.equal(distributionArea.get("ocurrenceBiomes"), filter.getOccurrenceBiomes()));
				}
				if (!isEmpty(filter.getOccurrenceProtectedAreas())) {
					predicates.add(cb.equal(distributionArea.get("ocurrenceProtectedAreas"),
							filter.getOccurrenceProtectedAreas()));
				}
				if (!isEmpty(filter.getExtinctionRiskCategory())) {
					final Predicate extinctionRiskCategory = cb.equal(root.<ExtinctionRiskCategory>get("extinctionRiskCategory"),
							filter.getExtinctionRiskCategoryEnum());
					predicates.add(extinctionRiskCategory);
				}
				if (!isEmpty(filter.getHabitat())) {
					final Path<Habitat> habitatPath = naturalHistory.<Habitat>get("habitat");
					predicates.add(cb.equal(habitatPath.<HabitatType>get("type").<Long>get("id"), filter.getHabitat()));
				}
				if (!isEmpty(filter.getActionPlan())) {
					predicates.add(cb.equal(conservationPath.<ConservationAction>get("conservationAction").<String>get("benefitedActionPlan"),
							filter.getActionPlan()));
				}
				if (!isEmpty(filter.getInNationalEndangeredFauna())) {
					predicates.add(cb.equal(conservationPath.<ExtinctionRisk>get("extinctionRisk").<Boolean>get("inNationalEndangeredFauna"),
							filter.getInNationalEndangeredFauna()));
				}
				if (!isEmpty(filter.getUfState())) {
					predicates.add(cb.equal(threat.<ThreatStatus>get("threatStatus").<String>get("ufState"),
							filter.getUfState()));
				}
				if (!isEmpty(filter.getMunicipality())) {
					predicates.add(cb.equal(threat.<ThreatStatus>get("threatStatus").<String>get("municipality"),
							filter.getMunicipality()));
				}
				if (!isEmpty(filter.getNationalEndangeredFauna())) {
					predicates.add(cb.equal(conservationPath.<ExtinctionRisk>get("extinctionRisk").<String>get("nationalEndangeredFauna"),
							filter.getNationalEndangeredFauna()));
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
