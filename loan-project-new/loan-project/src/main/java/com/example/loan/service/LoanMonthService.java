package com.example.loan.service;

import com.example.loan.model.LoanAvg;
import com.example.loan.model.LoanMonth;

import java.util.List;

public interface LoanMonthService {

    List<LoanMonth> getLoanMonthAtGivenYear(String time);
}
