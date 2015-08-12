package com.test.threads.ch01;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread
{
	private Deque<Event> deque;
	
	public CleanerTask(Deque<Event> deque)
	{
		this.deque = deque;
		setDaemon(true);
	}
	
	public void run()
	{
		while(true)
		{
			Date date = new Date();
			clean(date);
		}
	}
	
	private void clean(Date date)
	{
		long difference = 0;
		boolean delete = false;
		
		if(deque.size() == 0)
		{
			return;
		}
		
		do
		{
			Event event = deque.getLast();
			difference = new Date().getTime() - event.getDate().getTime();
			
			if(difference > 10000)
			{
				System.out.printf("Cleaner: %s\n", event.getEvent());
				deque.removeLast();
				delete = true;
			}
		} while (difference > 10000);
		
		if(delete)
		{
			System.out.printf("Cleaner: the size of the queue: %d\n", deque.size());
		}
	}
}
