package com.test.threads.ch03.ex04;

import java.util.concurrent.CyclicBarrier;

public class Main
{
	public static void main(String[] args)
	{
		final int ROWS = 100000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int LINES_PARTICIPANT = 2000;
		
		MatrixMock matrix = new MatrixMock(ROWS, NUMBERS, SEARCH);
		Result result = new Result(ROWS);
		Grouper grouper = new Grouper(result);
		
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
		Searcher searchers[] = new Searcher[PARTICIPANTS];
		
		for (int i=0; i<PARTICIPANTS; i++)
		{
			searchers[i] = new Searcher((i * LINES_PARTICIPANT), ((i * LINES_PARTICIPANT) + LINES_PARTICIPANT), matrix, result, SEARCH, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		
		System.out.printf("Main: The main thread has finished.\n");
	}
}
