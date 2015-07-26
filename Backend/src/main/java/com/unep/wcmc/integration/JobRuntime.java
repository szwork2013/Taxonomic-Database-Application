package com.unep.wcmc.integration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class JobRuntime implements Serializable {

    public enum JobVariable { UPDATES_COUNT, INSERTS_COUNT, EXCEPTIONS_COUNT;
        public void increment(JobRuntime runtime) {
            int count = runtime.getVariable(this.name(), 0);
            runtime.getVariables().put(this.name(), (++count));
        }
    }

    private String name;

    private Map<String, Object> variables = new HashMap<>();

    private Job job;

    private JobExecution execution;

    public JobRuntime() {
        super();
    }

    public JobRuntime(String name, Job job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public <T> T getVariable(String variable, T defaultValue) {
        if (!getVariables().containsKey(variable)) {
            getVariables().put(variable, defaultValue);
        }
        return (T) getVariables().get(variable);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobExecution getExecution() {
        return execution;
    }

    public void setExecution(JobExecution execution) {
        this.execution = execution;
    }
}
