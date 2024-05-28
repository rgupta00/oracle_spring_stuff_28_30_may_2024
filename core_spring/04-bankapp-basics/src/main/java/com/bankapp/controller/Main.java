package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.repository.Account;
import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		AccountService accountService = (AccountService) ctx.getBean("accountServiceImpl");
		List<Account> accounts = accountService.getAll();
		for (Account acc : accounts) {
			System.out.println(acc);
		}

		accountService.transfer(1, 2, 10);

		System.out.println("bank status after fund transfer");
		accounts = accountService.getAll();
		for (Account acc : accounts) {
			System.out.println(acc);
		}

	}
}
