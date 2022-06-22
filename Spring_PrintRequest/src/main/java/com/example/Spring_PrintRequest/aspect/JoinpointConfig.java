package com.example.Spring_PrintRequest.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


public class JoinpointConfig {

    @Pointcut("@annotation(com.example.Spring_PrintRequest.aspect.ExecutionTime)")
    public void logExecutionTimePointcut(){}

    @Pointcut("execution(* com.example.Spring_PrintRequest.controller.*.*(..))")
    public void logAfterReturningExecution(){}

    @Pointcut("execution(* com.example.Spring_PrintRequest.controller.*.*(..))")
    public void addActivityLog(){}

}
