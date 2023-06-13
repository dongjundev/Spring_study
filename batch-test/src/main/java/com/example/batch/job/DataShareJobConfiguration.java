package com.example.batch.job;

import com.example.batch.step.DataShareStep1;
import com.example.batch.step.DataShareStep2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class DataShareJobConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    private final DataSource dataSource;
    private int chunkSize = 5;

    private final DataShareStep1 dataShareStep1;
    private final DataShareStep2 dataShareStep2;

    @Bean
    public Job dataShareJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new JobBuilder("dataShareJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(dataShareStep1.step1())
                .next(dataShareStep2.step2())
                .build();
    }
}
