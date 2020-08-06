package com.game.tenisgame;

import com.game.tenisgame.service.GameService;
import com.game.tenisgame.service.InputFileReader;

public class Main {

	public static void main(String[] args) {
		
		// Some input files to test multiple scenarios
		String filename1 = "src/main/resources/Advantage John.txt";
		String filename2 = "src/main/resources/Deuce.txt";
		String filename3 = "src/main/resources/Deuce1.txt";
		String filename4 = "src/main/resources/Djokovic Win.txt";
		String filename5 = "src/main/resources/Thirty All.txt";  
		String filename6 = "src/main/resources/Forty-Love.txt"; 
		InputFileReader inputFileReader =  new InputFileReader (); 

		System.out.println(new GameService (inputFileReader.getGame(filename1)).getScoreString());   // advantage john
		System.out.println(new GameService (inputFileReader.getGame(filename2)).getScoreString());   // deuce
	    System.out.println(new GameService (inputFileReader.getGame(filename3)).getScoreString());    // deuce
		System.out.println(new GameService (inputFileReader.getGame(filename4)).getScoreString());     // djokovic wins
		System.out.println(new GameService (inputFileReader.getGame(filename5)).getScoreString());  // thirty all
		System.out.println(new GameService (inputFileReader.getGame(filename6)).getScoreString());   // forty - love
		
	}

}
