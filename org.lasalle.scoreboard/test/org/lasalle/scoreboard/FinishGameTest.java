package org.lasalle.scoreboard;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.lasalle.scoreboard.game.Game;

/**
 * Tests dedicated to the "Finish Game" feature. Remove a game from the
 * scoreboard.
 * 
 * @author Jonathan Lasalle
 */
public class FinishGameTest {

	/**
	 * A_TEAM: test football team
	 */
	private static final String A_TEAM = "A_TEAM";

	/**
	 * B_TEAM: test football team
	 */
	private static final String B_TEAM = "B_TEAM";

	/**
	 * Test that the "finish game" feature effectively remove the game from the
	 * score board
	 */
	@Test
	public void finishGame() {
		ScoreBoardBuilder sbBuilder = new ScoreBoardBuilder();
		ScoreBoard scoreBoard = sbBuilder.createScoreBoard();

		ScoreBoardController sbCtrl = new ScoreBoardController(scoreBoard);
		Game g = sbCtrl.startGame(A_TEAM, B_TEAM);

		sbCtrl.finishGame(g);

		assertFalse(sbCtrl.containsGame(g));
	}

}
