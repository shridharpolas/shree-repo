package com.test.threads.ch01;

public class MainThreadFactory
{
	public static void main(String[] args)
	{
		MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
		TaskThreadFactory task = new TaskThreadFactory();
		Thread thread;
		
		for(int i=0; i<10; i++)
		{
			thread = myThreadFactory.newThread(task);
			thread.start();
		}
		
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n", myThreadFactory.getStatistics());
	}
}
