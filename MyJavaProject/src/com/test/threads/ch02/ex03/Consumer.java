package com.test.threads.ch02.ex03;

public class Consumer implements Runnable
{
	private EventStorage storage;
	
	public Consumer(EventStorage storage)
	{
		this.storage = storage;
	}

	@Override
	public void run()
	{
		for(int i=0; i<100; i++)
		{
			storage.get();
		}

	}

}
