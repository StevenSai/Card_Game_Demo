package com.steven.cardgame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GamePlaying {
	
	private Scanner sc;
	
	public Cards initialGame(){
		Cards cardsPlaying = new Cards();//新建一副牌
		//cardsPlaying.showCards();
		cardsPlaying.washCards(1000000);//洗牌
		//cardsPlaying.showCards();
		return cardsPlaying;
	}
	
	public Player getInput(int gamerNum){
		long id = 0;
		String name = null;
		System.out.print("请输入第"+gamerNum+"个玩家的数字ID：");
		while(true){
			try{
				sc = new Scanner(System.in);
				id = sc.nextLong();
				break;
				}catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.print("输入有误，请重新输入数字ID:");
					}
			}
		System.out.print("请输入该玩家的姓名：");
		while(true){
			try{
				sc = new Scanner(System.in);
				name = sc.nextLine();
				break;
				}catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("输入有误，请重新玩家姓名:");
					}
			}
		Player player = new Player(id, name);
		return player;
	}
	
	public void getCardsFromSystem(Cards mainCards,Player p1,Player p2,int numberOfCards){
		int cardsCount = 0;
		for(int i = 0;i < numberOfCards;i++){
			p1.getOneCard(mainCards.getCards().get(cardsCount));
			cardsCount++;
			p2.getOneCard(mainCards.getCards().get(cardsCount));
			cardsCount++;
		}
		p1.showHandCards();
		p2.showHandCards();
	}
	
	public Player fight(Player p1,Player p2){
		if(p1.maxCard().getNumberIndex()>p2.maxCard().getNumberIndex()){
			return p1;
		}else if(p1.maxCard().getNumberIndex()==p2.maxCard().getNumberIndex()){
			if(p1.maxCard().getFlowerIndex()>p2.maxCard().getFlowerIndex()){
				return p1;
			}else return p2;
		}else return p2;
	}
	
	public Player fightlose(Player p1,Player p2){
		if(p1.maxCard().getNumberIndex()>p2.maxCard().getNumberIndex()){
			return p2;
		}else if(p1.maxCard().getNumberIndex()==p2.maxCard().getNumberIndex()){
			if(p1.maxCard().getFlowerIndex()>p2.maxCard().getFlowerIndex()){
				return p2;
			}else return p1;
		}else return p1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GamePlaying newGame = new GamePlaying();
		Cards mainCards = newGame.initialGame();
		Player p1 = newGame.getInput(1);
		Player p2 = newGame.getInput(2);
		newGame.getCardsFromSystem(mainCards, p1, p2, 2);
		Player winner = newGame.fight(p1, p2);
		Player loser = newGame.fightlose(p1, p2);
		System.out.println("赢家是:"+winner.getId()+"."+winner.getName()
				+ "   "+winner.maxCard().getFlower()+winner.maxCard().getNumber()+"赢了"+loser.maxCard().getFlower()+loser.maxCard().getNumber());
	}

}
