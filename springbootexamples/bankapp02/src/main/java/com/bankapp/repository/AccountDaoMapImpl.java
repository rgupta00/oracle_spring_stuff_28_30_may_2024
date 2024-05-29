package com.bankapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bankapp.entity.Account;

@Repository
public class AccountDaoMapImpl implements AccountDao{

    private Map<Integer, Account> map=new HashMap<>();
    public AccountDaoMapImpl(){
        map.put(1, new Account(1,"amit",1000));
        map.put(2, new Account(2,"sumit",1000));
    }
    @Override
    public List<Account> getAll() {
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
