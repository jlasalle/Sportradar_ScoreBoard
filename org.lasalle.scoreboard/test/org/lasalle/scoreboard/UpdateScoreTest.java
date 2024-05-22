package org.lasalle.scoreboard;

import org.junit.Test;
import org.lasalle.scoreboard.game.Game;

/**
 * Tests dedicated to the "update score" feature. Receiving the pair score; home
 * team score and away team score. Updates a game score.
 * 
 * @author lasalle
 */
public class UpdateScoreTest {

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
	 * Start game test : check game creation and score initialization
	 */
	@Test
	public void updateScore() {
		ScoreBoardBuilder sbBuilder = new ScoreBoardBuilder();
		ScoreBoard scoreBoard = sbBuilder.createScoreBoard();

		ScoreBoardController ctrl = new ScoreBoardController(scoreBoard);
		Game game = ctrl.startGame(A_TEAM, B_TEAM);

		ctrl.updateScore(game, A_TEAM_NEW_SCORE, B_TEAM_NEW_SCORE);
	}
}
