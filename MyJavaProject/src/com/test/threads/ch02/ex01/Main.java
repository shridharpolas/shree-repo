package com.test.threads.ch02.ex01;

public class Main
{
	public static void main(String[] args)
	{
		Account account = new Account();
		account.setBalance(1000);
		
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		System.out.printf("Initial balance: %f\n", account.getBalance());
		
		companyThread.start();
		bankThread.start();
		
		try
		{
			companyThread.join();
			bankThread.join();
			System.out.printf("Final balance: %f\n", account.getBalance());
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
