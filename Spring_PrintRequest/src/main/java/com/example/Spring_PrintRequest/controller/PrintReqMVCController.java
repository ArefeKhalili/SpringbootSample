package com.example.Spring_PrintRequest.controller;

import com.example.Spring_PrintRequest.aspect.ExecutionTime;
import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.service.PrintRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/printReq")
public class PrintReqMVCController {

    @Autowired
    private PrintRequestService printRequestService;


    @InitBinder
    public void convertDate(WebDataBinder webDataBinder, WebRequest webRequest){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));
    }

    @GetMapping("/all")
    @ExecutionTime
    public String showAllPrintRequests(Model model) {
        model.addAttribute("printReqs", printRequestService.getPrintRequest());
        return "allRequests";
    }

    @GetMapping("/showReq")
    public String showSavedRequest() {
        return "showPrintRequest";
    }

    @GetMapping("/add")
    @ExecutionTime
    public String addPrintRequestView(Model model) {
        model.addAttribute("printReq", new PrintRequest());
        return "addPrintRequest";
    }

    @PostMapping("/add")
    @ExecutionTime
    public RedirectView addPrintRequest(@Valid @ModelAttribute("printReq") PrintRequest printReq, Model model, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/printReq/all", true);
        PrintRequest printRequest = printRequestService.insertPrintReq(printReq);
        model.addAttribute("cardPAN",printReq.getCardPAN());
        model.addAttribute("branchCode",printReq.getBranchCode());
        model.addAttribute("ipAddress",printReq.getIpAddress());
        model.addAttribute("personnelCode",printReq.getPersonnelCode());
        redirectAttributes.addFlashAttribute("savedRequest", printRequest);
        redirectAttributes.addFlashAttribute("addSuccess", true);
        return redirectView;
    }
}
