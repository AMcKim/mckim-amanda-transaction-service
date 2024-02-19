package com.example.demo.repository;

import com.example.demo.models.Customer;
import com.example.demo.models.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{


    public List<Customer> getCustomers() throws ParseException {

        return createMockCustomerList();
    }

    private List<Customer> createMockCustomerList() throws ParseException {
        Customer customer1 = new Customer();
        customer1.setName("Amanda");
        customer1.setTransactions(getAmandasTransactions());

        Customer customer2 = new Customer();
        customer2.setName("Martha");
        customer2.setTransactions(getMarthasTransactions());

        Customer customer3 = new Customer();
        customer3.setName("Bob");
        customer3.setTransactions(getBobsTransactions());

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        return customerList;
    }

    private List<Transaction> getAmandasTransactions() throws ParseException {
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionId("transaction-1");
        transaction1.setTransactionDate(("2023-11-12"));
        transaction1.setValueInDollars(25);

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionId("transaction-2");
        transaction2.setTransactionDate(("2023-12-12"));
        transaction2.setValueInDollars(75);

        Transaction transaction3 = new Transaction();
        transaction3.setTransactionId("transaction-3");
        transaction3.setTransactionDate(("2024-01-15"));
        transaction3.setValueInDollars(100);

        Transaction transaction4 = new Transaction();
        transaction4.setTransactionId("transaction-4");
        transaction4.setTransactionDate(("2024-01-25"));
        transaction4.setValueInDollars(120);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);

        return transactionList;
    }

    private List<Transaction> getMarthasTransactions() throws ParseException {
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionId("transaction-1");
        transaction1.setTransactionDate(("2023-11-01"));
        transaction1.setValueInDollars(200);

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionId("transaction-2");
        transaction2.setTransactionDate(("2023-12-20"));
        transaction2.setValueInDollars(82);

        Transaction transaction3 = new Transaction();
        transaction3.setTransactionId("transaction-3");
        transaction3.setTransactionDate(("2023-12-30"));
        transaction3.setValueInDollars(15);

        Transaction transaction4 = new Transaction();
        transaction4.setTransactionId("transaction-4");
        transaction4.setTransactionDate(("2024-01-14"));
        transaction4.setValueInDollars(51);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);

        return transactionList;
    }

    private List<Transaction> getBobsTransactions() throws ParseException {
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionId("transaction-1");
        transaction1.setTransactionDate(("2023-11-05"));
        transaction1.setValueInDollars(25);

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionId("transaction-2");
        transaction2.setTransactionDate(("2023-11-12"));
        transaction2.setValueInDollars(75);

        Transaction transaction3 = new Transaction();
        transaction3.setTransactionId("transaction-3");
        transaction3.setTransactionDate(("2024-01-10"));
        transaction3.setValueInDollars(100);

        Transaction transaction4 = new Transaction();
        transaction4.setTransactionId("transaction-4");
        transaction4.setTransactionDate(("2024-01-31"));
        transaction4.setValueInDollars(120);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);

        return transactionList;
    }

    private Date parseDate(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    }
}
