package com.example.batch.step;

import com.example.batch.config.SuperStepExecution;
import com.example.batch.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@StepScope
public class DataShareProcessor extends SuperStepExecution<Member> implements ItemProcessor<Member, Member> {

    private final int SPECIFIC_MEMBER_IDX = 0;

    @Override
    public Member process(Member member) throws Exception {
        log.info("Step1 Processor 시작");

        if(member.getName().equals("박동준")) {
            log.info("Step1 Processor 박동준 회원 정보 : {}", member);

            // 2. SuperStepExecution의 StepExecution에 데이터 세팅
            super.putData("SPECIFIC_MEMBER", member);
        }


        return member;
    }

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        // 1. SuperStepExecution의 멤버변수에 stepExecution 주입
        super.setStepExecution(stepExecution);
    }
}
