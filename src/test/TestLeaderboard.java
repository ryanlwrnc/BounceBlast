// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Leaderboard;
import layout.Main;

public class TestLeaderboard {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestLeaderboardGetScreen() {
		Main main = new Main();
		Leaderboard leaderboard = new Leaderboard(main);
		Scene scene = leaderboard.getScene();
		assertTrue(scene instanceof Scene);
	}
}