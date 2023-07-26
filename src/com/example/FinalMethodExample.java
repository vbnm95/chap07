package com.example;

public class FinalMethodExample {
	static class A {
		
		void xxx() {
			
		}
		
		final void yyy() {
			
		}
	}
	
	static class B extends A {
		@Override
		void xxx() {
			
		}
		
//		@Override
//		void yyy() {
//			
//		}
	}
	
	public static void main(String[] args) {
		
	}
}
