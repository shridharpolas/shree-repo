package com.test.threads.ch02.ex01;

public class Account
{
	private double balance;

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public synchronized void addAmount(double amount)
	{
		double tmp = balance;
		
		try
		{
			Thread.sleep(10);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tmp += amount;
		balance = tmp;
	}
	
	public synchronized void substractAmount(double amount)
	{
		double tmp = balance;
		
		try
		{
			Thread.sleep(10);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tmp -= amount;
		balance = tmp;
	}
}
