package com.game.tenisgame.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.game.tenisgame.entity.Game;
import com.game.tenisgame.entity.Player;


public class InputFileReader {
	
	public Game getGame(String filename){

		
		List<Player>  listOfPlayers = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(filename), Charset.defaultCharset())){
	          
		                     listOfPlayers = stream
						                     .map(String::toLowerCase)  // All in lowercase to allow comparison of names.
						                     // A map. key = player name  and value = number of appearances of the name (number of balls won).
						                     .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
						                     .entrySet()
						             		 .stream()
						             		 .map(x ->  new Player (x.getKey(), x.getValue()) )
						               	     .collect(Collectors.toList()); // Collect objects "Player" to a list.
	        } catch (IOException e) {
	            throw new UncheckedIOException(e);
            }
		//when there is only one name that appears in the input file, it means that there is a 2nd player but he has not won any ball.
		return (listOfPlayers.size() > 1) ? new Game (listOfPlayers.get(0),  listOfPlayers.get(1)) : new Game (listOfPlayers.get(0),  new Player("defaultPlayer"));
		
    }  

}
