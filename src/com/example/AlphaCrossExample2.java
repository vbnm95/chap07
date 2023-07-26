package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample2 {
	
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
		
		public BlinkTimerTask() {
			totalCount++;
		}
		
		@Override
		public void run() {
			
			switch(direction) {
			
			case "RIGHT":
				alphaMove.right();
				break;
				
			case "DOWN":
				alphaMove.down();
				break;
				
			case "LEFT":
				alphaMove.left();
				break;
				
			case "UP":
				alphaMove.up();
				break;
				
			default:
				break;
		
			}
			
			if(alphaMove.getColumn() == 40 && direction == "RIGHT") {
				alphaMove.hide();
				cancel();
				totalCount--;
			} else if(alphaMove.getLine() == 20 && direction == "DOWN") {
				alphaMove.hide();
				cancel();
				totalCount--;
			} else if(alphaMove.getColumn() == 1 && direction == "LEFT") {
				alphaMove.hide();
				cancel();
				totalCount--;
			} else if(alphaMove.getLine() == 1 && direction == "UP") {
				alphaMove.hide();
				cancel();
				totalCount--;
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
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		for(int i=0; i<1000; i++) {
			BlinkTimerTask t = new BlinkTimerTask();
			int speed = (int)(Math.random()*3000 + 500);
			timer.schedule(t, 0, speed);
			
			Thread.sleep(10);
		}
		
		VT100.reset();
	}
}

