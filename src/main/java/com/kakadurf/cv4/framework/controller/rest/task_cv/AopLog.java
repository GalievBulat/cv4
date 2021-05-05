package com.kakadurf.cv4.framework.controller.rest.task_cv;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class AopLog {
    @Pointcut("execution(* com.kakadurf.cv4.framework.controller.rest.task_cv.RestMailUserDetails.*(..)) ")
    public void mail() {}
    @Before("mail()")
    public void before(JoinPoint pjp) throws Throwable {
        System.out.println("BEFORE: " + pjp.getArgs()[0].toString());
    }
    @After("mail()")
    public void after(JoinPoint pjp) throws Throwable {
        System.out.println("AFTER: " + pjp.getArgs()[0].toString());
    }
}