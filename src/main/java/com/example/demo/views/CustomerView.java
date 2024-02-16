package com.example.demo.views;

import java.util.List;

public class CustomerView {
    private String name;

    private List<TransactionsPerMonthView> transactionsPerMonth;

    private Integer totalRewards;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TransactionsPerMonthView> getTransactionsPerMonth() {
        return this.transactionsPerMonth;
    }

    public void setTransactionsPerMonth(List<TransactionsPerMonthView> transactionsPerMonth) {
        this.transactionsPerMonth = transactionsPerMonth;
    }

    public Integer getTotalRewards() {
        return this.totalRewards;
    }

    public void setTotalRewards(Integer totalRewards) {
        this.totalRewards = totalRewards;
    }
}
