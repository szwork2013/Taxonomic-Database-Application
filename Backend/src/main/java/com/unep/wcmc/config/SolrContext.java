package com.unep.wcmc.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;


@Configuration
@EnableSolrRepositories(basePackages = { "com.unep.wcmc.repository" }, multicoreSupport = true)
public class SolrContext {

    private static Logger log = LoggerFactory.getLogger(SolrContext.class);

    @Bean
    public SolrServer solrServer() {
        log.info("solr server running");
        return new HttpSolrServer("http://localhost:8983/solr");
    }


    @Bean
    public SolrTemplate solrTemplate(SolrServer server) throws Exception {
        return new SolrTemplate(server);
    }
}
