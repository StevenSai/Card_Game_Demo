package com.steven.cardgame;

public class Card {
	
	private String flower;
	private String number;
	private int flowerIndex;
	private int numberIndex;
	
	public int getFlowerIndex() {
		return flowerIndex;
	}

	public void setFlowerIndex(int flowerIndex) {
		this.flowerIndex = flowerIndex;
	}

	public int getNumberIndex() {
		return numberIndex;
	}

	public void setNumberIndex(int numberIndex) {
		this.numberIndex = numberIndex;
	}

	public String getFlower() {
		return flower;
	}

	public void setFlower(String flower) {
		this.flower = flower;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Card(String flower, String number) {
		super();
		int tempNums=0,tempFlos=0;
		String[] nums = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] flos = {"♦️","♣️","❤️","♠️"};
		this.flower = flower;
		this.number = number;
		for(String n:nums){
			if(number.equals(n)){
				this.numberIndex = tempNums;
			}else tempNums++;
		}
		for(String f:flos){
			if(flower.equals(f)){
				this.flowerIndex = tempFlos;
			}else tempFlos++;
		}
	}
}
