package com.laychv.common.tools;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CountTimesAspect {

    @Pointcut("@annotation(@com.layout.common.tools.CountTimes)")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = pjp.proceed();
        long duration = System.currentTimeMillis() - begin;
        System.out.println(duration + "ffff");
        return result;
    }
}

