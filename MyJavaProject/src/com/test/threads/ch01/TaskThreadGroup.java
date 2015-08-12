package com.test.threads.ch01;

import java.util.Random;

public class TaskThreadGroup implements Runnable
{

	@Override
	public void run()
	{
		int result;
		Random random = new Random(Thread.currentThread().getId());
		
		while(true)
		{
			result = 1000/((int) (random.nextDouble() * 1000));
			System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);
			
			if(Thread.currentThread().isInterrupted())
			{
				System.out.printf("%d : interrupted", Thread.currentThread().getId());
				return;
			}
		}
	}
	
}
