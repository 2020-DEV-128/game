package com.game.tenisgame.entity;

public class Game {
	private Player player1;
	private Player player2;
	private Score score ;
	
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Score getScore() {
		return score;
	}
	public Score setScore() {
		score.setValue1(player1.getPoint());
		score.setValue2(player2.getPoint());
		return score;
	}
	public void setScore(int i, int j) {
		player1.setPoint(i); 
		player2.setPoint(j);
		setScore();
	}
	
	public Game() {
	}
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.score = new Score(player1.getPoint(),player2.getPoint());
	}
	

}
