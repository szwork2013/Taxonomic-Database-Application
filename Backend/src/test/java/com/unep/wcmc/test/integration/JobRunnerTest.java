package com.unep.wcmc.test.integration;

import com.unep.wcmc.Application;
import com.unep.wcmc.integration.JobRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JobRunnerTest {

    @Autowired
    private JobRunner jobRunner;

    @Test
    public void testStartSpeciesPlus() throws Exception {
        JobExecution jobExecution = jobRunner.startJobSpeciesPlus();
        Assert.assertNotNull(jobExecution);
        Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);
    }
}