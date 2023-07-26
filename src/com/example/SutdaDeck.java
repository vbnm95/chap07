package com.example;

public class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		for(int i=1; i<cards.length+1; i++) {
			int n = i % 10;
			if(n == 1 || n == 3 || n == 8) {
				if(i<10) {
					cards[i-1] = new SutdaCard(n, true);
				} else {
					cards[i-1] = new SutdaCard(n, false);
				}
			} else if(n == 0){
				cards[i-1] = new SutdaCard(10, false);
			} else {
				cards[i-1] = new SutdaCard(n, false);
			}
		}
	}
	
	void shuffle() {
		SutdaCard[] cards2 = new SutdaCard[CARD_NUM];
		
		for(int i=0; i<cards.length; i++) {
			while(true) {
				int n = (int)(Math.random()*20);
				if(cards2[n] == null) {
					cards2[n] = cards[i];
					break;
				} else {
					continue;
				}
			}
		}
		
		for(int i=0; i<cards.length; i++) {
			cards[i] = cards2[i];
		}
	}
	
	SutdaCard pick(int index) {
		return cards[index];
	}
	
	SutdaCard pick() {
		int n = (int)(Math.random()*20);
		return cards[n];
	}
	
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for(int i=0; i<deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		System.out.println();
		System.out.println(deck.pick(0));
	}

}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num + (isKwang ? "K" : "");
	}	
}
