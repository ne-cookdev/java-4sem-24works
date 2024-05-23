package com.example.lesson16;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    long timeStart;

    @Before("execService()")
    public void setTimeStart(JoinPoint joinPoint) {
        log.info("Method name: " + joinPoint.getSignature().getName());
        timeStart = System.currentTimeMillis();
    }

    @Pointcut("within(com.example.lesson16.service.*)")
    public void execService() {
    }

    @After("execService()")
    public void getExecTime(){
        log.info("Execution time:" + (System.currentTimeMillis()-timeStart));
    }
}