package org.lasalle.scoreboard;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.lasalle.scoreboard.game.Game;

public class StartGameTest {

	/**
	 * A_TEAM: test football team
	 */
	protected static final String A_TEAM = "A_TEAM";
	/**
	 * B_TEAM: test football team
	 */
	protected static final String B_TEAM = "B_TEAM";

	@Test
	public void startGame() {
		ScoreBoardController ctrl = new ScoreBoardController();
		Game g = ctrl.startGame(A_TEAM, B_TEAM);

		assertNotNull(g);
	}
}
