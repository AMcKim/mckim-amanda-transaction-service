package com.example.demo.models;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private Date transactionDate;
    private Integer valueInDollars;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getValueInDollars() {
        return this.valueInDollars;
    }

    public void setValueInDollars(Integer valueInDollars) {
        this.valueInDollars = valueInDollars;
    }
}
