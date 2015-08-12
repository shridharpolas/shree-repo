package com.test.threads.ch02.ex05;

public class Reader implements Runnable
{

	private PriceInfo priceInfo;
	
	public Reader(PriceInfo priceInfo)
	{
		this.priceInfo = priceInfo;
	}
	
	@Override
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), priceInfo.getPrice1());
			System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), priceInfo.getPrice2());
		}

	}

}
