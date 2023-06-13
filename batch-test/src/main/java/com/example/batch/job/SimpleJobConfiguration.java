package com.example.batch.job;

import com.example.batch.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SimpleJobConfiguration {

//    spring-batch 5.0 부터 depricate
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    private final DataSource dataSource;
    private int chunkSize = 10;

    @Bean
    public Job simpleJob(JobRepository jobRepository, Step simpleStep1) {
        return new JobBuilder("simpleJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(simpleStep2(jobRepository, platformTransactionManager))
                .listener(simpleJobListener())
                .build();
    }

    @Bean
    public Step simpleStep1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("simpleStep1", jobRepository)
                .tasklet(((contribution, chunkContext) -> {
                    log.info(">>> This is Step1");
                    System.out.println("테스트!!!");
                    return RepeatStatus.FINISHED;
                }), transactionManager)
                .build();
    }

    @Bean
    public Step simpleStep2(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("simpleStep2", jobRepository)
                .<Member, Member>chunk(chunkSize, transactionManager)
                .reader(simpleReader())
                .processor(simpleProcessor(null))
                .writer(simpleWriter())
                .listener(simpleStepListener())
                .build();
    }

    @Bean
    public JdbcCursorItemReader<Member> simpleReader() {
        return new JdbcCursorItemReaderBuilder<Member>()
                .fetchSize(chunkSize)
                .dataSource(dataSource)
                .rowMapper(new BeanPropertyRowMapper<>(Member.class))
                .sql("SELECT ID, NAME, AGE, BIRTHDAY FROM member")
                .name("simpleReader")
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<Member, Member> simpleProcessor(@Value("#{jobParameters[status]}") String status) {
        return member -> {
            if (Integer.parseInt(member.getAge()) > 20) {
                return member;
            }

            return null;
        };
    }

    @Bean
    public JdbcBatchItemWriter<Member> simpleWriter() {
        return new JdbcBatchItemWriterBuilder<Member>()
                .dataSource(dataSource)
                .sql("INSERT INTO member2(ID, NAME, AGE, BIRTHDAY) VALUES(:id, :name, :age, :birthday)")
                .beanMapped()
                .build();
    }

    //스텝 리스너
    @Bean
    public StepExecutionListener simpleStepListener() {
        return new StepExecutionListener() {
            @Override
            public void beforeStep(StepExecution stepExecution) {
                log.info("---beforeStep : {}", stepExecution.getStepName());
            }

            @Override
            public ExitStatus afterStep(StepExecution stepExecution) {
                log.info("---afterStep : {}", stepExecution.getStepName());
                log.info("---afterStep : {}", stepExecution.getExitStatus());
                return stepExecution.getExitStatus();
            }
        };
    }

    //잡 리스너
    @Bean
    public JobExecutionListener simpleJobListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                log.info("---beforeJob : {}", jobExecution.getJobInstance().getJobName());
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                log.info("---afterJob : {}", jobExecution.getJobInstance().getJobName());
                log.info("---afterJob : {}", jobExecution.getExitStatus());
            }
        };
    }
}
