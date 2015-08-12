package com.test.threads.ch03.ex05;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable
{

	private String initPath;
	private String end;
	private List<String> results; 
	private Phaser phaser;
	
	public FileSearch(String initPath, String end, Phaser phaser)
	{
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<String>();
	}
	
	@Override
	public void run()
	{
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s: Starting.\n", Thread.currentThread().getName());
		
		File file = new File(initPath);
		if(file.isDirectory())
		{
			directoryProcess(file);
		}
		
		if(!checkResults())
		{
			return;
		}
		
		filterResults();
		
		if(!checkResults())
		{
			return;
		}
		
		showInfo();
		
		phaser.arriveAndDeregister();
		
		System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());
	}
	
	private void directoryProcess(File file)
	{
		File fileList[] = file.listFiles();
		
		if(fileList != null)
		{
			for(int i=0; i<fileList.length; i++)
			{
				if(fileList[i].isDirectory())
				{
					directoryProcess(fileList[i]);
				}
				else
				{
					processFile(fileList[i]);
				}
			}
		}
	}
	
	private void processFile(File file)
	{
		if(file.getName().endsWith(end))
		{
			results.add(file.getAbsolutePath());
		}
	}
	
	private void filterResults()
	{
		List<String> newResults = new ArrayList<String>();
		long actualDate = new Date().getTime();
		
		for(String filePath : results)
		{
			File file = new File(filePath);
			long lastModifiedTime = file.lastModified();
			
			if((actualDate - lastModifiedTime) < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS))
			{
				newResults.add(filePath);
			}
		}
		
		results = newResults;
	}
	
	private boolean checkResults()
	{
		if(results.isEmpty())
		{
			System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
			System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;
		}
		else
		{
			System.out.printf("%s: Phase %d: %d results.\n",Thread.currentThread().getName(), phaser.getPhase(), results.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	
	private void showInfo()
	{
		for(String filePath : results)
		{
			File file = new File(filePath);
			System.out.printf("%s: %s\n",Thread.currentThread().getName(), file.getAbsolutePath());
		}
		
		phaser.arriveAndAwaitAdvance();
	}

}
