package com.example.Spring_PrintRequest.repository;

import com.example.Spring_PrintRequest.printrequest.ActivityLog;
import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.printrequest.PrintRequestPrimarykey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ActivityLogRepository extends JpaRepository<ActivityLog,Integer> {
}
