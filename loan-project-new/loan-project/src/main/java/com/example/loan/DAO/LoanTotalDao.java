package com.example.loan.DAO;

import com.example.loan.model.LoanTotal;

import java.util.List;

public interface LoanTotalDao {
    List<LoanTotal> getLoanTotalAtGivenYear(String year);
}
