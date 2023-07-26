package com.example;

import util.Alpha;
import util.VT100;

public class DecoAlphaExample {
	
	static class DecoAlpha extends Alpha{
		
		@Override
		public void show() {
			super.show();
			VT100.cursorMove(getLine()+1, getColumn());
			VT100.reset();
			VT100.print('=');
		}
		
		@Override
		public void hide() {
			super.hide();
			VT100.cursorMove(getLine()+1, getColumn());
			VT100.reset();
			VT100.print(' ');
		}
		
		public void blink() throws InterruptedException {
			show();
			Thread.sleep(50);
			hide();
			Thread.sleep(50);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		DecoAlpha da = new DecoAlpha();
		
		for(int i = 0 ; i < 100 ; i ++) {
			da.blink();
		}
		
		VT100.reset();
	}
}
