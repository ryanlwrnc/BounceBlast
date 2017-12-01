// Author: Won Young Son
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.InGame;

public class TestInGame {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestInGameGetScreen() {
		InGame inGame = new InGame();
		Scene scene = inGame.getScene();
		assertTrue(scene instanceof Scene);
	}
}
