package com.steven.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cards {
	
	
	private List<Card> cards;

	/**
	 * 构造函数，生成一副牌
	 */
	public Cards(){
		cards = new ArrayList<Card>();
		String[] flower = {"♠️","❤️","♣️","♦️"};
		String[] number = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				 cards.add(new Card(flower[i],number[j]));
			}
		}
		System.out.println("==========扑克牌生成完毕==========");
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	/**
	 * 展示牌
	 */
	public void showCards(){
		System.out.println("===========当 前 牌 堆===========");
		System.out.print("[");
		for(int i = 0;i<cards.size();i++){
			Card tempCard = cards.get(i);
			System.out.print(" "+tempCard.flower+tempCard.number);
		}
		//System.out.print("]\n共"+cards.size()+"张牌\n");
		System.out.print("\n");
	}
	
	/**
	 * 洗牌
	 */
	public void washCards(int chaos){
		System.out.println("===========正在洗牌...===========");
		Random random = new Random();
		//System.out.println(random.nextInt(52));
		/**
		 * 循环chaos次交换两个随机位置的牌
		 */
		for(int i = 0;i < chaos;i++){
			int index1 = random.nextInt(52);
			int index2 = 0;
			while(true){
			   index2 = random.nextInt(52);
			   if(index2!=index1)
				   break;
			}
			Card tempCard1 = cards.get(index1);
			Card tempCard2 = cards.get(index2);
			cards.set(index2, tempCard1);
			cards.set(index1, tempCard2);
		}
		//System.out.println("===========已经完成了"+chaos+"次洗牌===========");
		System.out.println("\n\n===========已经完成洗牌===========");
	}
	
}
