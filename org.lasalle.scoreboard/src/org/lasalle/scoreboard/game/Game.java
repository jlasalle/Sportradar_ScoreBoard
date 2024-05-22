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
	 * The score of the "Home" team
	 */
	private int _homeTeamScore = 0;

	/**
	 * The score of the "Away" team
	 */
	private int _awayTeamScore = 0;

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
	 * Get the "Home" team score
	 * 
	 * @return the score of the "home" team
	 */
	public int getHomeTeamScore() {
		return _homeTeamScore;
	}

	/**
	 * Update the "Home" team score
	 * 
	 * @param homeTeamNewScore the new score
	 */
	public void setHomeTeamScore(int homeTeamNewScore) {
		_homeTeamScore = homeTeamNewScore;
	}

	/**
	 * Get away team score
	 * 
	 * @return the away team score
	 */
	public int getAwayTeamScore() {
		return _awayTeamScore;
	}

	/**
	 * Update the "Away" team score
	 * 
	 * @param awayTeamNewScore the new score
	 */
	public void setAwayTeamScore(int awayTeamNewScore) {
		_awayTeamScore = awayTeamNewScore;
	}

}