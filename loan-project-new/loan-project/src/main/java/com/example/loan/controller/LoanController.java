package com.example.loan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.loan.model.LoanAvg;
import com.example.loan.model.LoanMonth;
import com.example.loan.model.LoanTotal;
import com.example.loan.service.LoanAvgService;
import com.example.loan.service.LoanMonthService;
import com.example.loan.service.LoanTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping
public class LoanController {

    @GetMapping("")
    public String MyIndexPage() {
        return "index";
    }

    @Autowired
    private LoanTotalService loanTotalService;

    @Autowired
    private LoanAvgService loanAvgService;

    @Autowired
    private LoanMonthService loanMonthService;

    @GetMapping("{year}/loantotal")
    public ResponseEntity<List<LoanTotal>> findLoanTotalAtGivenTime(@PathVariable("year") String year) throws JsonProcessingException {
        List<LoanTotal> list1 = loanTotalService.getLoanTotalAtGivenYear(year);

        return new ResponseEntity<List<LoanTotal>>(list1, HttpStatus.OK);

    }

    @GetMapping("{year}/loanavg")
    public ResponseEntity<List<LoanAvg>> findLoanAvgAtGivenTime(@PathVariable("year") String year) throws JsonProcessingException {
        List<LoanAvg> list2 = loanAvgService.getLoanAvgAtGivenYear(year);
        return new ResponseEntity<List<LoanAvg>>(list2, HttpStatus.OK);

    }

    @GetMapping("{year}/loanmonth")
    public ResponseEntity<List<LoanMonth>> findLoanMonthAtGivenTime(@PathVariable("year") String year) throws JsonProcessingException {
        List<LoanMonth> list3 = loanMonthService.getLoanMonthAtGivenYear(year);
        return new ResponseEntity<List<LoanMonth>>(list3, HttpStatus.OK);

    }

    @GetMapping("{year}/platform")
    public String PlatformPage(@PathVariable("year") String year) throws JsonProcessingException {

        if (Integer.valueOf(year) > 2015 || Integer.valueOf(year) < 2011) {
            return "404";
        }
        return "platform";
    }

    @GetMapping("404")
    public String ErrorPage() {
        return "404";
    }


}