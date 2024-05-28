package com.bankapp.repository;

import java.util.List;

//it have crud methods
public interface AccountDao {
	public List<Account> getAll();

	public Account getById(int id);

	public void updateAccount(Account account);
}
