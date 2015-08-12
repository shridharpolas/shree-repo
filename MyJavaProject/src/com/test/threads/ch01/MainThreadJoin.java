package com.test.threads.ch01;

import java.util.Date;

public class MainThreadJoin
{
	public static void main(String[] args)
	{
		DataSourceLoader dsl =  new DataSourceLoader();
		Thread thread1 = new Thread(dsl, "DataSourceLoader");
		
		NetworkConnectionLoader ncl = new NetworkConnectionLoader();
		Thread thread2 = new Thread(ncl, "NetworkConnectionLoader");
		
		thread1.start();
		thread2.start();
		
		try
		{
			thread1.join();
			thread2.join();
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}
}
