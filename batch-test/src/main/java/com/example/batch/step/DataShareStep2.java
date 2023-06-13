package com.example.batch.step;

import com.example.batch.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class DataShareStep2 {

    private final DataSource dataSource;
    private final PlatformTransactionManager platformTransactionManager;
    private final JobRepository jobRepository;
    private final DataShareProcessor dataShareProcessor;
    private final ExecutionContextPromotionListener promotionListener;
    private final DataShareReader2 dataShareReader2;

    @Bean
    public Step step2 () {
        return new StepBuilder("step2", jobRepository)
                .<Member, Member>chunk(5, platformTransactionManager)
                .reader(dataShareReader2)
                // lister 등록
                .writer(member -> log.info("step2 writer specificMember={}", member))
                .listener(promotionListener)
                .build();
    }
}
