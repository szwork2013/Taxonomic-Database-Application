package com.unep.wcmc.test.integration;

import com.unep.wcmc.Application;
import com.unep.wcmc.integration.JobRunner;
import com.unep.wcmc.integration.JobRuntime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.unep.wcmc.model.IntegrationSource.Source.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JobRunnerTest {

    @Autowired
    private JobRunner jobRunner;

    @Test
    //@Ignore // Ignoring this test case to not be executed all the time
    public void testStartSpeciesPlus() throws Exception {
        JobRuntime jobRuntime = jobRunner.start(SPECIES_PLUS.name());
        Assert.assertNotNull(jobRuntime);
        Assert.assertNotNull(jobRuntime.getExecution());
        while (jobRuntime.getExecution().isRunning()) {
            Thread.sleep(10000);
        }
        Assert.assertEquals(jobRuntime.getExecution().getStatus(), BatchStatus.COMPLETED);
    }

    @Test
    @Ignore // Ignoring this test case to not be executed all the time
    public void testStartFaunaJob() throws Exception {
        JobRuntime jobRuntime = jobRunner.start(FAUNA.name());
        Assert.assertNotNull(jobRuntime);
        Assert.assertNotNull(jobRuntime.getExecution());
        while (jobRuntime.getExecution().isRunning()) {
            Thread.sleep(10000);
        }
        Assert.assertEquals(jobRuntime.getExecution().getStatus(), BatchStatus.COMPLETED);
    }

    @Test
    @Ignore // Ignoring this test case to not be executed all the time
    public void testStartFloraJob() throws Exception {
        JobRuntime jobRuntime = jobRunner.start(FLORA.name());
        Assert.assertNotNull(jobRuntime);
        Assert.assertNotNull(jobRuntime.getExecution());
        while (jobRuntime.getExecution().isRunning()) {
            Thread.sleep(10000);
        }
        Assert.assertEquals(jobRuntime.getExecution().getStatus(), BatchStatus.COMPLETED);
    }
}