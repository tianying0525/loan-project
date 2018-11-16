package com.example.loan.model;

import java.util.Date;

public class Customer {

    private int id;
    private float loan_amount;
    private float funded_amount;
    private float funded_amount_inv;
    private String grade;
    private Date issue_date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(float loan_amount) {
        this.loan_amount = loan_amount;
    }

    public float getFunded_amount() {
        return funded_amount;
    }

    public void setFunded_amount(float funded_amount) {
        this.funded_amount = funded_amount;
    }

    public float getFunded_amount_inv() {
        return funded_amount_inv;
    }

    public void setFunded_amount_inv(float funded_amount_inv) {
        this.funded_amount_inv = funded_amount_inv;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }
}
