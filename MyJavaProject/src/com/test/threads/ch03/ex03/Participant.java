package com.test.threads.ch03.ex03;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable
{
	private Videoconference conference;
	private String name;
	
	public Participant(Videoconference conference, String name)
	{
		this.conference = conference;
		this.name = name;
	}
	
	@Override
	public void run()
	{
		long duration = (long) (Math.random() * 10);
		
		try
		{
			TimeUnit.SECONDS.sleep(duration);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conference.arrive(name);
	}

}
