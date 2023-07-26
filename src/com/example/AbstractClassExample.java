package com.example;

import java.util.TimerTask;

public class AbstractClassExample {

	static abstract class Animal {
		abstract void sound();
	}
	
	static class Cat extends Animal {
		@Override
		void sound() {
			System.out.println("야옹");
		}
	}
	
	static class Dog extends Animal {
		@Override
		void sound() {
			System.out.println("멍멍");
		}
	}
	
	static class People extends Animal {
		@Override
		void sound() {
			System.out.println("야호");
		}
	}
	
	static class A extends TimerTask {
		@Override
		public void run() {
			
		}
	}
	
	public static void main(String[] args) {
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		Animal a3 = new People();
		
		a1.sound();
		a2.sound();
		a3.sound();
	}
}
