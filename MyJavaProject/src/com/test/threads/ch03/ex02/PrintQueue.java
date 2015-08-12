package com.test.threads.ch03.ex02;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;

public class PrintQueue
{
	private boolean freePrinters[];
	private Lock lockPrinters;
	private Semaphore semaphore;
	
	public PrintQueue()
	{
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		
		for(int i=0; i<3; i++)
		{
			freePrinters[i] = true;
		}
		
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob(Object document)
	{
		try
		{
			semaphore.acquire();
			int assignedPrinter = getPrinter();
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: Printing a job in printer %d for the duration %d\n", Thread.currentThread().getName(), assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter] = true;
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			semaphore.release();
		}
	}
	
	private int getPrinter()
	{
		int ret = -1;
		
		try
		{
			lockPrinters.lock();
			for(int i=0; i<freePrinters.length; i++)
			{
				if(freePrinters[i])
				{
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			lockPrinters.unlock();
		}
		
		return ret;
	}
}
