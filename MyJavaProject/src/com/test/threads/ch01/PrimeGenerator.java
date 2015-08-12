package com.test.threads.ch01;

public class PrimeGenerator extends Thread
{
	public static void main(String[] args)
	{
		Thread task = new PrimeGenerator();
		task.start();
		
		try
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		task.interrupt();
	}
	
	private static boolean isPrimeNumber(long number)
	{
		if(number < 2)
		{
			return true;
		}
		else
		{
			for(int i=2; i<number; i++)
			{
				if((number % i) == 0)
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void run()
	{
		long number = 1L;
		
		while(true)
		{
			if(isPrimeNumber(number))
			{
				System.out.printf("Number %d is the prime number.\n", number);
			}
			
			if(isInterrupted())
			{
				System.out.printf("The prime number generator has been interrupted.\n");
				break;
			}
			
			number++;
		}
	}
}
