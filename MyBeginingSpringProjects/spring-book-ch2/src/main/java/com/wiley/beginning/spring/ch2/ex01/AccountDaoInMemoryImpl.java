package com.wiley.beginning.spring.ch2.ex01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoInMemoryImpl implements AccountDao {

	private Map<Long, Account> accountsMap = new HashMap<>();
	{
		Account account1 = new Account();
		account1.setId(1L);
		account1.setOwnerName("John");
		account1.setBalance(10.0);
		Account account2 = new Account();
		account2.setId(2L);
		account2.setOwnerName("Mary");
		account2.setBalance(20.0);
		accountsMap.put(account1.getId(), account1);
		accountsMap.put(account2.getId(), account2);
	}

	public void insert(Account account) {
		// TODO Auto-generated method stub

	}

	public void update(Account account) {
		accountsMap.put(account.getId(), account);
	}

	public void update(List<Account> accounts) {
		// TODO Auto-generated method stub

	}

	public void delete(long accountId) {
		// TODO Auto-generated method stub

	}

	public Account find(long accountId) {
		return accountsMap.get(accountId);
	}

	public List<Account> find(List<Long> accountIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}

}
