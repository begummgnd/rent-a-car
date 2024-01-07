package com.app.rentacar.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {


    @Before("execution(* com.app.rentacar.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getSignature());
        System.out.println("logging before process");
    }


    @After("execution(* com.app.rentacar.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Process finished.");

    }

    @Pointcut("execution(* com.app.rentacar.controller.*.*(..))")
    public void pointCutForAfterReturning(){}


    @AfterReturning(pointcut = "pointCutForAfterReturning()", returning = "result")
    public <T> void returnValue(List<T> result){

        System.out.println("Return value is " + result);
    }


}
