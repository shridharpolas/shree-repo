package com.test.threads.ch01;

public class MainExceptionHandler
{
	public static void main(String[] args)
	{
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
