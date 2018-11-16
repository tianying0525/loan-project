package com.example.loan.service;

import com.example.loan.model.LoanAvg;
import com.example.loan.model.LoanTotal;

import java.util.List;

public interface LoanAvgService {

    List<LoanAvg> getLoanAvgAtGivenYear(String time);
}
