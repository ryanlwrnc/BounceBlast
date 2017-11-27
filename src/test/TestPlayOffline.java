// Author: Elliot Kirk
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.PlayOffline;

public class TestPlayOffline {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestPlayOfflineGetScreen() {
		Main main = new Main();
		PlayOffline playOffline = new PlayOffline(main);
		Scene scene = playOffline.getScene();
		assertTrue(scene instanceof Scene);
	}
}