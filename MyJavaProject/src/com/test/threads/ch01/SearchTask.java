package com.test.threads.ch01;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable
{
	
	private Result result;
	
	public SearchTask(Result result)
	{
		this.result = result;
	}
	
	@Override
	public void run()
	{
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: start", name);
		
		try
		{
			doTask();
			result.setName(name);
		} 
		catch (InterruptedException e)
		{
			System.out.printf("Thread %s is interrupted\n", name);
			return;
		}
		
		System.out.printf("Thread %s Ends\n", name);
	}
	
	private void doTask() throws InterruptedException
	{
		Random random = new Random(new Date().getTime());
		int value = (int) (random.nextDouble()*100);
		System.out.printf("Thread %s : %d\n", Thread.currentThread().getName(), value);
		TimeUnit.SECONDS.sleep(value);
	}

}
