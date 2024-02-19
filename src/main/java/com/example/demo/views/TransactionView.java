package com.example.demo.views;

import java.time.LocalDate;
import java.util.Date;

public class TransactionView {
    private String transactionId;
    private String transactionDate;
    private Integer valueInDollars;

    private Integer reward;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
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
