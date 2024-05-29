package com.bankapp.service;

import java.util.List;

import com.bankapp.entity.Account;

public interface AccountService {
	public List<Account> getAll();
    public Account getById(int id);
    public void transfer(int fromId, int toId, double amount);
    public void deposit(int fromId, double amount);
    public void withdraw(int fromId, double amount);
}
