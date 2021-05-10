package com.kakadurf.cv4.framework.controller.rest.task_cv;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class AopLog {
    @Pointcut("execution(* com.kakadurf.cv4.framework.controller.rest.task_cv.UserDetailsPopulation.*(..)) ")
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