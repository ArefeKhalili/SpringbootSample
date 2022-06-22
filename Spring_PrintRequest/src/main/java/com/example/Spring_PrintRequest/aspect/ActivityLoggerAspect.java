package com.example.Spring_PrintRequest.aspect;

import com.example.Spring_PrintRequest.printrequest.ActivityLog;
import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.repository.ActivityLogRepository;
import com.example.Spring_PrintRequest.service.ActivityLoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ActivityLoggerAspect {

    @Value("${application.applicationType}")
    private String applicationType;
    @Autowired
    ActivityLoggerService activityLoggerService;

    @Around("com.example.Spring_PrintRequest.aspect.JoinpointConfig.addActivityLog()")
    public Object addActivityLog(ProceedingJoinPoint joinPoint) throws Throwable {
        PrintRequest printRequest = (PrintRequest) joinPoint.getArgs()[1];
        String name = joinPoint.getSignature().getName();
        ActivityLog activityLog = new ActivityLog(printRequest.getCardPAN(), name, printRequest.getPersonnelCode(), applicationType, new Date());

        activityLoggerService.insertActivityLog(activityLog);
        return joinPoint.proceed();

    }

}
