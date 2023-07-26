package com.example;

public class Exercise7_5 {
	static class Product {
		int price;
		int bonusPoint;
		
		Product(int price) {
			this.price = price;
			bonusPoint = (int)(price/10.0);
		}
	}
	
	static class Tv extends Product {
		Tv(int price) {
			super(price);
		}
		
		public String toString() {
			return "Tv";
		}
	}
	
	public static void main(String[] args) {
		Tv t = new Tv(1000);
		
		System.out.println(t.price);
		System.out.println(t.bonusPoint);
	}
}
