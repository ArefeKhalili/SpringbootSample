package com.example.Spring_PrintRequest.service;

import com.example.Spring_PrintRequest.printrequest.ActivityLog;
import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.printrequest.PrintRequestPrimarykey;
import com.example.Spring_PrintRequest.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLoggerService {

    @Autowired
    ActivityLogRepository activityLogRepository;

    public ActivityLog insertActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

}
