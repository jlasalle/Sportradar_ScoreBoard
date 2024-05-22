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
	 * C_TEAM: test football team
	 */
	private static final String C_TEAM = "C_TEAM";

	/**
	 * D_TEAM: test football team
	 */
	private static final String D_TEAM = "D_TEAM";

	/**
	 * E_TEAM: test football team
	 */
	private static final String E_TEAM = "E_TEAM";

	/**
	 * F_TEAM: test football team
	 */
	private static final String F_TEAM = "F_TEAM";

	/**
	 * Default Score
	 */
	private static final int DEFAULT_SCORE = 0;

	/**
	 * New score for the A team
	 */
	private static final int A_TEAM_NEW_SCORE = 1;

	/**
	 * New score for the B team
	 */
	private static final int B_TEAM_NEW_SCORE = 2;

	/**
	 * New score for the C team
	 */
	private static final int C_TEAM_NEW_SCORE = 3;

	/**
	 * New score for the D team
	 */
	private static final int D_TEAM_NEW_SCORE = 4;

	/**
	 * Check that the "games summary" feature return the right String expression
	 * (basic cases)
	 */
	@Test
	public void gamesSummary() {
		ScoreBoardBuilder sbBuilder = new ScoreBoardBuilder();
		ScoreBoard scoreBoard = sbBuilder.createScoreBoard();
		ScoreBoardController ctrl = new ScoreBoardController(scoreBoard);
		ScoreBoardDisplay dis = new ScoreBoardDisplay(ctrl);
		ScoreBoardScoreController scoreCtrl = new ScoreBoardScoreController();

		// No games case
		String sum = dis.genSummary();
		assertEquals("", sum);

		// Single game case
		Game game = ctrl.startGame(A_TEAM, B_TEAM);
		scoreCtrl.updateScore(game, A_TEAM_NEW_SCORE, B_TEAM_NEW_SCORE);

		sum = dis.genSummary();
		String expectedRes = genExpectedSumLine(1, A_TEAM, A_TEAM_NEW_SCORE, B_TEAM, B_TEAM_NEW_SCORE);
		assertEquals(expectedRes, sum);
	}

	/**
	 * Check that the "games summary" feature return the right String expression.
	 * Change order : 2 games, the second one having a higher total score (having
	 * then to be displayed first).
	 */
	@Test
	public void gamesSummary_order() {
		ScoreBoardBuilder sbBuilder = new ScoreBoardBuilder();
		ScoreBoard scoreBoard = sbBuilder.createScoreBoard();
		ScoreBoardController ctrl = new ScoreBoardController(scoreBoard);
		ScoreBoardDisplay dis = new ScoreBoardDisplay(ctrl);
		ScoreBoardScoreController scoreCtrl = new ScoreBoardScoreController();

		// First Check
		// A 1 - B 2
		// C 0 - D 0
		Game abGame = ctrl.startGame(A_TEAM, B_TEAM);
		scoreCtrl.updateScore(abGame, A_TEAM_NEW_SCORE, B_TEAM_NEW_SCORE);

		Game cdGame = ctrl.startGame(C_TEAM, D_TEAM);

		String sum = dis.genSummary();
		String expectedRes = genExpectedSumLine(1, A_TEAM, A_TEAM_NEW_SCORE, B_TEAM, B_TEAM_NEW_SCORE)
				+ genExpectedSumLine(2, C_TEAM, DEFAULT_SCORE, D_TEAM, DEFAULT_SCORE);
		assertEquals(expectedRes, sum);

		// Second Check
		// C 3 - D 4
		// A 1 - B 2
		scoreCtrl.updateScore(cdGame, C_TEAM_NEW_SCORE, D_TEAM_NEW_SCORE);
		sum = dis.genSummary();
		expectedRes = genExpectedSumLine(1, C_TEAM, C_TEAM_NEW_SCORE, D_TEAM, D_TEAM_NEW_SCORE)
				+ genExpectedSumLine(2, A_TEAM, A_TEAM_NEW_SCORE, B_TEAM, B_TEAM_NEW_SCORE);
		assertEquals(expectedRes, sum);
	}

	/**
	 * Check that the "games summary" feature return the right String expression. 3
	 * games with the same total: the most recent must be displayed first.
	 */
	@Test
	public void gamesSummary_equalityCase() {
		ScoreBoardBuilder sbBuilder = new ScoreBoardBuilder();
		ScoreBoard scoreBoard = sbBuilder.createScoreBoard();
		ScoreBoardController ctrl = new ScoreBoardController(scoreBoard);
		ScoreBoardDisplay dis = new ScoreBoardDisplay(ctrl);

		// Created data
		// A 0 - B 0
		// C 0 - D 0
		// E 0 - F 0
		ctrl.startGame(A_TEAM, B_TEAM);
		ctrl.startGame(C_TEAM, D_TEAM);
		ctrl.startGame(E_TEAM, F_TEAM);

		// Expected result
		// E 0 - F 0
		// C 0 - D 0
		// A 0 - B 0		
		String sum = dis.genSummary();
		String expectedRes = genExpectedSumLine(1, E_TEAM, DEFAULT_SCORE, F_TEAM, DEFAULT_SCORE)
				+ genExpectedSumLine(2, C_TEAM, DEFAULT_SCORE, D_TEAM, DEFAULT_SCORE)
				+ genExpectedSumLine(3, A_TEAM, DEFAULT_SCORE, B_TEAM, DEFAULT_SCORE);
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
