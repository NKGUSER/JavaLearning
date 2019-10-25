package com.test;


public class Ethread extends Thread{
	

	@Override
	public void run() {
		
		synchronized (this) {	
		System.out.println("Extended Thread is runnning");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Extended Thread is Finished ");
		}	
	}

}
