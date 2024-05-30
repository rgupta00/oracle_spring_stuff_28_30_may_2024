package com.bankapp.controller;

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

	public TransctionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//from postman i am sending json that need to be converted to java object: @RequestBody
	// transfer
	@PostMapping(path="transfer")
	public ResponseEntity<String> transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(),transferDto.getToAccId()	 , transferDto.getAmount());
		String fundTransferMessage= "fund transfer successfully";
		return ResponseEntity.ok(fundTransferMessage);
	}
	
	//deposit
	@PostMapping(path="deposit")
	public ResponseEntity<String> deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		String fundDepositMessage= "fund deposit successfully";
		return ResponseEntity.ok(fundDepositMessage);
	}
	
	//withdraw
	@PostMapping(path="withdraw")
	public ResponseEntity<String> withdraw(@RequestBody  WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		String fundWithdrawMessage= "fund withdraw successfully";
		return ResponseEntity.ok(fundWithdrawMessage);
	}
	
}
