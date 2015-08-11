package com.unep.wcmc.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

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
public class SpeciesConfig {

    @Bean
    public InitializingBean insertDefaultUsers() {
        return new InitializingBean() {

            @Autowired
            SpeciesMockBuilder mockBuilder;

            @Override
            public void afterPropertiesSet() {
//                try {
//                    mockBuilder.createSpecies();
//                } catch (Exception e) {
//                    System.err.println(e);
//                    // not a big deal, catches duplicated user insertion
//                }
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
