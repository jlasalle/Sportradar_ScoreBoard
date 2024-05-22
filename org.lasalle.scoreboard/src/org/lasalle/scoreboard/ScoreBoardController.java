package org.lasalle.scoreboard;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lasalle.scoreboard.game.Game;
import org.lasalle.scoreboard.game.GameBuilder;

/**
 * Controller dedicated to ScoreBoard management
 * 
 * @author Jonathan Lasalle
 */
public class ScoreBoardController {

	/**
	 * ScoreBoard managed by the controller
	 */
	private ScoreBoard _scoreBoard = null;

	/**
	 * Default constructor
	 */
	public ScoreBoardController(ScoreBoard scoreBoard) {
		_scoreBoard = scoreBoard;
	}

	/**
	 * Start game action
	 * 
	 * @param homeTeam name of the home team
	 * @param awayTeam name of the away team
	 * @return the created Game
	 */
	public Game startGame(String homeTeam, String awayTeam) {
		GameBuilder ctrl = new GameBuilder();
		Game newGame = ctrl.createGame(homeTeam, awayTeam);
		_scoreBoard.addGame(newGame);
		return newGame;
	}

	/**
	 * Finish game action
	 * 
	 * @param game Game to be removed
	 */
	public void finishGame(Game game) {
		_scoreBoard.removeGame(game);
	}

	/**
	 * Indicate if the current Scoreboard effectively contains the given game
	 * 
	 * @param g search Game
	 * @return true if the given Game is included in the scoreBoard
	 */
	public boolean containsGame(Game g) {
		return _scoreBoard.contains(g);
	}
	

	/**
	 * Get all Games managed by the ScoreBoard sorted by total Score (DESC)
	 * 
	 * @return an unmodifiable set of Games
	 */
	public List<Game> getSortedGames() {

		ScoreBoardScoreController scoreCtrl = new ScoreBoardScoreController();

		// Order all the games by total score
		List<Game> orderedList = _scoreBoard.getAllGames().stream().sorted(new Comparator<Game>() {
			@Override
			public int compare(Game g1, Game g2) {
				return (scoreCtrl.getHomeTeamScore(g2) + scoreCtrl.getAwayTeamScore(g2))
						- (scoreCtrl.getHomeTeamScore(g1) + scoreCtrl.getAwayTeamScore(g1));
			}
		}).collect(Collectors.toUnmodifiableList());

		return orderedList;
	}
}
