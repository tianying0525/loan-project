package com.example.loan.service;

import com.example.loan.DAO.LoanTotalDao;
import com.example.loan.model.LoanTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanTotalServiceImpl implements LoanTotalService {

    @Autowired
    LoanTotalDao loanTotalDao;

    @Override
    public List<LoanTotal> getLoanTotalAtGivenYear(String year) {
        return loanTotalDao.getLoanTotalAtGivenYear(year);
    }
}
