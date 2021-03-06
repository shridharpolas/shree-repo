package com.test.threads.ch03.ex01;

public class Main
{
	public static void main(String[] args)
	{
		PrintQueue printQueue = new PrintQueue();
		Thread thread[] = new Thread[10];
		
		for(int i=0; i<10; i++)
		{
			thread[i] = new Thread(new Job(printQueue), "Thread-" + i);
		}
		
		for(int i=0; i<10; i++)
		{
			thread[i].start();
		}
	}
}
