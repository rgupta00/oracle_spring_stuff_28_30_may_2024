package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entity.Account;
import com.bankapp.exception.BankAccountNotFoundException;
import com.bankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account getById(int id) {
		Account account= accountRepository.findById(id).orElseThrow(()->new BankAccountNotFoundException("bank account not found") );
		return account;
	}

	@Override
	public void transfer(int fromId, int toId, BigDecimal amount) {
		Account fromAcc=getById(fromId);
		Account toAcc=getById(toId);
		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		toAcc.setBalance(toAcc.getBalance().add(amount));
		
		accountRepository.save(fromAcc);
		accountRepository.save(toAcc);
		
	}

	@Override
	public void deposit(int fromId, BigDecimal amount) {
		Account acc=getById(fromId);
		acc.setBalance(acc.getBalance().add(amount));
		accountRepository.save(acc);
		
	}

	@Override
	public void withdraw(int fromId, BigDecimal amount) {
		Account acc=getById(fromId);
		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepository.save(acc);
	}

}
