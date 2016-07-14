package com.wiley.beginning.spring.ch2.ex01;

public interface AccountService {
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount);

	public void depositMoney(long accountId, double amount) throws Exception;

	public Account getAccount(long accountId);
}
