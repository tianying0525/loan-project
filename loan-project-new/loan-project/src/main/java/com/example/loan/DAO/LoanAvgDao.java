package com.example.loan.DAO;

import com.example.loan.model.LoanAvg;

import java.util.List;

public interface LoanAvgDao {
    List<LoanAvg> getLoanAvgAtGivenYear(String year);
}
