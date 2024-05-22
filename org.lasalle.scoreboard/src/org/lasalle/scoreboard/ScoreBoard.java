package org.lasalle.scoreboard;

import java.util.HashSet;
import java.util.Set;

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
	private Set<Game> _allGames = new HashSet<>();

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

}
