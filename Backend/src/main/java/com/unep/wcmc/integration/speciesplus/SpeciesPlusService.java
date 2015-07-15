package com.unep.wcmc.integration.speciesplus;

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

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
@Scope("prototype")
public class SpeciesPlusService {

    protected static final Log logger = LogFactory.getLog(SpeciesPlusService.class);

    private static final String AUTH_TOKEN = "YKk8zF6dPkd8AlP8Q3hy9Att";
    private static final String TAXON_CONCEPTS = "http://api.speciesplus.net/api/v1/taxon_concepts";

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
    }

    public Map<String, Object> getTaxonConcepts(int page, int perPage) {
        if (logger.isInfoEnabled()) {
            logger.info("Reading from Species+ API for the current page {" +
                    currentPage + "/" + getTotalPages() + "} and total of {" +
                    itemsPerPage + "} records per page ");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Authentication-Token", AUTH_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = TAXON_CONCEPTS + "?page=" + page + "&per_page=" + perPage;
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return new JacksonJsonParser().parseMap(response.getBody());
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
