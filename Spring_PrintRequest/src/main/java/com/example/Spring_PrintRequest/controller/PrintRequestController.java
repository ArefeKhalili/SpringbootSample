package com.example.Spring_PrintRequest.controller;

import com.example.Spring_PrintRequest.exception.CustomRestException;
import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.printrequest.PrintRequestPrimarykey;
import com.example.Spring_PrintRequest.printrequest.Views;
import com.example.Spring_PrintRequest.repository.PrintRequestRepository;
import com.example.Spring_PrintRequest.service.PrintRequestService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/printRequest")
public class PrintRequestController {
    @Autowired
    private PrintRequestService printRequestService;
    @Autowired
    private PrintRequestRepository printRequestRepository;

    @JsonView(Views.Public.class)
    @GetMapping("/all")
    public List<PrintRequest> getPrintRequest() {
        return printRequestService.getPrintRequest();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<PrintRequest> insertCard(@Valid @RequestBody PrintRequest printRequest) throws CustomRestException {
        return ResponseEntity.ok(printRequestService.insertPrintReq(printRequest));
    }

}
