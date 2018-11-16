package com.example.loan.mapper;

import com.example.loan.model.LoanAvg;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanAvgRowMapper implements RowMapper {
    @Override
    public LoanAvg mapRow(ResultSet rs, int rowNum) throws SQLException {
        LoanAvg loanAvg = new LoanAvg();
        loanAvg.setLoadAvg(rs.getDouble("LoanAvg"));
        loanAvg.setLevel(rs.getString("grade") + "_Grade");
        loanAvg.setMonth(rs.getString("issue_d"));

        return loanAvg;
    }
}
