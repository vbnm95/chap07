package com.example;

import util.VT100;

public class BlinkExample {

	static class Blink extends util.Alpha{
		int speed;
		
		public Blink() {
			this(100);
		}
		
		public Blink(int speed) {
			super();
			this.speed = speed;
		}
		
		void blink() throws InterruptedException {
			show();
			Thread.sleep(speed);
			hide();
			Thread.sleep(speed);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		Blink b = new Blink(30);
		for(int i = 0; i<100; i++) {
			b.blink();
		}
		
		System.out.println("Program End ...");
	}
}
