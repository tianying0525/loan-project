package com.example.loan.service;

import com.example.loan.DAO.LoanAvgDao;
import com.example.loan.DAO.LoanMonthDao;
import com.example.loan.model.LoanAvg;
import com.example.loan.model.LoanMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanMonthServiceImpl implements LoanMonthService {

    @Autowired
    LoanMonthDao loanMonthDao;

    @Override
    public List<LoanMonth> getLoanMonthAtGivenYear(String year) {
        return loanMonthDao.getLoanMonthAtGivenYear(year);
    }
}
