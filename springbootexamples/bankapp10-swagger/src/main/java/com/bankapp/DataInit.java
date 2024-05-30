package com.bankapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bankapp.entity.Account;
import com.bankapp.repository.AccountRepository;

@Component
public class DataInit implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//As soon as app start spring boot will run this run method 
		//data init job
		//String name, BigDecimal balance, String phone, String email, String address
		accountRepository.save(new Account("amit", BigDecimal.valueOf(1000.00),"9958543978","amit@gmail.com","delhi"));
		accountRepository.save(new Account("sumit",BigDecimal.valueOf(1000.00), "9958543998","sumit@gmail.com","noida"));
		System.out.println("-------------2 accounts are added ---------------------");
	}

}
