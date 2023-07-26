package com.example;

import util.Alpha;
import util.VT100;

public class AlphaMoveExample {
	
	static class AlphaMove extends Alpha {
		public AlphaMove() {
//			super()
			line = 1;
			column = 1;
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
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		VT100.reset();
		
		AlphaMove a = new AlphaMove();
		
		while(true) {
			for(int i=0; i<10; i++) {
				a.right();
				Thread.sleep(100);
			}
		
			for(int i=0; i<10; i++) {
				a.down();
				Thread.sleep(100);
			}
		
			for(int i=0; i<10; i++) {
				a.left();
				Thread.sleep(100);
			}
		
			for(int i=0; i<10; i++) {
				a.up();
				Thread.sleep(100);
			}
		}
		
	}
}
