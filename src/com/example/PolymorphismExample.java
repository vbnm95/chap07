package com.example;

public class PolymorphismExample {

	static abstract class Shape {
		
		abstract void draw(); // 추상 메소드
	}
	
	static class Rectangle extends Shape {
		@Override
		void draw() {
			System.out.println("####");
			System.out.println("####");
			System.out.println("####");
			System.out.println("####");
		}
	}
	
	static class Triangle extends Shape {
		@Override
		void draw() {
			System.out.println("   #");
			System.out.println("  ##");
			System.out.println(" ###");
			System.out.println("####");
		}
	}
	
	public static void main(String[] args) {
		Shape s;
		
		s = new Rectangle();
		s.draw();
		
		s = new Triangle();
		s.draw();
	}
}
