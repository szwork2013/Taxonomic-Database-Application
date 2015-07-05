BEGIN;

-- NaturalHistory data
INSERT INTO natural_history(id, eating_habits, eating_habits_other_comments, expert_specialist, feeding_agregations, trophic_level, cont_decline_habitat_quality, habitat, restricted_to_primary_habitats, tolerant_to_habitat_mod, variation_in_habitat_use, captive_breeding_program, perc_and_period_of_decline, subpopulations_decline, subpopulations_fluctuations, subpopulations_number_of, subpopulations_trend, flutuation_mature_individuals, perc_immature_individuals, number_of_mature_individuals, trend_in_mature_individuals, max_no_of_mature_individuals, population_severely_fragmented, extinction_probability_in_brazil, decline_reversible_and_ceased, perc_population_decline, justification_of_pop_decline, population_decline_based_on, maximum_size, habitat_type_id) VALUES (1, 'herbivore', 'herbivore', 'none', 'no', 'level', true, 'brazil', true, 'no', 'yes', true, 50, 1, 1, 1, 1, true, 1, 1, 1, 1, true, 1, true, 1, 'hunting', 'hunting', 1, 1);

END;
