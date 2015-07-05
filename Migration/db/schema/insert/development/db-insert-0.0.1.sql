BEGIN;

-- ExtinctionRiskConfiguration data
INSERT INTO extinction_risk_configuration (id, category, b2a_number_of_locations, c_number_of_mature_individuals, d_number_of_mature_individuals, c2a_number_of_mature_individuals_in_sub, b2_area_of_ocuppancy, b1_extent_of_occurrence, c2a_perc_mature_individuals_one_sub, a1_perc_population_decline, a2_perc_population_decline, e_prob_extinction_in_the_wild) VALUES (1, 'CRITICALLY_ENDANGERED', 1, 250, 50, 50, 10, 100, 90, 90.0, 80.0, 50.0);

END;
