package com.example.demo.views;

import java.util.List;

public class TransactionsPerMonthView {

    private String month;
    private List<TransactionView> transactions;

    private Integer totalRewardsForMonth;

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<TransactionView> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<TransactionView> transactions) {
        this.transactions = transactions;
    }

    public Integer getTotalRewardsForMonth() {
        return  this.totalRewardsForMonth;
    }

    public void setTotalRewardsForMonth(Integer totalRewards) {
        this.totalRewardsForMonth = totalRewards;
    }
}
