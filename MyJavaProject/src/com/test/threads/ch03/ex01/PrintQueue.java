package com.test.threads.ch03.ex01;

import java.util.concurrent.Semaphore;

public class PrintQueue
{
	private final Semaphore semaphore;
	
	public PrintQueue()
	{
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document)
	{
		try
		{
			semaphore.acquire();
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a job %d duration\n", Thread.currentThread().getName(), duration);
			Thread.sleep(duration);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			semaphore.release();
		}
	}
}
