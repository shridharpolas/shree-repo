package com.test.threads.ch01;

import java.util.concurrent.TimeUnit;

public class TaskThreadFactory implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			TimeUnit.SECONDS.sleep(1);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
