package com.example;

public class Exercise7_7 {

	static class Parent {
		int x = 100;
		
		Parent() {
			this(200);
		}
		
		Parent(int x) {
			this.x = x;
		}
		
		int getX() {
			return x;
		}
	}
	
	static class Child extends Parent {
		int x = 3000;
		
		Child() {
			this(1000);
		}
		
		Child(int x) {
			this.x = x;
		}
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		
		System.out.println("x=" + c.getX());
	}
}
