package com.unep.wcmc.integration;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import static com.unep.wcmc.model.IntegrationSource.Source.*;

@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
@SuppressWarnings("all")
public class BatchConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobExecutionListener speciesJobListener;

    @Bean
    public Step stepFlora(ItemReader floraReader,
                          ItemProcessor floraProcessor,
                          ItemWriter floraWriter) {
        return stepBuilderFactory.get(FLORA.name()).chunk(100)
                .reader(floraReader)
                .processor(floraProcessor)
                .writer(floraWriter)
                .listener(speciesJobListener)
                .build();
    }

    @Bean
    public Step stepFauna(ItemReader faunaReader,
                          ItemProcessor faunaProcessor,
                          ItemWriter faunaWriter) {
        return stepBuilderFactory.get(FAUNA.name()).chunk(100)
                .reader(faunaReader)
                .processor(faunaProcessor)
                .writer(faunaWriter)
                .listener(speciesJobListener)
                .build();
    }

    @Bean
    public Step stepSpeciesPlus(ItemReader speciesPlusReader,
                                ItemProcessor speciesPlusProcessor,
                                ItemWriter speciesPlusWriter) {
        return stepBuilderFactory.get(SPECIES_PLUS.name()).chunk(10)
                .reader(speciesPlusReader)
                .processor(speciesPlusProcessor)
                .writer(speciesPlusWriter)
                .listener(speciesJobListener)
                .build();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        MapJobRepositoryFactoryBean repository = new MapJobRepositoryFactoryBean();
        return repository.getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository());
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return launcher;
    }

}