package com.example;

public class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int preChannel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public boolean getIsPowerOn() {
		return this.isPowerOn;
	}
	
	public void setIsPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	
	public int getChannel() {
		return this.channel;
	}
	
	public void setChannel(int channel) {
		this.preChannel = this.channel;
		this.channel = channel;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void gotoPrevChannel() {
		this.channel = this.preChannel;
	}
	
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("ch: " + t.getChannel());
		t.setChannel(20);
		System.out.println("ch: " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("ch: " + t.getChannel());
		t.gotoPrevChannel();;
		System.out.println("ch: " + t.getChannel());
		
		
//		t.setVolume(20);
//		System.out.println("vol: " + t.getVolume());
	}
}

