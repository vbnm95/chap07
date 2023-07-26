package com.example;

public class SealedClassExample {

	static sealed class Person permits Employee, Manager {
		
	}
	
	static non-sealed class Employee extends Person {
		
	}
	
	static non-sealed class Manager extends Person {
		
	}
	
//	static non-sealed class Student extends Person {
//		
//	}
//	
	
}
