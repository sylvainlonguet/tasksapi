package com.edu.tasksapi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodWrapperAspect {

    @Pointcut("@annotation(com.edu.tasksapi.aop.LogExecutionTime)")
    public void pointCut1() {
    };

    @Around("pointCut1()")
    private Object traceCall(ProceedingJoinPoint joinPoint) throws Throwable {

        final long start = System.currentTimeMillis();

        final Object proceed = joinPoint.proceed();

        final long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms !!!");

        return proceed;
    }

}
