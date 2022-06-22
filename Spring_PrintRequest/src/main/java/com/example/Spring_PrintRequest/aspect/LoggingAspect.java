package com.example.Spring_PrintRequest.aspect;

import com.example.Spring_PrintRequest.exception.CustomRestException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(* com.example.Spring_PrintRequest.controller.*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint){
        Arrays.stream(joinPoint.getArgs()).forEach(o -> {
            System.out.println(o.getClass());
        });
        logger.info(joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* com.example.Spring_PrintRequest.controller.*.*(..))"
            ,throwing = "exception")
    public void logAfterThrowingException(Throwable exception) throws Throwable {
        if(exception instanceof CustomRestException){
            logger.error(exception.getMessage());
        }
        throw exception;
    }



}
