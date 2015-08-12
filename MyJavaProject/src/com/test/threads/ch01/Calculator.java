package com.test.threads.ch01;

public class Calculator implements Runnable 
{
	private int number;
	
	public Calculator(int number)
	{
		this.number = number;
	}
	
	@Override
	public void run()
	{
		for(int i = 1; i <= 10; i++)
		{
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, (number * i));
		}
	}
	
	public static void main(String[] args)
	{
		for(int i = 1; i <= 10; i++)
		{
			Calculator c = new Calculator(i);
			Thread thread = new Thread(c);
			thread.start();
		}
	}
}
