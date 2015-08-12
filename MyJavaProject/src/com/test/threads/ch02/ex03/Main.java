package com.test.threads.ch02.ex03;

public class Main
{
	public static void main(String[] args)
	{
		EventStorage storage = new EventStorage();
		
		Producer producer = new Producer(storage);
		Thread producerThread = new Thread(producer);
		
		Consumer consumer = new Consumer(storage);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
	}
}
