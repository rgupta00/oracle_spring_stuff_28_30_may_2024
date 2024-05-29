package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

//@RestController
@Controller
@ResponseBody
public class AccountCrudController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}


	//@ResponseBody annotation ie contain inside @RestController automatically covert java object to json
	//-----------get all accounts-----
	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//------------get account by id--------
	@GetMapping(path = "accounts/{id}")
	public Account getById(@PathVariable  int id) {
		return accountService.getById(id);
	}
	
	
	//------------add account-------
	
	
	//------------delete account by id--------
	
	
	//------------update account by id--------

}
