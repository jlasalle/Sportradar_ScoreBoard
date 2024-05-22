package org.lasalle.scoreboard.game;

/**
 * Model Class to represent Game
 * 
 * @author Jonathan Lasalle
 */
public class Game {

	/**
	 * Name of the home team
	 */
	private String _homeTeamName;

	/**
	 * Game constructor
	 * 
	 * @param homeTeamName name of the home team
	 */
	public Game(String homeTeamName) {
		_homeTeamName = homeTeamName;
	}

	public Object getHomeTeamName() {
		return _homeTeamName;
	}

}
