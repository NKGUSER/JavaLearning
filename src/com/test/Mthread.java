package com.test;

public class Mthread implements Runnable{

	@Override
	public void run() {
		
		try {
			
			System.out.println("Thread is runnning - "+ Thread.currentThread().getName());
		}
		catch(Exception e) {
			
			System.out.print("Exception caught");
		}
		
	}
}
