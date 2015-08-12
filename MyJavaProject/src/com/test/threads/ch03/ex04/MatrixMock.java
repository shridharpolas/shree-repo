package com.test.threads.ch03.ex04;

import java.util.Random;

public class MatrixMock
{
	private int data[][];
	
	public MatrixMock(int size, int length, int number)
	{
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<length; j++)
			{
				data[i][j] = random.nextInt();
				if(data[i][j] == number)
				{
					counter++;
				}
			}
		}
		
		System.out.printf("Mock: There are %d ocurrences of number in generated data.\n", counter, number);
	}
	
	public int[] getRow(int row)
	{
		if(row >= 0 && data.length > row)
		{
			return data[row];
		}
		
		return null;
	}
}
