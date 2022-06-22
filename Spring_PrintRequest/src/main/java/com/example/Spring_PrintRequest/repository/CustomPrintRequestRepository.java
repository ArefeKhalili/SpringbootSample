package com.example.Spring_PrintRequest.repository;

import com.example.Spring_PrintRequest.printrequest.PrintRequest;

import java.util.List;

public interface CustomPrintRequestRepository {

    List<PrintRequest> getBranchCodeIpAddresses(PrintRequest printReq) throws Exception;
}
