package org.lasalle.scoreboard;

import org.lasalle.scoreboard.game.Game;

/**
 * Visualization of the ScoreBoard data
 * 
 * @author Jonathan Lasalle
 */
public class ScoreBoardDisplay {

	/**
	 * Board main controller
	 */
	private ScoreBoardController _boardCtrl = null;

	/**
	 * Board score controller
	 */
	private ScoreBoardScoreController _scoreCtrl = null;

	/**
	 * Display management constructor
	 * 
	 * @param boardCtrl Concerned scoreBoard
	 */
	public ScoreBoardDisplay(ScoreBoardController boardCtrl) {
		_boardCtrl = boardCtrl;
		_scoreCtrl = new ScoreBoardScoreController();
	}

	/**
	 * Generate the summary
	 * 
	 * @return
	 */
	public String genSummary() {
		String result = "";
		int index = 1;
		for (Game g : _boardCtrl.getSortedGames()) {
			if (g != null) {
				result += genSingleLine(index, g);
				index++;
			}
		}
		return result;
	}

	/**
	 * Generate the summary line for a given game at the given index
	 * 
	 * @param index index of the game in the list
	 * @param game  the concerned game
	 * @return a String value
	 */
	private String genSingleLine(int index, Game game) {
		int homeScore = _scoreCtrl.getHomeTeamScore(game);
		int awayScore = _scoreCtrl.getAwayTeamScore(game);

		return String.format("%s. %s %s - %s %s\n", index, game.getHomeTeamName(), homeScore, game.getAwayTeamName(),
				awayScore);
	}
}
