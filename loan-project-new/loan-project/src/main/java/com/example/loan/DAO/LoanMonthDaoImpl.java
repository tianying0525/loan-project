package com.example.loan.DAO;

import com.example.loan.mapper.LoanMonthRowMapper;
import com.example.loan.model.LoanMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LoanMonthDaoImpl implements LoanMonthDao {

    private final String LOANMONTH_QUERY = "SELECT COUNT(loan_amnt) AS Count,issue_d FROM loan WHERE issue_d like";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public List<LoanMonth> getLoanMonthAtGivenYear(String year){
        List<LoanMonth> loanMonth_list = jdbcTemplate.query(LOANMONTH_QUERY +"'%"+ year + "' group by issue_d", new LoanMonthRowMapper());
        return loanMonth_list;

    }
}
