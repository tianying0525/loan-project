package com.example.loan.model;

import java.util.Date;

public class LoanAvg {

    private double loadAvg;
    private String level;
    private String month;

    public double getLoadAvg() {
        return loadAvg;
    }

    public void setLoadAvg(double loadAvg) {
        this.loadAvg = loadAvg;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}

