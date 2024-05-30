package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
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
	private Environment environment;

	
	@Autowired
	public TransctionController(AccountService accountService, Environment environment) {
		this.accountService = accountService;
		this.environment = environment;
	}
	
	//from postman i am sending json that need to be converted to java object: @RequestBody
	// transfer
	@PostMapping(path="transfer")
	public ResponseEntity<String> transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(),transferDto.getToAccId()	 , transferDto.getAmount());
		
		String fundTransferMessage= environment.getProperty("UserInterface.TRANSFER_SUCCESS");
		
		return ResponseEntity.ok(fundTransferMessage);
	}
	
	//deposit
	@PostMapping(path="deposit")
	public ResponseEntity<String> deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		String fundDepositMessage= environment.getProperty("UserInterface.DEPOSIT_SUCCESS");
		return ResponseEntity.ok(fundDepositMessage);
	}
	
	//withdraw
	@PostMapping(path="withdraw")
	public ResponseEntity<String> withdraw(@RequestBody  WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		String fundWithdrawMessage= environment.getProperty("UserInterface.WITHDRAW_SUCCESS");
		return ResponseEntity.ok(fundWithdrawMessage);
	}
	
}
