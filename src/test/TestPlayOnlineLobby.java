// Author: Elliot Kirk
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.PlayOnlineLobby;

public class TestPlayOnlineLobby {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestPlayOnlineLobbyGetScreen() {
		Main main = new Main();
		PlayOnlineLobby playOnlineLobby = new PlayOnlineLobby(main);
		Scene scene = playOnlineLobby.getScene();
		assertTrue(scene instanceof Scene);
	}
}