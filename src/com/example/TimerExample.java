package com.example;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
	
	static class A extends TimerTask {
		@Override
		public void run() {
			System.out.println("Run()...");
			
		}
	}

	public static void main(String[] args) {
		A a = new A();
		
		Timer timer = new Timer();
		TimerTask t1 = a;
		
//		timer.schedule(t1, 5000);
		timer.schedule(a, 0, 1000);
		
		System.out.println("Program End ...");
	}
}
