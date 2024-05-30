package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.dto.AccountDetailDto;
import com.bankapp.entity.Account;

public interface AccountService {
	public List<Account> getAll();
    public Account getById(int id);
    public void transfer(int fromId, int toId, BigDecimal amount);
    public void deposit(int fromId, BigDecimal amount);
    public void withdraw(int fromId, BigDecimal amount);
    
    public Account addAccount(Account account);
    public Account deleteAccount(int id);
    public void updateAccount(int id, AccountDetailDto accountDetailDto);
}
