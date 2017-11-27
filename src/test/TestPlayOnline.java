// Author: Elliot Kirk
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.PlayOnline;

public class TestPlayOnline {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	/*
	@Test
	public void TestPlayOnlineGetScreen() {
		Main main = new Main();
		PlayOnline playOnline = new PlayOnline(main);
		Scene scene = playOnline.getScene();
		assertTrue(scene instanceof Scene);
	}
	*/
}
