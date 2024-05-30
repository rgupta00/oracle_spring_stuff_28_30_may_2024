package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dto.AccountDetailDto;
import com.bankapp.entity.Account;
import com.bankapp.exception.BankAccountNotFoundException;
import com.bankapp.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> getAll() {
		/*
		 * if(1==1) throw new RuntimeException();
		 */
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
		
		/*
		 * if(1==1) throw new RuntimeException("some run time error");
		 */
		
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

	@Override
	public Account addAccount(Account account) {
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account deleteAccount(int id) {
		Account accountToDelete= getById(id);
		accountRepository.delete(accountToDelete);
		return accountToDelete;
	}

	@Override
	public void updateAccount(int id, AccountDetailDto accountDetailDto) {
		Account accountToUpdated= getById(id);
		accountToUpdated.setAddress(accountDetailDto.getAddress());
		accountToUpdated.setPhone(accountDetailDto.getPhone());
		accountToUpdated.setEmail(accountDetailDto.getEmail());
		
		accountRepository.save(accountToUpdated);//save do both add/update operation ins spring data
	}

}
