// Author: Won Young Son
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.InGame;
import layout.Main;

public class TestInGame {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void testInGameGetScreen() {
		Main main = new Main();
		InGame inGame = new InGame(main);
		assertTrue(inGame instanceof Scene);
	}
}
