package com.example.batch.job;

import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestBatchConfig.class, SimpleJobConfiguration.class})
@SpringBatchTest
class SimpleJobConfigurationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    void simpleJob() throws Exception {
        jobLauncherTestUtils.launchJob();
    }
}