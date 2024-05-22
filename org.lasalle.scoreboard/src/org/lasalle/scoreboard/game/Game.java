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
	 * Name of the away team
	 */
	private String _awayTeamName;

	/**
	 * Game constructor
	 * 
	 * @param homeTeamName name of the home team
	 * @param awayTeamName name of the away team
	 */
	public Game(String homeTeamName, String awayTeamName) {
		_homeTeamName = homeTeamName;
		_awayTeamName = awayTeamName;
	}

	/**
	 * Get the home team name
	 * 
	 * @return the name of the home team
	 */
	public String getHomeTeamName() {
		return _homeTeamName;
	}

	/**
	 * Get the away team name
	 * 
	 * @return the name of the away team
	 */
	public String getAwayTeamName() {
		return _awayTeamName;
	}

	/**
	 * Get home team score
	 * 
	 * @return the home team score
	 */
	public int getHomeTeamScore() {
		return 0;
	}

	/**
	 * Get away team score
	 * 
	 * @return the away team score
	 */
	public int getAwayTeamScore() {
		return 0;
	}
}
