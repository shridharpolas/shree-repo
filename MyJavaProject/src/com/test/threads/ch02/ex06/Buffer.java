package com.test.threads.ch02.ex06;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer
{
	private LinkedList<String> buffer;
	private int maxSize;
	
	private ReentrantLock lock;
	
	private Condition lines;
	private Condition space;
	
	private boolean pendingLines;
	
	public Buffer(int maxSize)
	{
		this.maxSize = maxSize;
		buffer = new LinkedList<String>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line)
	{
		lock.lock();
		
		try
		{
			while(buffer.size() == maxSize)
			{
				space.await();
			}
			
			buffer.offer(line);
			System.out.printf("%s: inserted line: %d\n", Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public String get()
	{
		String line = null;
		
		lock.lock();
		
		try
		{
			while(buffer.size() == 0)
			{
				lines.await();
			}
			
			if(hasPendingLines())
			{
				line = buffer.poll();
				System.out.printf("%s: line readed: %d\n", Thread.currentThread().getName(), buffer.size());
				space.signalAll();
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
		
		return line;
	}
	
	public void setPendingLines(boolean pendingLines)
	{
		this.pendingLines = pendingLines;
	}
	
	public boolean hasPendingLines()
	{
		return pendingLines || buffer.size() > 0;
	}
	
}
