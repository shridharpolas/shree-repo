package com.test.threads.ch03.ex04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable
{
	private int firstRow;
	private int lastRow;
	private MatrixMock matrix;
	private Result result;
	private int number;
	private final CyclicBarrier barrier;
	
	public Searcher(int firstRow, int lastRow, MatrixMock matrix, Result results, int number, CyclicBarrier barrier)
	{
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.matrix = matrix;
		this.result = results;
		this.number = number;
		this.barrier = barrier;
	}
	@Override
	public void run()
	{
		int counter;
		
		System.out.printf("%s: Processing lines from %d to %d\n", Thread.currentThread(), firstRow, lastRow);
		for(int i=firstRow; i<lastRow; i++)
		{
			int[] row = matrix.getRow(i);
			counter = 0;
			for(int j=0; j<row.length; j++)
			{
				if(row[j] == number)
				{
					counter++;
				}
			}
			
			result.setData(i, counter);
		}
		
		System.out.printf("%s: Lines processed\n", Thread.currentThread().getName());
		
		try
		{
			barrier.await();
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
