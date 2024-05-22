package org.lasalle.scoreboard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests dedicated to the "Game summary" feature. Get a summary of games by
 * total score. Those games with the same total score will be returned ordered
 * by the most recently added to our system.
 * 
 * @author Jonathan Lasalle
 */
public class GamesSummaryTest {

	/**
	 * Check that the "games summary" feature return the right String expression
	 */
	@Test
	public void gamesSummary() {
		ScoreBoardBuilder sbBuilder = new ScoreBoardBuilder();
		ScoreBoard scoreBoard = sbBuilder.createScoreBoard();

		ScoreBoardDisplay dis = new ScoreBoardDisplay(scoreBoard);

		// No games case
		String sum = dis.genSummary();
		assertEquals("", sum);
	}
}
