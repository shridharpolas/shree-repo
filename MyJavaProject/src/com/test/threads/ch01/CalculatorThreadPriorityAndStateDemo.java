package com.test.threads.ch01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorThreadPriorityAndStateDemo implements Runnable
{
	private int number;
	
	public CalculatorThreadPriorityAndStateDemo(int number)
	{
		this.number = number;
	}
	
	public static void main(String[] args)
	{
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		
		for(int i=0; i<10; i++)
		{
			threads[i] = new Thread(new Calculator(i));
			
			if((i%2)==0) 
			{
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}
			else
			{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			
			threads[i].setName("Thread " + i);
		}
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try
		{
			fw = new FileWriter("log.txt");
			pw = new PrintWriter(fw);
			
			for(int i=0; i<10; i++)
			{
				pw.println("Main: Status of Thread " + i + ":" + threads[i].getState());
				status[i] = threads[i].getState();
			}
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		for(int i=0; i<10; i++)
		{
			threads[i].start();
		}
		
		boolean finish = false;
		
		while(!finish)
		{
			for(int i=0; i<10; i++)
			{
				if(threads[i].getState() != status[i])
				{
					writeThreadInfo(pw, threads[i], status[i]);
					status[i] = threads[i].getState();
				}
				
			}
			
			finish = true;
			
			for(int i=0; i<10; i++)
			{
				finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
			}
		}
		
		pw.close();
	}
	
	private static void writeThreadInfo(PrintWriter pw, Thread t, Thread.State status)
	{
		pw.printf("Main: Id %d - %s\n", t.getId(), t.getName());
		pw.printf("Main: Priority %d\n", t.getPriority());
		pw.printf("Main: Old state %s\n", status);
		pw.printf("Main: New state %s\n", t.getState());
		pw.printf("Main: **************************************\n");
	}

	@Override
	public void run()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.printf("%s: %d * %d = %d", Thread.currentThread().getName(), number, i, (number * i));
		}
	}
}
