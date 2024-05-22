package org.lasalle.scoreboard;

import org.lasalle.scoreboard.game.Game;

/**
 * Controller dedicated to the management of the "scores" of the scoreboard
 * 
 * @author Jonathan Lasalle
 */
public class ScoreBoardScoreController {

	/**
	 * Update the score of the given team
	 * 
	 * @param game             the concerned game
	 * @param awayTeamNewScore the home team new score
	 * @param homeTeamNewScore the away team new score
	 */
	public void updateScore(Game game, int homeTeamNewScore, int awayTeamNewScore) {
		if (game != null) {
			game.setHomeTeamScore(homeTeamNewScore);
			game.setAwayTeamScore(awayTeamNewScore);
		}
	}

	/**
	 * Get the "Home" team score
	 * 
	 * @return the score of the "home" team
	 */
	public int getHomeTeamScore(Game game) {
		return game.getHomeTeamScore();
	}

	/**
	 * Get the "Away" team score
	 * 
	 * @return the score of the "home" team
	 */
	public int getAwayTeamScore(Game game) {
		return game.getAwayTeamScore();
	}
}