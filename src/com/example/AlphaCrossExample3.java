package com.example;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample3 {
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
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		Cross c = new Cross();
		
		for(;;) {
			c.move();
			
			if(c.getLine() == 1 || 
				c.getLine() == 20 ||
				c.getColumn() == 1 || 
				c.getColumn() == 40
			) {
				c.hide();
				break;
			}
			Thread.sleep(100);
		}
		
		VT100.reset();
	}
}

