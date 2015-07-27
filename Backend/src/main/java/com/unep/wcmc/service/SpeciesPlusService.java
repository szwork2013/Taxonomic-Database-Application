package com.unep.wcmc.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class SpeciesPlusService {

    protected static final Log logger = LogFactory.getLog(SpeciesPlusService.class);

    private static final String AUTH_TOKEN = "YKk8zF6dPkd8AlP8Q3hy9Att";
    private static final String SPECIES_API_URL = "http://api.speciesplus.net";

    private static final String TAXON_CONCEPTS = SPECIES_API_URL + "/api/v1/taxon_concepts";
    private static final String TAXON_DISTRIBUTION = SPECIES_API_URL + "/api/v1/taxon_concepts/{taxon_concept_id}/distributions";
    private static final String TAXON_CITIES_LEGISLATION = SPECIES_API_URL + "/api/v1/taxon_concepts/{taxon_concept_id}/cites_legislation";
    private static final String TAXON_REFERENCES = SPECIES_API_URL + "/api/v1/taxon_concepts/{taxon_concept_id}/references";

    public enum SpeciesPlusRank { KINGDOM, PHYLUM, CLASS, ORDER, FAMILY, SUBFAMILY, GENUS, SPECIES, SUBSPECIES, VARIETY }

    private int currentPage = 1;
    private int itemsPerPage = 500;
    private long totalRecords;

    private boolean initialized = false;

    @SuppressWarnings("all")
    public void init() {
        Map<String, Object> values = getTaxonConcepts(1, 1);
        Map<String, Object> pagination = (Map<String, Object>) values.get("pagination");
        totalRecords = Long.parseLong(pagination.get("total_entries").toString());
        if (itemsPerPage > totalRecords) {
            itemsPerPage = (int) totalRecords;
        }
        initialized = true;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Authentication-Token", AUTH_TOKEN);
        return headers;
    }

    public Map<String, Object> getTaxonConcepts(int page, int perPage) {
        if (logger.isInfoEnabled()) {
            logger.info("Reading from Species+ API for the current page {" +
                    currentPage + "} and total of {" +
                    itemsPerPage + "} records per page ");
        }
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        String url = TAXON_CONCEPTS + "?page=" + page + "&per_page=" + perPage;
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return new JacksonJsonParser().parseMap(response.getBody());
    }

    public List<Object> getTaxonDistributions(long conceptId) {
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        String url = TAXON_DISTRIBUTION.replace("{taxon_concept_id}", String.valueOf(conceptId));
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return new JacksonJsonParser().parseList(response.getBody());
    }

    public Map<String, Object> getTaxonCitiesLegislation(long conceptId) {
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        String url = TAXON_CITIES_LEGISLATION.replace("{taxon_concept_id}", String.valueOf(conceptId));
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return new JacksonJsonParser().parseMap(response.getBody());
    }

    public List<Object> getTaxonReferences(long conceptId) {
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        String url = TAXON_REFERENCES.replace("{taxon_concept_id}", String.valueOf(conceptId));
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return new JacksonJsonParser().parseList(response.getBody());
    }

    public boolean hasNextTaxon() {
        if (!initialized) {
            init();
        }
        if (currentPage <= getTotalPages()) {
            return true;
        }
        return false;
    }

    public Map<String, Object> nextTaxonPage() {
        if (!initialized) {
            init();
        }
        Map<String, Object> values = getTaxonConcepts(currentPage, itemsPerPage);
        currentPage++;
        return values;
    }

    public int getTotalPages() {
        if (!initialized) {
            init();
        }
        return (int) totalRecords / itemsPerPage;
    }

}
