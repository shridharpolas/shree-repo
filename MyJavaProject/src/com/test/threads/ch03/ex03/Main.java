package com.test.threads.ch03.ex03;

public class Main
{
	public static void main(String[] args)
	{
		Videoconference conference = new Videoconference(10);
		Thread conferenceThread = new Thread(conference);
		conferenceThread.start();
		
		for(int i=0; i<10; i++)
		{
			Participant participant = new Participant(conference, "Participant-" + i);
			Thread participantThread = new Thread(participant);
			participantThread.start();
		}
	}
}
