package com.example.loan.service;

import com.example.loan.DAO.LoanAvgDao;
import com.example.loan.DAO.LoanTotalDao;
import com.example.loan.model.LoanAvg;
import com.example.loan.model.LoanTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanAvgServiceImpl implements LoanAvgService {

    @Autowired
    LoanAvgDao loanAvgDao;

    @Override
    public List<LoanAvg> getLoanAvgAtGivenYear(String year) {
        return loanAvgDao.getLoanAvgAtGivenYear(year);
    }
}
