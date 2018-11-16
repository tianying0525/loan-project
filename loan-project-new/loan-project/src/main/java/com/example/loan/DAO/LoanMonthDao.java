package com.example.loan.DAO;

import com.example.loan.model.LoanMonth;

import java.util.List;

public interface LoanMonthDao {
    List<LoanMonth> getLoanMonthAtGivenYear(String year);
}
