package com.example.batch.job;

import com.example.batch.config.DataShareConfig;
import com.example.batch.step.DataShareProcessor;
import com.example.batch.step.DataShareReader2;
import com.example.batch.step.DataShareStep1;
import com.example.batch.step.DataShareStep2;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        TestBatchConfig.class
        , DataShareJobConfiguration.class
        , DataShareProcessor.class
        , DataShareReader2.class
        , DataShareStep1.class
        , DataShareStep2.class
        , DataShareConfig.class
})
@SpringBatchTest
class DataShareJobConfigurationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    void dataShareJob() throws Exception {
        jobLauncherTestUtils.launchJob();
    }
}