package com.example.loan.mapper;

import com.example.loan.model.LoanAvg;
import com.example.loan.model.LoanMonth;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanMonthRowMapper implements RowMapper {
    @Override
    public LoanMonth mapRow(ResultSet rs, int rowNum) throws SQLException {
        LoanMonth loanMonth = new LoanMonth();
        loanMonth.setCount(rs.getInt("Count"));
        loanMonth.setMonth(rs.getString("issue_d"));

        return loanMonth;
    }
}
