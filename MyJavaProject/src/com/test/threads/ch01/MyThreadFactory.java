package com.test.threads.ch01;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory
{
	
	private int counter;
	private String name;
	private List<String> stats;
	
	public MyThreadFactory(String name)
	{
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}
	
	@Override
	public Thread newThread(Runnable r)
	{
		Thread t = new Thread(r, name + "-Thread_" + counter);
		counter++;
		stats.add(String.format("Create thread %d with name %s on %s", t.getId(), t.getName(), new Date()));
		return t;
	}

	public String getStatistics()
	{
		StringBuffer buffer = new StringBuffer();
		Iterator<String> iterator = stats.iterator();
		
		while(iterator.hasNext())
		{
			buffer.append(iterator.next());
			buffer.append("\n");
		}
	
		return buffer.toString();
	}
}
