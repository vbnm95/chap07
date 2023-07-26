package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample {

	static class AlphaMove extends Alpha {
		public AlphaMove() {
//			super()
			line = 10;
			column = 20;
		}
		
		void right() {
			hide();
			column++;
			show();
		}
		
		void down() {
			hide();
			line++;
			show();
		}
		
		void left() {
			hide();
			column--;
			show();
		}
		
		void up() {
			hide();
			line--;
			show();
		}
	}
	
	static class BlinkTimerTask extends TimerTask {
		static int totalCount = 0;
		
		AlphaMove alphaMove = new AlphaMove();
		
		String[] directionArr = {"RIGHT", "DOWN", "LEFT", "UP"};
		int randomDirection = (int)(Math.random()*4);		
		String direction = directionArr[randomDirection];
		
		int count;
		
		public BlinkTimerTask() {
			totalCount++;
		}
		
		@Override
		public void run() {
			VT100.reset();
			
			switch(direction) {
			
			case "RIGHT":
				while(true) {
					alphaMove.right();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(alphaMove.getColumn() == 40) {
						alphaMove.hide();
						cancel();
						break;
					}
				}
				break;
				
			case "DOWN":
				while(true) {
					alphaMove.down();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(alphaMove.getLine() == 20) {
						alphaMove.hide();
						cancel();
						break;
					}
				}
				break;
				
			case "LEFT":
				while(true) {
					alphaMove.left();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(alphaMove.getColumn() == 1) {
						alphaMove.hide();
						cancel();
						break;
					}
				}
				break;
				
			case "UP":
				while(true) {
					alphaMove.up();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(alphaMove.getLine() == 1) {
						alphaMove.hide();
						cancel();
						break;
					}
				}
				break;
				
			default:
				break;
		
			}
			
			
			if(totalCount == 0) {
				timer.cancel();
				VT100.reset();
				VT100.cursorMove(21, 1);
				System.out.println("Program End...");
			}
		}
	}
		
	static Timer timer = new Timer();
		
	public static void main(String[] args) {
		VT100.clearScreen();
		VT100.reset();
		
		for(int i=0; i<1000; i++) {
			BlinkTimerTask t = new BlinkTimerTask();
			timer.schedule(t, 0, 50);
		}
		
	}
}
