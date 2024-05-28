package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repository.Account;
import com.bankapp.repository.AccountDao;
import com.bankapp.repository.AccountDaoMapImpl;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account=accountDao.getById(id);
		if(account==null)
			throw new BankAccountNotFoundException("bank account not found");
		return account;
	}

	@Override
	public void transfer(int fromId, int toId, double amount) {
		Account fromAcc=getById(fromId);
		Account toAcc=getById(toId);
		
		fromAcc.setAmount(fromAcc.getAmount()-amount);
		toAcc.setAmount(toAcc.getAmount()+ amount);
		
		accountDao.updateAccount(fromAcc);
		accountDao.updateAccount(toAcc);
	}

	@Override
	public void deposit(int fromId, double amount) {
		Account acc=getById(fromId);
		acc.setAmount(acc.getAmount()+amount);
		accountDao.updateAccount(acc);
	}

	@Override
	public void withdraw(int fromId, double amount) {
		Account acc=getById(fromId);
		acc.setAmount(acc.getAmount()-amount);
		accountDao.updateAccount(acc);
	}

}
