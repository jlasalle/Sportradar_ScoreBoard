package org.lasalle.scoreboard;

import java.util.Collections;
import java.util.Set;

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
	 * Get all Games managed by the ScoreBoard
	 * 
	 * @return an unmodifiable set of Games
	 */
	public Set<Game> getAllGames() {
		return Collections.unmodifiableSet(_scoreBoard.getAllGames());
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
}
