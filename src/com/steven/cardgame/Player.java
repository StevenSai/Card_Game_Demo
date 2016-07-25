package com.steven.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private long id;
	private String name;
	private List<Card> handCards;
	
	
	public Player(long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.handCards = new ArrayList<Card>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 摸一张牌到手牌
	 * @param getOne--摸的牌
	 */
	
	public void getOneCard(Card getOne){
		handCards.add(getOne);
	}
	
	
	/**
	 * 判断手牌中当前数字最大的牌
	 * @return 手牌中当前数字最大的牌
	 */
	
	public Card maxCard(){
		Card maxCard = new Card("","");
		for(Card tempMaxCard:handCards){
			if(maxCard.getNumber().equals("")||tempMaxCard.getNumberIndex()>maxCard.getNumberIndex()){
				
				maxCard.setNumber(tempMaxCard.getNumber());
				maxCard.setNumberIndex(tempMaxCard.getNumberIndex());
				maxCard.setFlower(tempMaxCard.getFlower());
				maxCard.setFlowerIndex(tempMaxCard.getFlowerIndex());
				
			}
		}
		return maxCard;
	}
	
	/**
	 * 展示手牌
	 */
	
	public void showHandCards(){
		System.out.print(this.name+"的手牌如下:\n[");
		for(Card c:handCards){
			System.out.print(" "+c.getFlower()+c.getNumber());
		}
		System.out.print(" ]\n");
	}
	
}
