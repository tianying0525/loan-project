package com.example.loan.service;

import com.example.loan.model.LoanTotal;

import java.util.List;

public interface LoanTotalService {

    List<LoanTotal> getLoanTotalAtGivenYear(String time);
}
