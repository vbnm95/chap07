package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class BlinkTimerExample {
	
	static class Blink extends TimerTask {
		Alpha a;
		boolean isShow;
		
		public Blink() {
			this.a = new Alpha();
		}
		
		@Override
		public void run() {
//			System.out.printf("*** %d ***\n", num);
			if(!isShow)
				a.show();
			else
				a.hide();
			
			isShow = !isShow;
		}
		
	}
	
	public static void main(String[] args) {
		VT100.reset();
		VT100.clearScreen();
		
		Timer timer = new Timer();
		
		for(int i=0; i<100; i++) {
			Blink b = new Blink();
			int speed = (int)(Math.random()*500 + 20);
			timer.schedule(b, 0, speed);
		}
		
		VT100.reset();
	}
}
