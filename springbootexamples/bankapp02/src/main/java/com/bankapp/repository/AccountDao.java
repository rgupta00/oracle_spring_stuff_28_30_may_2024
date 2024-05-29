package com.bankapp.repository;

import java.util.List;

import com.bankapp.entity.Account;

public interface AccountDao {
	public List<Account> getAll();

	public Account getById(int id);

	public void updateAccount(Account account);
}
