package com.example.demo.models;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private String transactionId;
    private String transactionDate;
    private Integer valueInDollars;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

//    public String getTransactionMonth() {
//        return this.transactionDate.getMonth().toString();
//    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getValueInDollars() {
        return this.valueInDollars;
    }

    public void setValueInDollars(Integer valueInDollars) {
        this.valueInDollars = valueInDollars;
    }
}
