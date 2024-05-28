package com.bankapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
@Repository
@Profile("test")
public class AccountDaoJdbcImpl implements AccountDao {

	private Map<Integer, Account> map = new HashMap<>();

	public AccountDaoJdbcImpl() {
		map.put(1, new Account(1, "raj", 1000));
		map.put(2, new Account(2, "ekta", 1000));
	}

	@Override
	public List<Account> getAll() {
		System.out.println("jdbc code");
		return new ArrayList<>(map.values());
	}

	@Override
	public Account getById(int id) {
		 return map.get(id);
	}

	@Override
	public void updateAccount(Account account) {
		map.put(account.getId(), account);
	}

}
