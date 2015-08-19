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

				final List<Predicate> predicates = new ArrayList<>();

				final Join<Species, DistributionArea> distributionArea = root.join("distributionArea",JoinType.LEFT);
				final Join<Species, Conservation> conservation = root.join("conservation", JoinType.LEFT);
				final Join<Species, NaturalHistory> naturalHistory = root.join("naturalHistory", JoinType.LEFT);
				final Join<Species, Threat> threat = root.join("threats", JoinType.LEFT);

				predicates.add(cb.equal(root.<Boolean>get("enabled"), true));
				predicates.add(searchByName(root, query, cb));
				
				if (!isEmpty(filter.getEndemicFromBrazil())) {
					predicates.add(cb.equal(distributionArea.get("endemicFromBrazil"), filter.getEndemicFromBrazil()));
				}
				if (!isEmpty(filter.getOccurrenceState())) {
					final Join<DistributionArea, State> occurrenceStates = distributionArea.join("occurrenceStates", JoinType.LEFT);
					predicates.add(cb.equal(occurrenceStates.get("name"), filter.getOccurrenceState()));
				}
				if (!isEmpty(filter.getOccurrenceBiomes())) {
					final Join<DistributionArea, Biome> occurrenceBiomes = distributionArea.join("occurrenceBiomes", JoinType.LEFT);
					predicates.add(cb.equal(occurrenceBiomes.get("name"), filter.getOccurrenceBiomes()));
				}
				if (!isEmpty(filter.getOccurrenceProtectedAreas())) {
					final Join<DistributionArea, ProtectedArea> occurrenceProtectedAreas =
							distributionArea.join("occurrenceProtectedAreas", JoinType.LEFT);
					predicates.add(cb.equal(occurrenceProtectedAreas.get("area"),
							filter.getOccurrenceProtectedAreas()));
				}
				if (!isEmpty(filter.getExtinctionRiskCategory())) {
					final Predicate extinctionRiskCategory = cb.equal(
							root.<ExtinctionRiskCategory>get("extinctionRiskCategory"), filter.getExtinctionRiskCategoryEnum());
					predicates.add(extinctionRiskCategory);
				}
				if (!isEmpty(filter.getHabitat())) {
					final Join<NaturalHistory, Habitat> habitat = naturalHistory.join("habitat", JoinType.LEFT);
					final Join<Habitat, HabitatType> habitatType = habitat.join("types", JoinType.LEFT);
					predicates.add(cb.equal(habitatType.<Long>get("id"), filter.getHabitat()));
				}

//				if (!isEmpty(filter.getActionPlan())) {
//					predicates.add(cb.equal(conservationPath.<ConservationAction>get("conservationAction").<String>get("benefitedActionPlan"),
//							filter.getActionPlan()));
//				}

				if (!isEmpty(filter.getInNationalEndangeredFauna())) {
					predicates.add(cb.equal(conservation.<Conventions>get("conventions").<Boolean>get("presenceNationalEndangeredFauna"),
							filter.getInNationalEndangeredFauna()));
				}
//				if (!isEmpty(filter.getUfState())) {
//					predicates.add(cb.equal(threat.<ThreatStatus>get("threatStatus").<String>get("ufState"),
//							filter.getUfState()));
//				}
//				if (!isEmpty(filter.getMunicipality())) {
//					predicates.add(cb.equal(threat.<ThreatStatus>get("threatStatus").<String>get("municipality"),
//							filter.getMunicipality()));
//				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			
			private Predicate searchByName(Root<Species> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				final Join<Species, Taxonomy> taxonomyJoin = root.join("taxonomy", JoinType.INNER);

				final Path<Hierarchy> hierarchy = taxonomyJoin.<Hierarchy>get("hierarchy");
				final Path<Kingdom> kingdom = hierarchy.<Kingdom>get("kingdom");
				final Path<Phylum> phylum = hierarchy.<Phylum>get("phylum");
				final Path<HierarchyClass> hierarchyClass = hierarchy.<HierarchyClass>get("hierarchyClass");
				final Path<HierarchyOrder> order = hierarchy.<HierarchyOrder>get("order");
				final Path<Family> family = hierarchy.<Family>get("family");
				final Path<Genus> genus = hierarchy.<Genus>get("genus");

				final Join<Taxonomy, CommonName> commonNamesJoin = taxonomyJoin.join("commonNames");

				final String searchQuery = "%" + filter.getQuery().toLowerCase() + "%";
				final Predicate commonName = cb.like(cb.lower(commonNamesJoin.<String>get("commonName")), searchQuery);
				final Predicate scientificName = cb.like(cb.lower(root.<String>get("scientificName")), searchQuery);
				final Predicate speciesEpiteth = cb.like(cb.lower(hierarchy.<String>get("speciesEpiteth")), searchQuery);
				final Predicate subSpecies = cb.like(cb.lower(hierarchy.<String>get("subspecies")), searchQuery);
				final Predicate kingdomName = cb.like(cb.lower(kingdom.<String>get("name")), searchQuery);
				final Predicate phylumName = cb.like(cb.lower(phylum.<String>get("name")), searchQuery);
				final Predicate hierarchyClassName = cb.like(cb.lower(hierarchyClass.<String>get("name")), searchQuery);
				final Predicate orderName = cb.like(cb.lower(order.<String>get("name")), searchQuery);
				final Predicate familyName = cb.like(cb.lower(family.<String>get("name")), searchQuery);
				final Predicate genusName = cb.like(cb.lower(genus.<String>get("name")), searchQuery);
				return cb.or(commonName, scientificName, speciesEpiteth, subSpecies, kingdomName, phylumName, hierarchyClassName, orderName, familyName, genusName);
			}
		};
	}
}
