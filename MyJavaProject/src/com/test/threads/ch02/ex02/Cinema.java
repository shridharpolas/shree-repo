package com.test.threads.ch02.ex02;

public class Cinema
{
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	private Object controlCinema1;
	private Object controlCinema2;
	
	public Cinema()
	{
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}
	
	public long getVacanciesCinema1()
	{
		return vacanciesCinema1;
	}
	
	public void setVacanciesCinema1(long vacanciesCinema1)
	{
		this.vacanciesCinema1 = vacanciesCinema1;
	}
	
	public long getVacanciesCinema2()
	{
		return vacanciesCinema2;
	}
	
	public void setVacanciesCinema2(long vacanciesCinema2)
	{
		this.vacanciesCinema2 = vacanciesCinema2;
	}
	
	public boolean sellTickets1(int number)
	{
		synchronized (controlCinema1)
		{
			if(number < vacanciesCinema1)
			{
				vacanciesCinema1 -= number;
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	public boolean sellTickets2(int number)
	{
		synchronized (controlCinema2)
		{
			if(number < vacanciesCinema2)
			{
				vacanciesCinema2 -= number;
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public boolean returnTickets1(int number)
	{
		synchronized (controlCinema1)
		{
			vacanciesCinema1 += number;
			return true;
		}
	}
	
	public boolean returnTickets2(int number)
	{
		synchronized (controlCinema2)
		{
			vacanciesCinema2 += number;
			return true;
		}
	}
}
