package com.example.Spring_PrintRequest.service;

import com.example.Spring_PrintRequest.exception.CustomRestException;
import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.printrequest.PrintRequestPrimarykey;
import com.example.Spring_PrintRequest.repository.PrintRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class PrintRequestService {

    @Autowired
    PrintRequestRepository printRequestRepository;

    public List<PrintRequest> getPrintRequest() {
        return printRequestRepository.findAll(Sort.by(Sort.Direction.ASC, "branchCode"));
    }

//    public ResponseEntity<PrintRequest> insertPrintReq() {
//        PrintRequestPrimarykey pk=new PrintRequestPrimarykey("10.20.152.25","345");
//        return ResponseEntity.ok(printRequestRepository.save(new PrintRequest(pk,"123654798992541","345","10000","10.20.152.25")));
//    }
public PrintRequest insertPrintReq(PrintRequest printReq) {
    PrintRequestPrimarykey pk = new PrintRequestPrimarykey(printReq.getIpAddress(), printReq.getBranchCode());
    printReq.setId(pk);
    return printRequestRepository.save(printReq);
}
    public PrintRequest findReq(String ipAddress,String branchCode){
        return printRequestRepository.findByReqId(new PrintRequestPrimarykey(ipAddress,branchCode));
    }

}
