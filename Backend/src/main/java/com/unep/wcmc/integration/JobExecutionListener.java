package com.unep.wcmc.integration;

import com.unep.wcmc.model.IntegrationHistory;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.repository.IntegrationHistoryRepository;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.unep.wcmc.integration.JobRuntime.JobVariable.*;

@Component
public class JobExecutionListener {

    protected static final Log logger = LogFactory.getLog(JobExecutionListener.class);

    @Autowired
    private IntegrationHistoryRepository historyRepository;

    @Autowired
    private IntegrationSourceRepository integrationRepository;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        processHistory(stepExecution, false);
        logger.info("Job '" + stepExecution.getStepName() + "' started.");
    }

    @AfterStep
    public ExitStatus afterStep(StepExecution stepExecution) {
        processHistory(stepExecution, true);
        logger.info("Job '" + stepExecution.getStepName() + "' completed.");
        JobRunner.finishJobRuntime(stepExecution.getJobExecution().getJobInstance().getJobName());
        return stepExecution.getExitStatus();
    }

    private void processHistory(StepExecution stepExecution, boolean completed) {

        String jobName = stepExecution.getJobExecution().getJobInstance().getJobName();
        JobRuntime jobRuntime = JobRunner.getJobRuntime(jobName);

        IntegrationSource source = integrationRepository.findBySource(IntegrationSource.Source.valueOf(jobName));

        List<IntegrationHistory> historyList = historyRepository.findByIntegrationSourceAndCompleted(source, false);
        IntegrationHistory history;
        if (historyList != null && !historyList.isEmpty()) {
            history = historyList.get(0);
        } else {
            history = new IntegrationHistory();
        }
        history.setCompleted(completed);
        history.setRecordsProcessed(stepExecution.getReadCount());

        history.setRecordsInserted(jobRuntime.getVariable(INSERTS_COUNT.name(), 0));
        history.setRecordsUpdated(jobRuntime.getVariable(UPDATES_COUNT.name(), 0));
        history.setTotalExceptions(jobRuntime.getVariable(EXCEPTIONS_COUNT.name(), 0));

        history.setIntegrationSource(source);
        history.setStatus(stepExecution.getStatus().name());
        history.setUpdatedAt(stepExecution.getLastUpdated());

        historyRepository.save(history);
    }

    @AfterChunk
    public void afterChunk() {
        for (JobRuntime runtime : JobRunner.getJobRuntimes()) {
            JobExecution execution = runtime.getExecution();
            if (execution != null) {
                if (execution.getStepExecutions() != null && !execution.getStepExecutions().isEmpty()) {
                    StepExecution stepExecution = execution.getStepExecutions().iterator().next();
                    processHistory(stepExecution, false);
                }
            }
        }
    }

}