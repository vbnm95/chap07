package com.example;

import java.util.TimerTask;

public class OverridingExample {
	static class A {
		void show() {
			System.out.println("A.show() ...");
		}
	}
	
	static class B extends A {
		@Override
		void show() {
			System.out.println("B.show() ...");
		}
		
		void hide() {
			System.out.println("B.hide() ...");
		}
	}
	
	static class C extends TimerTask {
		
		@Override
		public void run() {
			
			
		}
	}
	
	public static void main(String[] args) {
		B b = new B();
		
		A a = b;
		
		a.show();
		//a.hide();
		
		b.hide();
		
	}

}
