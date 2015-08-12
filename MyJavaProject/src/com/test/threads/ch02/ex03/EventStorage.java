package com.test.threads.ch02.ex03;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage
{
	private int maxSize;
	private Queue<Date> storage;
	
	public EventStorage()
	{
		maxSize = 10;
		storage = new LinkedList<Date>();
	}
	
	public synchronized void set()
	{
		while(storage.size() == maxSize)
		{
			try
			{
				wait();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		storage.offer(new Date());
		System.out.printf("Set: %d\n", storage.size());
		notifyAll();
	}
	
	public synchronized void get()
	{
		while(storage.size() == 0)
		{
			try
			{
				wait();
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("Get: %d: %s\n", storage.size(), storage.poll());
		notifyAll();
	}
}
