package com.kakadurf.cv4.framework.config;

import lombok.Synchronized;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class AopLogging {
    @Pointcut("within(com.kakadurf.cv4..*) ")
    public void anyMethods() {}
    @Around("anyMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        //System.out.println("Signature:  " + pjp.getSignature());
        long start = System.currentTimeMillis();
        Object value = null;
        try {
            return (value = pjp.proceed());
        } finally {
            long finish = System.currentTimeMillis();
            System.out.print("\nExecution time: ");
            System.out.println( finish-start + " Millis");
            System.out.println("Signature:  " + pjp.getSignature());
            if (pjp.getArgs()!=null)
                System.out.println("Arguments: " + Arrays.toString(pjp.getArgs()));
            if (value!= null)
                System.out.println("return value: " +  value.toString());
        }
    }
}
