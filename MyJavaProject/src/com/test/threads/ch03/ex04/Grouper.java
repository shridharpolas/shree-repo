package com.test.threads.ch03.ex04;

public class Grouper implements Runnable
{
	private Result result;
	
	public Grouper(Result result)
	{
		this.result = result;
	}
	
	@Override
	public void run()
	{
		int finalResult = 0;
		System.out.println("Grouper: processing result...\n");
		
		int data[] = result.getData();
		
		for(int i=0; i<data.length; i++)
		{
			finalResult += data[i];
		}
		
		System.out.printf("Grouper: Total result: %d.\n",finalResult);

	}

}
