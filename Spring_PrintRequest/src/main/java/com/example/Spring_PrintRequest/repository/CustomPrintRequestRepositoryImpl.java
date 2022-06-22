package com.example.Spring_PrintRequest.repository;

import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomPrintRequestRepositoryImpl implements CustomPrintRequestRepository{

    @Autowired
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED)
    @Override
    public List<PrintRequest> getBranchCodeIpAddresses(PrintRequest printReq) throws Exception {
        printReq.setBranchCode(printReq.getBranchCode());
//        entityManager.find(PrintRequest.class,);
//        throw new Exception("A");
       return null;
    }

}
