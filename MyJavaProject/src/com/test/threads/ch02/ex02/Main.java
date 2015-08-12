package com.test.threads.ch02.ex02;

public class Main
{
	public static void main(String[] args)
	{
		Cinema cinema = new Cinema();
		TicketOffice1 office1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(office1);
		
		TicketOffice2 office2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(office2);
		
		thread1.start();
		thread2.start();
		
		try
		{
			thread1.join();
			thread2.join();
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 vacancies %d\n", cinema.getVacanciesCinema1());
		System.out.printf("Room 2 vacancies %d\n", cinema.getVacanciesCinema2());
		
	}
}
