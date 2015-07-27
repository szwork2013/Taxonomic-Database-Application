package com.unep.wcmc.integration;

import com.unep.wcmc.model.IntegrationSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("singleton")
@EnableScheduling
public class JobRunner {

    private static Map<String, JobRuntime> executionRuntime = new HashMap<>();

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Step stepFlora;

    @Autowired
    private Step stepFauna;

    @Autowired
    private Step stepSpeciesPlus;

    public JobRuntime start(String name) throws Exception {
        Step step = null;
        switch (IntegrationSource.Source.valueOf(name)) {
            case SPECIES_PLUS:
                step = stepSpeciesPlus;
                break;
            case FLORA:
                step = stepFlora;
                break;
            case FAUNA:
                step = stepFauna;
                break;
        }
        Job job = jobBuilderFactory.get(name).incrementer(new RunIdIncrementer())
                .start(step).build();
        JobRuntime runtime = new JobRuntime(name, job);
        executionRuntime.put(runtime.getName(), runtime);
        runtime.setExecution(jobLauncher.run(job, new JobParameters()));
        return runtime;
    }

    public void stop(String name) throws Exception {
        JobRuntime runtime = executionRuntime.get(name);
        if (runtime != null) {
            JobExecution execution = runtime.getExecution();
            if (execution != null) {
                execution.stop();
            }
        }
        executionRuntime.remove(name);
    }

    public static JobRuntime getJobRuntime(String name) {
        return executionRuntime.get(name);
    }

    public static JobRuntime finishJobRuntime(String name) {
        return executionRuntime.remove(name);
    }

    public static Collection<JobRuntime> getJobRuntimes() {
        return executionRuntime.values();
    }
}