// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.Settings;

public class TestSettings {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	/*
	@Test
	public void TestSettingsGetScreen() {
		Main main = new Main();
		Settings settings = new Settings(main);
		Scene scene = settings.getScene();
		assertTrue(scene instanceof Scene);
	}
	*/
}