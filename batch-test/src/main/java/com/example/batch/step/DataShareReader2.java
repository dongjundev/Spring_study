package com.example.batch.step;

import com.example.batch.config.SuperStepExecution;
import com.example.batch.entity.Member;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataShareReader2 extends SuperStepExecution<Member> implements ItemReader<Member> {

    private boolean isRead;
    private Member specificMember;

    @PostConstruct
    public void init() {
        isRead = false;
    }

    @Override
    public Member read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        log.info("Step2 Reader 시작");
        if (!isRead) {
            isRead = true;

            log.info("specificMember={}", specificMember);
            return specificMember;
        }

        return null;
    }

    @BeforeStep
    public void retrieveInterstepData(StepExecution stepExecution) {
        //step 실행전 stepExecution을 가져와 회원 정보를 가져옴
        super.setStepExecution(stepExecution);
        this.specificMember = (Member) super.getData("SPECIFIC_MEMBER");
    }
}
