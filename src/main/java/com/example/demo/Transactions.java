package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Transactions {

	public static void main(String[] args) {
		SpringApplication.run(Transactions.class, args);
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "hello";
	}
}
