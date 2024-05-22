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
		}
	}

	public int getHomeTeamScore(Game game) {
		return game.getHomeTeamScore();
	}
}