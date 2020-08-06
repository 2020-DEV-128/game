package com.game.tenisgame.entity;

import java.util.Arrays;
import java.util.List;

public class Player {
	
	public static final List<String> pointDescription = Arrays.asList("love", "fifteen", "thirty", "forty");
	
	//The variables
	private String name;
	private int point;
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPoint() {
	return point;
	}
	
	public void setPoint(int point) {
	this.point = point;
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, int point) {
		this.name = name;
		this.point = point;
	}
	//Det the description of the player score
	public String getPointDescription(){
	return pointDescription.get(point);
	 }


}
