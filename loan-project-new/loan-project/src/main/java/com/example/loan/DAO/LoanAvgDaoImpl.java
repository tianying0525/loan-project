package com.example.loan.DAO;

import com.example.loan.mapper.LoanAvgRowMapper;
import com.example.loan.model.LoanAvg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LoanAvgDaoImpl implements LoanAvgDao {
    private final String LOANAVG_QUERY = "SELECT AVG(loan_amnt) AS LoanAvg, grade,issue_d FROM loan WHERE issue_d like";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public List<LoanAvg> getLoanAvgAtGivenYear(String year){
        List<LoanAvg> loanAvg_list = jdbcTemplate.query(LOANAVG_QUERY +"'%"+ year + "' group by issue_d, grade", new LoanAvgRowMapper());
        return loanAvg_list;

    }
}
