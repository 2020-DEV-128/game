package com.game.tenisgame.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.game.tenisgame.entity.Game;
import com.game.tenisgame.entity.Player;
import com.game.tenisgame.service.GameService;

@RunWith(JUnitPlatform.class)
class GameServiceTest {


	Game game = new Game(new Player("John") , new Player("Peter")); // The players are john and Peter.
	GameService gameservice = new GameService(game);
	
	// WWhen the score is 0 - 0. Should be "love all"
  	@Test
	public void testNewGameShouldReturnLoveAll(){
		String score = gameservice.getScoreString(); 
		assertEquals("love all", score);
	}
	
 // WWhen the score is 1 - 0. Should be "fifteen - love"
	@Test
	public void testPlayerOneWinsFirstBall(){
		createScore(1, 0);
		String score = gameservice.getScoreString(); 
		assertEquals("fifteen - love", score);		
	}
	
  // WWhen the score is 1 - 1. Should be "fifteen - fifteen"
	@Test
	public void testFifteenAll(){
		createScore(1, 1);
		String score = gameservice.getScoreString();
		assertEquals("fifteen all", score);
	}
	
	// WWhen the score is 0 - 2. Should be "love - thirty"
	@Test
	public void testPlayerTwoWinsFirstTwoBalls() {
		createScore(0, 2);
		String score = gameservice.getScoreString(); 
		assertEquals("love - thirty", score);
	}
	
	// WWhen the score is 3 - 0. Should be "forty - love"
	@Test
	public void testPlayerOneWinsFirstThreeBalls(){
		createScore(3, 0);
		String score = gameservice.getScoreString();	
		assertEquals("forty - love", score);
	}
	
	// WWhen the score is 3 - 3. Should be "deuce"
	@Test
	public void testPlayersAreDeuce() {
		createScore(3, 3);
		String score = gameservice.getScoreString();	
		assertEquals("deuce", score);		
	}
	
	 // WWhen the score is 4 - 0. Should be "John wins"
	@Test
	public void testPlayerOneWinsGame()	{
		createScore(4, 0);	
		String score = gameservice.getScoreString();	
		assertEquals("John wins", score);
	}
	
	 // WWhen the score is 1 - 4. Should be "Peter wins"
 	@Test
	public void testPlayerTwoWinsGame(){
		createScore(1,4);
		String score = gameservice.getScoreString();	
		assertEquals("Peter wins", score);
	}
	
  // WWhen the score is 4 - 4. Should be "deuce"
	@Test
	public void testPlayersAreDuce4() {
		createScore(4, 4);
		String score = gameservice.getScoreString();	
		assertEquals("deuce", score);		
	}

  // WWhen the score is 4 - 5. Should be "advantage peter"
	@Test
	public void testPlayerTwoAdvantage(){	
		createScore(4, 5);	
		String score = gameservice.getScoreString();	
		assertEquals("advantage Peter", score);
	} 

   // WWhen the score is 5 - 4. Should be "adventage john"
	@Test
	public void testPlayerOneAdvantage(){	
		createScore(5, 4);	
		String score = gameservice.getScoreString();	
		assertEquals("advantage John", score);
	}
	 // WWhen the score is 2 - 4. Should be "peter wins"
    @Test
	public void testPlayerTwoWins(){
		createScore(2, 4);	
		String score = gameservice.getScoreString();	
		assertEquals("Peter wins", score);
	}
	
    // WWhen the score is 6 - 8. Should be "peter wins"
	@Test
	public void testPlayerTwoWinsAfterAdvantage() {	
		createScore(6, 8);
		String score = gameservice.getScoreString(); 
		assertEquals("Peter wins", score);
	}
	
	 // WWhen the score is 8 - 6. Should be "john wins"
 	@Test	
	public void testPlayerOneWinsAfterAdvantage() {	
		createScore(8, 6);	
		String score = gameservice.getScoreString(); 
		assertEquals("John wins", score);
	}  
	
 	// Setup the score to test
	private void createScore(int player1BallsWon, int player2BallsWon ) {
			game.setScore( player1BallsWon, player2BallsWon);
		
		}
		
}
