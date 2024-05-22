package org.lasalle.scoreboard.game;

/**
 * Builder dedicated to "Game" items
 * 
 * @author Jonathan Lasalle
 */
public class GameBuilder {

	/**
	 * Create Game action
	 * 
	 * @param homeTeam name of the home team
	 * @param awayTeam name of the away team
	 * @return the created Game
	 */
	public Game createGame(String homeTeam, String awayTeam) {
		return new Game();
	}
}
