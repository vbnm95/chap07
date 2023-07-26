package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample4 {
	enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	static class Cross extends Alpha {
		final Direction direction;
		
		public Cross() {
			super();
			line = 10;
			column = 20;
			direction = Direction.values()[(int)(Math.random()*4)];
			show();
		}
		
		void left() {
			hide();
			column--;
			show();
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
		
		void up() {
			hide();
			line--;
			show();
		}
		
		void move() {
			switch(direction) {
			case UP:
				up();
				break;
				
			case DOWN:
				down();
				break;
				
			case RIGHT:
				right();
				break;
				
			case LEFT:
				left();
				break;
				
			}
		}
	}
	
	static class CrossTask extends TimerTask {
		static int count;
		Cross alpha = new Cross();
		
		CrossTask() {
			CrossTask.count++;
		}
		
		@Override
		public void run() {
			if(alpha.getLine() == 1 || 
				alpha.getLine() == 20 || 
				alpha.getColumn() == 1 || 
				alpha.getColumn() == 40
			) {
				alpha.hide();
				CrossTask.count--;
				super.cancel();
				
				if(CrossTask.count == 0) {
					timer.cancel();
					VT100.reset();
					VT100.cursorMove(21, 1);
					System.out.println("Program End...");
				}
				
				return;
			}
			
			alpha.move();
			
		}
	}
	
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		for(int i=0; i<1000; i++) {
			int speed = (int)(Math.random()*500 + 10);
			timer.schedule(new CrossTask(), 0, speed);
			Thread.sleep(50);
		}
		
	}
}

