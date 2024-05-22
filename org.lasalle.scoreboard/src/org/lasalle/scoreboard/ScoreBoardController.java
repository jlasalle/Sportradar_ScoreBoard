package org.lasalle.scoreboard;

import org.lasalle.scoreboard.game.Game;
import org.lasalle.scoreboard.game.GameBuilder;

/**
 * Controller dedicated to ScoreBoard management
 * 
 * @author Jonathan Lasalle
 */
public class ScoreBoardController {

	/**
	 * Start game action
	 * 
	 * @param homeTeam name of the home team
	 * @param awayTeam name of the away team
	 * @return the created Game
	 */
	public Game startGame(String homeTeam, String awayTeam) {
		GameBuilder ctrl = new GameBuilder();
		return ctrl.createGame(homeTeam, awayTeam);
	}
}
