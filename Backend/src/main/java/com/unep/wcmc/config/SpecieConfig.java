package com.unep.wcmc.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.unep.wcmc.model.Conservation;
import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.Map;
import com.unep.wcmc.model.NaturalHistory;
import com.unep.wcmc.model.Specie;
import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.model.Threat;
import com.unep.wcmc.service.SpecieService;

/**
 * Initializer that creates mock specie for testing
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class SpecieConfig {

    @Bean
    public InitializingBean insertDefaultUsers() {
        return new InitializingBean() {
            
            @Autowired
            private SpecieService specieService;
            
            /*
             * (non-Javadoc)
             * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
             */
            @Override
            public void afterPropertiesSet() {
                try {
                    final Specie specie = specieService.findByCommonName("Specie-Test");
                    if (specie == null) {
                        createSpecie();    
                    }
                } catch (Exception e) {
                    System.err.println(e);
                    // not a big deal, catches duplicated user insertion
                }
            }
            
            private void createSpecie() {
                final Specie specie = new Specie();
                specie.setId(0L);
                specie.setCommonName("Specie-Test");
                specie.setScientificName("Specie-Scientific-Test");
                specie.setConservation(createConservation());
                specie.setCoverMap(createMap());
                specie.setDistributionArea(createDistributionArea());
                specie.setExtinctionRiskCategory(ExtinctionRiskCategory.CRITICALLY_ENDANGERED);
                specie.setNaturalHistory(createNaturalHistory());
                specie.setTaxonomy(createTaxonomy());
                specie.setThreat(createThreat());
                specie.setCoverPhoto(null);
                specieService.save(specie);
            }
            
            private Conservation createConservation() {
                final Conservation conservation = new Conservation();
                conservation.setId(1L);
                return conservation;
            }
            
            private Map createMap() {
                final Map map = new Map();
                map.setId(1L);
                return map;
            }
            
            private DistributionArea createDistributionArea() {
                final DistributionArea distributionArea = new DistributionArea();
                distributionArea.setId(1L);
                return distributionArea;
            }
            
            private NaturalHistory createNaturalHistory() {
                final NaturalHistory naturalHistory = new NaturalHistory();
                naturalHistory.setId(1L);
                return naturalHistory;
            }
            
            private Taxonomy createTaxonomy() {
                final Taxonomy taxonomy = new Taxonomy();
                taxonomy.setId(1L);
                return taxonomy;
            }
            
            private Threat createThreat() {
                final Threat threat = new Threat();
                threat.setId(1L);
                return threat;
            }
        };
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }    
}
