package com.example.demo.service;

import com.example.demo.models.Customer;
import com.example.demo.models.Transaction;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.CustomerRepositoryImpl;
import com.example.demo.views.CustomerView;
import com.example.demo.views.TransactionView;
import com.example.demo.views.TransactionsPerMonthView;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerRewardService {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final CustomerRepository customerRepository;

    public CustomerRewardService() {
        this.customerRepository = new CustomerRepositoryImpl();
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


        Map<String, List<Transaction>> transactionsPerMonthMap = transactions
                .stream()
                .collect(Collectors.groupingBy(t -> String.valueOf(YearMonth.parse(t.getTransactionDate(), DATE_TIME_FORMATTER))));

        SortedSet<String> keys = new TreeSet<>(transactionsPerMonthMap.keySet());

        for (String key : keys) {
            List<Transaction> transactionList = transactionsPerMonthMap.get(key);

            TransactionsPerMonthView transactionsPerMonthView = new TransactionsPerMonthView();
            transactionsPerMonthView.setMonth(key);
            transactionsPerMonthView.setTransactions(getTransactionViews(transactionList));
            transactionsPerMonthView.setTotalRewardsForMonth(getTotalRewardsForMonth(transactionsPerMonthView.getTransactions()));
            transactionsPerMonthViews.add(transactionsPerMonthView);
        }

        return transactionsPerMonthViews;
    }

    private List<TransactionView> getTransactionViews(List<Transaction> transactions) {
        List<TransactionView> transactionViews = new ArrayList<>();
        transactions.forEach(transaction -> {
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
        } else if (valueInDollars > 100) { // values over 100 receive fifty for 51-100 and X2 for amount over 100
            Integer rewardForFiftyToOneHundred = 50;
            Integer rewardForOverOneHundred = (valueInDollars - 100) * 2;
            return rewardForFiftyToOneHundred + rewardForOverOneHundred;
        } else { // value is greater than 50 and less than or equal to 100
            return valueInDollars - 50;
        }
    }

    private Integer getTotalRewardsForMonth(List<TransactionView> transactionViews) {
        List<Integer> rewardsList = transactionViews.stream().map(TransactionView::getReward).collect(Collectors.toList());
        return getSumFromList(rewardsList);
    }

    private Integer getTotalRewardsForCustomer(List<TransactionsPerMonthView> transactionsPerMonthViews) {
//        List<Integer> rewardList = Arrays.asList(
//                transactionsPerMonthViews.get(0).getTotalRewardsForMonth(),
//                transactionsPerMonthViews.get(1).getTotalRewardsForMonth(),
//                transactionsPerMonthViews.get(2).getTotalRewardsForMonth());
        List<Integer> rewardList = transactionsPerMonthViews.stream().map(TransactionsPerMonthView::getTotalRewardsForMonth).collect(Collectors.toList());
        return getSumFromList(rewardList);
    }

    private Integer getSumFromList(List<Integer> rewardList) {
        return rewardList.stream().reduce(0, Integer::sum);
    }
}
