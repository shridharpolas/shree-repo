package com.test.threads.ch03.ex03;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable
{

	private final CountDownLatch controller;
	
	public Videoconference(int number)
	{
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name)
	{
		System.out.printf("%s has arrived.\n", name);
		controller.countDown();
		
		System.out.printf("Videoconference: waiting for %d participants to join.\n", controller.getCount());
	}
	
	@Override
	public void run()
	{
		System.out.printf("Videoconference: Initialization: Total %d participants.\n", controller.getCount());
		
		try
		{
			controller.await();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.printf("Videoconference: All participants have come: %d\n", controller.getCount());
		System.out.printf("VideoConference: Let's start...\n");
	}

}
