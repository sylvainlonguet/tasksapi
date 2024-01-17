package com.edu.tasksapi.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* getRandomUser *(..))")
    public void publicMethodRandom() {
    }

}
