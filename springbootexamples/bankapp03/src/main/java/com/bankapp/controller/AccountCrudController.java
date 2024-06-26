package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDetailDto;
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
	
	
	//@RequestBody force json object to be converted to java object, 
	//proper "parser" jackson parser is alredy in the classpath
	//we just need to add parser for xml
	
	//------------add account-------
	@PostMapping(path = "accounts")
	public Account addAccount( @RequestBody Account account) {
		return accountService.addAccount(account);
	}
	
	
	//------------delete account by id--------
	@DeleteMapping(path = "accounts/{id}")
	public Account deleteById(@PathVariable  int id) {
		return accountService.deleteAccount(id);
	}
	
	//------------update account by id--------
	@PutMapping(path = "accounts/{id}")
	public String updateAccount(@PathVariable  int id,@RequestBody AccountDetailDto accountDetailDto) {
		 accountService.updateAccount(id, accountDetailDto);
		 return "account details are updated successfully";
	}

}
