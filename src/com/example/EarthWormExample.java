package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class EarthWormExample {
	enum Direction {
		LEFT, RIGHT, UP, DOWN
	}
	
	static class MoveAlpha extends Alpha {
		Direction direction;
		
		public MoveAlpha() {
			show();
			direction = Direction.values()[(int)(Math.random()*4)];
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
		
		void up() {
			hide();
			line--;
			show();
		}
		
		void down() {
			hide();
			line++;
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
	
	static class MoveTask extends TimerTask {
		static int count;
		int moveCount;
		MoveAlpha alpha = new MoveAlpha();
		
		MoveTask() {
			count++;
		}
		
		@Override
		public void run() {				
			if(alpha.getLine() == 1 || alpha.getLine() == 20 || alpha.getColumn() == 1 || alpha.getColumn() == 40) {
				alpha.hide();
				count--;
				super.cancel();
			
				if(count == 0) {
					timer.cancel();
					VT100.reset();
					VT100.cursorMove(21, 1);
					System.out.println("Program End...");
				}
			
				return;
			}
				
			synchronized (System.out) {
				alpha.move();
			}
			
			moveCount++;
			
			if(moveCount == 5) {
				alpha.direction = Direction.values()[(int)(Math.random()*4)];
				moveCount = 0;
			}
			
		}
	}
	
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		for(int i=0; i<100; i++) {
			timer.schedule(new MoveTask(), 0, 100);
		}
		
		VT100.reset();
	}
}
