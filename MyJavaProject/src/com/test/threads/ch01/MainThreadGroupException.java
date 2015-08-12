package com.test.threads.ch01;

public class MainThreadGroupException
{
	public static void main(String[] args)
	{
		MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
		TaskThreadGroup task = new TaskThreadGroup();
		
		for(int i=0; i<2; i++)
		{
			Thread t = new Thread(myThreadGroup, task);
			t.start();
		}
		
	}
}
