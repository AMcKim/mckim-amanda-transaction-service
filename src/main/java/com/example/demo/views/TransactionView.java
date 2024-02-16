package com.example.demo.views;

import java.util.Date;

public class TransactionView {
    private String transactionId;
    private Date transactionDate;
    private Integer valueInDollars;

    private Integer reward;

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

    public Integer getReward() {
        return this.reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }
}
