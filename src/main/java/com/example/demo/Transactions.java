package com.example.demo;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

//WebAPI
//
//A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
//
//A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
//
//		(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
//
//Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.
//
//		·       Solve using Spring Boot
//
//·       Create a RESTful endpoint
//
//·       Make up a data set to best demonstrate your solution
//
//·       Check solution into GitHub
//


//////////////////////////////////////////////////////////

// Assumptions

// Create a GET endpoint to return a list of customers, containing their transactions per month, rewards per transaction and rewards per month
// Fetched data will contain customer and transaction data from a three-month period.  Filtering will be handled by data access.
// Can treat transaction value as an integer


@SpringBootApplication
@RestController
public class Transactions {

	public static void main(String[] args) {
		SpringApplication.run(Transactions.class, args);
	}

	private CustomerRepository customerRepository = new CustomerRepository();

//	public class CustomerTransactions(CustomerRepository customerRepository) {
//		this.customer
//	}

//	@GetMapping("/greeting")
//	public String greeting() {
//		return "hello";
//	}

	@GetMapping("/") // todo: refactor this to controller class
	public List<Customer> getCustomerList() { // todo: update to return CustomerViews
		try {
			return customerRepository.getCustomers();
		} catch (ParseException ex) {
			return (List<Customer>) ex;
		}

	}
}
