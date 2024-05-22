package org.lasalle.scoreboard;

import java.util.ArrayList;
import java.util.List;

import org.lasalle.scoreboard.game.Game;

/**
 * Model Class to represent Game
 * 
 * @author Jonathan Lasalle
 */
public class ScoreBoard {

	/**
	 * Manage the list of all games associated to the Scoreboard
	 */
	private List<Game> _allGames = new ArrayList<>();

	/**
	 * Default Constructor
	 */
	public ScoreBoard() {
	}

	/**
	 * Add a new Game in the scoreboard
	 * 
	 * @param newGame the game to add
	 */
	public void addGame(Game newGame) {
		_allGames.add(newGame);
	}

	/**
	 * Remove a game from the scoreboard
	 * 
	 * @param game the game to remove
	 */
	public void removeGame(Game game) {
		_allGames.remove(game);
	}

	/**
	 * Check if the scoreboard contains the given game
	 * 
	 * @param g searched game
	 * @return true if the game is effectively managed by the scoreboard
	 */
	public boolean contains(Game g) {
		return _allGames.contains(g);
	}

	/**
	 * Get all Games managed by the ScoreBoard
	 * 
	 * @return a set of Games
	 */
	public List<Game> getAllGames() {
		return _allGames;
	}
}
