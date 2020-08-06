package com.game.tenisgame.service;

import com.game.tenisgame.entity.Player;
import com.game.tenisgame.entity.Game;


public class GameService {

		String filename;
		Game game;
	    
		public GameService(Game game) {
			this.game=game;
		 }
		
	    public String getScoreString(){
		   
	    String scoreString ="";
	    int gap = Math.abs(game.getScore().getValue1() - game.getScore().getValue2());

	   	       if (game.getScore().getValue1() >= 4 || game.getScore().getValue2() >= 4) { // One player won at least 4 balls
	   	    	   
	   	    	scoreString = (gap >= 2) ? getLeadPlayer().getName() + " "+ "wins"
	   	    	                         :  ( gap == 1 ?  "advantage"+" "+ getLeadPlayer().getName() : "deuce" );  
	   	    	   
	   	      }else if (game.getScore().getValue1() == 3 && game.getScore().getValue2() == 3) { // Both players won 3 points
	    	    	 scoreString ="deuce";
	    	   
			     }else {
			      scoreString= getGameScoreDescriptionWhenBothUnder3(); // Only one or no player reach 3 points
			           }
	      return scoreString;
	    }
	    
	     // The function to set the winner. The player who won most points
	    public Player getLeadPlayer() {
	        return (game.getScore().getValue1() > game.getScore().getValue2()) ? game.getPlayer1() : game.getPlayer2();
	        
	    }
	    
	    // If both players won the same number of points then return Description + ALL 
	    public String getGameScoreDescriptionWhenBothUnder3() {
	        return (game.getPlayer1().getPointDescription() == game.getPlayer2().getPointDescription()) ? game.getPlayer1().getPointDescription() +" all" 
	        		                                                                                  : game.getPlayer1().getPointDescription() + " - " + game.getPlayer2().getPointDescription();
	    }

}
