package com.example;

public class CastingExample {
	
	static class A {
		
	}
	
	static class B extends A {
		
	}
	
	public static void main(String[] args) {
		
		A a = new A();
		
		B b = new B();
		
		A aa = b; // 자동 형변환( Up-casting )
		
		if( aa instanceof B) {
			B bb = (B) aa; // 강제 형변환( Down-casting ), B 타입이었던 aa를 강제 형변환해야 프로그램 오류가 없음.
			System.out.println("casting");
		}
		
		System.out.println("Program End");
		
	}

}
