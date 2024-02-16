package com.example.demo.service;

import com.example.demo.models.Customer;
import com.example.demo.models.Transaction;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.views.CustomerView;
import com.example.demo.views.TransactionView;
import com.example.demo.views.TransactionsPerMonthView;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerRewardService {

    private final CustomerRepository customerRepository;

    public CustomerRewardService() {
        this.customerRepository = new CustomerRepository();
    }

    public List<CustomerView> getCustomerRewards() throws ParseException {

        List<CustomerView> customerViewList = new ArrayList<>();

        List<Customer> customerList = customerRepository.getCustomers();
        customerList.forEach(customer -> {
            CustomerView customerView = new CustomerView();
            customerView.setName(customer.getName());
            customerView.setTransactionsPerMonth(getCustomerTransactionsForMonth(customer.getTransactions()));
            customerView.setTotalRewards(getTotalRewardsForCustomer(customerView.getTransactionsPerMonth()));
            customerViewList.add(customerView);
        });

        return customerViewList;
    }

    // todo: should be refactored to use dynamic values instead of hard coded months
    private List<TransactionsPerMonthView> getCustomerTransactionsForMonth(List<Transaction> transactions) {
        List<TransactionsPerMonthView> transactionsPerMonthViews = new ArrayList<>();

        TransactionsPerMonthView transactionsPerMonthViewNovember = new TransactionsPerMonthView();
        transactionsPerMonthViewNovember.setMonth("November 2023");
        transactionsPerMonthViewNovember.setTransactions(getTransactionsForMonth(transactions, 10));
        transactionsPerMonthViewNovember.setTotalRewardsForMonth(getTotalRewardsForMonth(transactionsPerMonthViewNovember.getTransactions()));
        transactionsPerMonthViews.add(transactionsPerMonthViewNovember);

        TransactionsPerMonthView transactionsPerMonthViewDecember = new TransactionsPerMonthView();
        transactionsPerMonthViewDecember.setMonth("December 2023");
        transactionsPerMonthViewDecember.setTransactions(getTransactionsForMonth(transactions, 11));
        transactionsPerMonthViewDecember.setTotalRewardsForMonth(getTotalRewardsForMonth(transactionsPerMonthViewDecember.getTransactions()));
        transactionsPerMonthViews.add(transactionsPerMonthViewDecember);

        TransactionsPerMonthView transactionsPerMonthViewJanuary = new TransactionsPerMonthView();
        transactionsPerMonthViewJanuary.setMonth("January 2024");
        transactionsPerMonthViewJanuary.setTransactions(getTransactionsForMonth(transactions, 0));
        transactionsPerMonthViewJanuary.setTotalRewardsForMonth(getTotalRewardsForMonth(transactionsPerMonthViewJanuary.getTransactions()));
        transactionsPerMonthViews.add(transactionsPerMonthViewJanuary);

        return transactionsPerMonthViews;
    }

    private List<TransactionView> getTransactionsForMonth(List<Transaction> transactions, int month) {
        List<Transaction> transactionsForMonth = transactions.stream().filter(transaction -> {
            // todo: getMonth() is deprecated, replace with updated filtering
            int transactionMonth = transaction.getTransactionDate().getMonth();
            return transactionMonth == month;
        }).toList();
        List<TransactionView> transactionViews = new ArrayList<>();
        transactionsForMonth.forEach(transaction -> {
            TransactionView transactionView = new TransactionView();
            transactionView.setTransactionId(transaction.getTransactionId());
            transactionView.setTransactionDate(transaction.getTransactionDate());
            transactionView.setValueInDollars(transaction.getValueInDollars());
            transactionView.setReward(getTransactionReward(transaction.getValueInDollars()));
            transactionViews.add(transactionView);
        });
        
        return transactionViews;
    }
    
    private Integer getTransactionReward(Integer valueInDollars) {
        if(valueInDollars <= 50) { // values less than 50 receive no reward
            return 0;
        } else if (valueInDollars > 100) {
            Integer rewardForFiftyToOneHundred = 50;
            Integer rewardForOverOneHundred = (valueInDollars - 100) * 2;
            return rewardForFiftyToOneHundred + rewardForOverOneHundred;
        } else { // value is greater than 50 and less than or equal to 100
            return valueInDollars - 50;
        }
    }

    private Integer getTotalRewardsForMonth(List<TransactionView> transactionViews) {
        List<Integer> rewardsList = new ArrayList<>();
        transactionViews.forEach(transactionView -> {
            rewardsList.add(transactionView.getReward());
        });

        return rewardsList.stream().reduce(0, Integer::sum);
    }

    private Integer getTotalRewardsForCustomer(List<TransactionsPerMonthView> transactionsPerMonthViews) {
        List<Integer> rewardList = Arrays.asList(
                transactionsPerMonthViews.get(0).getTotalRewardsForMonth(),
                transactionsPerMonthViews.get(1).getTotalRewardsForMonth(),
                transactionsPerMonthViews.get(2).getTotalRewardsForMonth());
      return rewardList.stream().reduce(0, Integer::sum);
    }
}
