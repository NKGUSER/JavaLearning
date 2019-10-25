package com.test;

public class Mthread implements Runnable{

	Ethread e;
	
	public Mthread(Ethread e) {
	
		 this.e = e;
	}
	
	@Override
	public void run() {
		
		synchronized (e) {	
		try {
			System.out.println("Thread is runnning - "+ Thread.currentThread().getName());
            this.e.notify();
		}
		catch(Exception e) {
			System.out.print("Exception caught");
		}
		System.out.println("Thread is Finished - "+ Thread.currentThread().getName());
		}
		
		
	}
}
