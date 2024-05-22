package org.lasalle.scoreboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.lasalle.scoreboard.game.Game;

/**
 * Test of starting a new game
 * 
 * @author Jonathan Lasalle
 */
public class StartGameTest {

	/**
	 * A_TEAM: test football team
	 */
	private static final String A_TEAM = "A_TEAM";

	/**
	 * B_TEAM: test football team
	 */
	private static final String B_TEAM = "B_TEAM";

	/**
	 * Default Score
	 */
	private static final int DEFAULT_SCORE = 0;

	/**
	 * Start game test : check game creation and score initialization
	 */
	@Test
	public void startGame() {
		ScoreBoardController ctrl = new ScoreBoardController();
		Game g = ctrl.startGame(A_TEAM, B_TEAM);

		assertNotNull(g);
		assertEquals(A_TEAM, g.getHomeTeamName());
		assertEquals(B_TEAM, g.getAwayTeamName());

		assertEquals(DEFAULT_SCORE, g.getHomeTeamScore());
		assertEquals(DEFAULT_SCORE, g.getAwayTeamScore());
	}
}
