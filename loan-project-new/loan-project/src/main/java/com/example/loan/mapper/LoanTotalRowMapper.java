package com.example.loan.mapper;

import com.example.loan.model.LoanTotal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanTotalRowMapper implements RowMapper {
    @Override
    public LoanTotal mapRow(ResultSet rs, int rowNum) throws SQLException {
        LoanTotal loanTotal = new LoanTotal();
        loanTotal.setLoan_total(rs.getDouble("LoanTotal"));
        loanTotal.setFunded_total(rs.getDouble("FundTotal"));
        loanTotal.setFunded_inv(rs.getDouble("FundInvTotal"));

        return loanTotal;
    }
}
