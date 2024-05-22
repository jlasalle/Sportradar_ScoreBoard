package org.lasalle.scoreboard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lasalle.scoreboard.game.Game;

/**
 * Tests dedicated to the "Game summary" feature. Get a summary of games by
 * total score. Those games with the same total score will be returned ordered
 * by the most recently added to our system.
 * 
 * @author Jonathan Lasalle
 */
public class GamesSummaryTest {

	/**
	 * A_TEAM: test football team
	 */
	private static final String A_TEAM = "A_TEAM";

	/**
	 * B_TEAM: test football team
	 */
	private static final String B_TEAM = "B_TEAM";

	/**
	 * New score for the "Home" team
	 */
	private static final int A_TEAM_NEW_SCORE = 1;

	/**
	 * New score for the "Away" team
	 */
	private static final int B_TEAM_NEW_SCORE = 2;

	/**
	 * Check that the "games summary" feature return the right String expression
	 */
	@Test
	public void gamesSummary() {
		ScoreBoardBuilder sbBuilder = new ScoreBoardBuilder();
		ScoreBoard scoreBoard = sbBuilder.createScoreBoard();
		ScoreBoardController ctrl = new ScoreBoardController(scoreBoard);
		ScoreBoardDisplay dis = new ScoreBoardDisplay(ctrl);

		// No games case
		String sum = dis.genSummary();
		assertEquals("", sum);

		// Single game case
		Game game = ctrl.startGame(A_TEAM, B_TEAM);
		ScoreBoardScoreController scoreCtrl = new ScoreBoardScoreController();
		scoreCtrl.updateScore(game, A_TEAM_NEW_SCORE, B_TEAM_NEW_SCORE);

		sum = dis.genSummary();
		String expectedRes = genExpectedSumLine(1, A_TEAM, A_TEAM_NEW_SCORE, B_TEAM, B_TEAM_NEW_SCORE);
		assertEquals(expectedRes, sum);
	}

	/**
	 * Generate a single summary line as it has to be generated
	 *
	 * @param num       Line number
	 * @param homeTeam  name of the home team
	 * @param homeScore score of the home team
	 * @param awayTeam  name of the away team
	 * @param awayScore score of the away team
	 * @return the expected associated displayable line
	 */
	private String genExpectedSumLine(int num, String homeTeam, int homeScore, String awayTeam, int awayScore) {
		return String.format("%s. %s %s - %s %s\n", num, homeTeam, homeScore, awayTeam, awayScore);
	}
}
