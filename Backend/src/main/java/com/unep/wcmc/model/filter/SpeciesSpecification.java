package com.unep.wcmc.model.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.Habitat;
import com.unep.wcmc.model.NaturalHistory;
import com.unep.wcmc.model.Species;

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
				
				final String searchQuery = "%" + filter.getQuery().toLowerCase() + "%";
				final List<Predicate> predicates = new ArrayList<Predicate>();
				final Predicate commonName = cb.like(cb.lower(root.<String>get("commonName")), searchQuery);
				final Predicate scientificName = cb.like(cb.lower(root.<String>get("scientificName")), searchQuery);
				final Path<DistributionArea> distributionArea = root.<DistributionArea>get("distributionArea");
				predicates.add(cb.or(commonName, scientificName));
				if (!StringUtils.isEmpty(filter.getEndemicFromBrazil())) {
					predicates.add(cb.equal(distributionArea.get("endemicFromBrazil"), filter.getEndemicFromBrazil()));
				}
				if (!StringUtils.isEmpty(filter.getOccurrenceState())) {
					predicates.add(cb.equal(distributionArea.get("ocurrenceState"), filter.getOccurrenceState()));
				}
				if (!StringUtils.isEmpty(filter.getExtinctionRiskCategory())) {
					final Predicate extinctionRiskCategory = cb.equal(root.<ExtinctionRiskCategory>get("extinctionRiskCategory"), filter.getExtinctionRiskCategoryEnum());
					predicates.add(extinctionRiskCategory);
				}
				if (!StringUtils.isEmpty(filter.getHabitat())) {
					final Path<NaturalHistory> naturalHistory = root.<NaturalHistory>get("naturalHistory");
					predicates.add(cb.equal(naturalHistory.<Habitat>get("habitat").<String>get("description"), filter.getHabitat()));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}
}
