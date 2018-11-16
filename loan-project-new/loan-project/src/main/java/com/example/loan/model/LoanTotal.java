package com.example.loan.model;

public class LoanTotal {

    private double loan_total;
    private double funded_total;
    private double funded_inv;
    //private LoanAvg loanAvg;

    public double getLoan_total() {
        return loan_total;
    }

    public void setLoan_total(double loan_total) {
        this.loan_total = loan_total;
    }

    public double getFunded_total() {
        return funded_total;
    }

    public void setFunded_total(double funded_total) {
        this.funded_total = funded_total;
    }

    public double getFunded_inv() {
        return funded_inv;
    }

    public void setFunded_inv(double funded_inv) {
        this.funded_inv = funded_inv;
    }

//    public LoanAvg getLoanAvg() {
//        return loanAvg;
//    }
//
//    public void setLoanAvg(LoanAvg loanAvg) {
//        this.loanAvg = loanAvg;
//    }
}
