package com.unep.wcmc.integration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class JobRunner {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Step stepICMBio;

    @Autowired
    private Step stepSpeciesPlus;

    public JobExecution startJobSpeciesPlus() throws Exception {
        Job job = jobBuilderFactory.get("jobSpeciesPlus").incrementer(new RunIdIncrementer())
                .start(stepSpeciesPlus).build();
        return jobLauncher.run(job, new JobParameters());
    }

    public JobExecution startJobICMBio() throws Exception {
        Job job = jobBuilderFactory.get("stepICMBio").incrementer(new RunIdIncrementer())
                .start(stepICMBio).build();
        return jobLauncher.run(job, new JobParameters());
    }

}