package com.bankapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
public class TransctionController {

	private AccountService accountService;

	public TransctionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//from postman i am sending json that need to be converted to java object: @RequestBody
	// transfer
	@PostMapping(path="transfer")
	public String transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(),transferDto.getToAccId()	 , transferDto.getAmount());
		return "fund transfer successfully";
	}
	
	//deposit
	@PostMapping(path="deposit")
	public String deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "fund deposit successfully";
	}
	
	//withdraw
	@PostMapping(path="withdraw")
	public String withdraw(@RequestBody  WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "fund withdra successfully";
	}
	
}
