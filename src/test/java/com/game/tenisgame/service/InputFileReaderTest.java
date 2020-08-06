package com.game.tenisgame.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.game.tenisgame.entity.Game;

@RunWith(JUnitPlatform.class)
public class InputFileReaderTest {

	String filename1 = "src/main/resources/Advantage John.txt"; // The input file used to test the reader
	InputFileReader inputFileReader = new InputFileReader();
	
	// In the input file we got 2 players (John & Djokovic), john appeared 5 time (he won 5  balls). Djokovic appeared 4 time (he won 4 balls).
	@Test
	public void testInputFileReader() {
		Game game = inputFileReader.getGame(filename1);
		assertEquals("john", game.getPlayer1().getName());
		assertEquals("djokovic", game.getPlayer2().getName());
		assertEquals(5, game.getPlayer1().getPoint());
		assertEquals(4, game.getPlayer2().getPoint());
	}		
}
