package com.example.loan.DAO;

import com.example.loan.mapper.LoanTotalRowMapper;
import com.example.loan.model.LoanTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LoanTotalDaoImpl implements LoanTotalDao {
    private final String LOANTOTAL_QUERY = "SELECT sum(loan_amnt) AS LoanTotal,sum(funded_amnt) AS FundTotal, sum(funded_amnt_inv) AS FundInvTotal FROM loan WHERE issue_d like ";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public List<LoanTotal> getLoanTotalAtGivenYear(String year) {
        List<LoanTotal> loanTotal_list = jdbcTemplate.query(LOANTOTAL_QUERY + "'%" + year + "'", new LoanTotalRowMapper());
        return loanTotal_list;

    }

}
